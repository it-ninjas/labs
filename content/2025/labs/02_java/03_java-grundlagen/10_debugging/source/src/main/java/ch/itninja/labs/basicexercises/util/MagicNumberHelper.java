package ch.itninja.labs.basicexercises.util;

/**
 * DebugHelper provides a deterministic but non-trivial mapping from integers to integers,
 * useful for debugging exercises that require conditional breakpoints.
 *
 * Features:
 * - Two consecutive calls with the same input in the same epoch produce different values
 *   (output depends on internal state/history).
 * - If more than thresholdMs (default: 20 ms) pass between calls, a new epoch starts:
 *   the internal state is re-initialized deterministically from (seed, epochId),
 *   and the same first N calls in each epoch repeat the same values.
 *
 * Usage (default instance):
 *   int v1 = DebugHelper.getSecretValue(10);
 *   int v2 = DebugHelper.getSecretValue(10); // different from v1 (same epoch)
 *   Thread.sleep(200);
 *   int v3 = DebugHelper.getSecretValue(10); // same as v1 (new epoch)
 */
public final class MagicNumberHelper {

    private MagicNumberHelper() { /* no instances */ }

    // Default mapper: deterministic with fixed seed and 20 ms threshold
    private static final EpochHistoryMapper DEFAULT_MAPPER =
            new EpochHistoryMapper(12345, 20);

    /**
     * Returns a secret value for the given input using the default mapper.
     */
    public static int getSecretValue(int input) {
        return DEFAULT_MAPPER.getSecretValue(input);
    }

    /**
     * Returns the current epoch id of the default mapper.
     */
    public static int getCurrentEpochId() {
        return DEFAULT_MAPPER.getEpochId();
    }

    /**
     * Resets the default mapper to epoch 0 and initial state.
     */
    public static void resetDefault() {
        DEFAULT_MAPPER.reset();
    }

    // =====================================================================
    //  Inner class: stateful, epoch-based, history-dependent number mapper
    // =====================================================================

    /**
     * Stateful mapper whose output depends on:
     * - seed
     * - current epoch
     * - previous output (internal state)
     * - input
     * - position within epoch
     *
     * Same sequence of calls within an epoch produces the same sequence of outputs.
     * Waiting more than thresholdMs between calls starts a new epoch with the same
     * initial state, so the sequence repeats.
     */
    public static final class EpochHistoryMapper {

        private final int seed;
        private final long thresholdMs;

        private int epochId = 0;
        private long lastCallNanos = 0L;

        // Per-epoch evolving state
        private int state;
        private int position = 0;

        public EpochHistoryMapper(int seed) {
            this(seed, 20);
        }

        public EpochHistoryMapper(int seed, long thresholdMs) {
            this.seed = seed;
            this.thresholdMs = thresholdMs;
            startNewEpoch();
        }

        /**
         * Returns a value that depends on (seed, epochId, previous state, input, position).
         * Two consecutive calls with the same input within the same epoch yield different outputs.
         * After a gap > thresholdMs, a new epoch starts and the first calls repeat deterministically.
         */
        public synchronized int getSecretValue(int input) {
            long now = System.nanoTime();
            if (lastCallNanos != 0L && nanosToMillis(now - lastCallNanos) > thresholdMs) {
                startNewEpoch();
            }
            lastCallNanos = now;

            // Output depends on evolving state and current input
            int out = strongMix(state, input, epochId, position);

            // Evolve state for next call
            state = evolve(state, out, input, epochId, position);

            position++;
            return out;
        }

        /**
         * Returns the current epoch id.
         */
        public synchronized int getEpochId() {
            return epochId;
        }

        /**
         * Resets everything to epoch 0 with initial state.
         */
        public synchronized void reset() {
            epochId = 0;
            lastCallNanos = 0L;
            startNewEpoch();
        }

        // ------- internals -------

        private void startNewEpoch() {
            state = initialState(seed, epochId);
            position = 0;
            epochId++;
        }

        private static int initialState(int seed, int epochId) {
            int x = seed ^ (epochId * 0x9E3779B9);
            x ^= Integer.rotateLeft(x, 13);
            x *= 0x7FEB352D;
            x ^= (x >>> 15);
            x *= 0x846CA68B;
            x ^= (x >>> 16);
            return x;
        }

        private static int strongMix(int prevState, int input, int epoch, int pos) {
            int x = prevState;
            x ^= Integer.rotateLeft(input * 0x9E3779B9, (pos & 31));
            x ^= (epoch * 0x7F4A7C15);
            x ^= (x >>> 16);
            x *= 0x7FEB352D;
            x ^= (x >>> 15);
            x *= 0x846CA68B;
            x ^= (x >>> 16);
            return x;
        }

        private static int evolve(int prevState, int out, int input, int epoch, int pos) {
            int y = out ^ Integer.rotateLeft(prevState, (pos % 29) + 1);
            y ^= (input * 0x85EBCA6B);
            y ^= Integer.rotateLeft(epoch, (pos % 5) + 3);
            y *= 0xC2B2AE35;
            y ^= (y >>> 13);
            return y;
        }

        private static long nanosToMillis(long nanos) {
            return nanos / 1_000_000L;
        }
    }
}
