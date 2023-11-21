package map;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K, V> implements MyMapInterface<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private List<Entry<K, V>>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new ArrayList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new ArrayList<>();
        }
        size = 0;
    }

    private int getBucketIndex(Object key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % buckets.length);
    }

    @Override
    public V put(K key, V value) {
        int bucketIndex = getBucketIndex(key);

        for (Entry<K, V> entry : buckets[bucketIndex]) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        buckets[bucketIndex].add(new Entry<>(key, value, key.hashCode()));
        size++;
        return null;
    }

    @Override
    public V get(Object key) {
        int bucketIndex = getBucketIndex(key);

        for (Entry<K, V> entry : buckets[bucketIndex]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (List<Entry<K, V>> bucket : buckets) {
            bucket.clear();
        }
        size = 0;
    }

    @Override
    public V remove(Object key) {
        int bucketIndex = getBucketIndex(key);

        for (Entry<K, V> entry : buckets[bucketIndex]) {
            if (entry.key.equals(key)) {
                V removedValue = entry.value;
                buckets[bucketIndex].remove(entry);
                size--;
                return removedValue;
            }
        }

        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        int bucketIndex = getBucketIndex(key);

        for (Entry<K, V> entry : buckets[bucketIndex]) {
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                if (entry.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                sb.append(entry.key).append("=").append(entry.value).append(", ");
            }
        }
        // Remove the trailing comma and space if there are entries
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    private static class Entry<K, V> {
        K key;
        V value;
        int hashCode;

        Entry(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }
    }
}
