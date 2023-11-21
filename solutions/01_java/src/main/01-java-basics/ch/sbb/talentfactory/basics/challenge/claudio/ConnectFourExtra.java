/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021
 */
package ch.sbb.talentfactory.basics.challenge.claudio;

import java.util.regex.Pattern;

/**
 * Solution for basic challenge.
 *
 * @author u210148 (Claudio Zesiger)
 */
public class ConnectFourExtra implements ConnectFourCheck {

    private static final String WHITESPACE = " ";

    private static final String X = "X";

    private static final String O = "O";

    private static final Pattern X_PATTERN = Pattern.compile(".*[X]{4}.*");

    private static final Pattern O_PATTERN = Pattern.compile(".*[O]{4}.*");

    public static void main(String[] args) {
        String[][] board = {
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", "O", " ", " ", " ", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", " ", " ", "O", "O", "X", "X", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", "O", "X", "X", "X", "O", "O", " ", " ", " ", " ", " ",},
                {" ", " ", " ", " ", "X", "O", "X", "O", "X", "O", " ", " ", " ", " ", " ",},
                {"X", "X", "X", "O", "X", "O", "O", "O", "X", "O", "X", "O", " ", " ", " ",},
        };

        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();
            String result = new ConnectFourExtra().checkWin(board);
            long duration = System.nanoTime() - start;
            System.out.println("Duration: " + (duration / 1000.0) + " micro-seconds");

            System.out.println("Winner: " + result);
        }
    }

    @Override
    public String checkWin(String[][] board) {
        if (this.isBoardValid(board)) {
            String horizontalWin = this.checkWinHorizontally(board);
            if (WHITESPACE.equals(horizontalWin)) {
                String verticalWin = this.checkWinVertically(board);
                if (WHITESPACE.equals(verticalWin)) {
                    String diagonalWinLeft = this.checkDiagonalWinLeft(board);
                    if (WHITESPACE.equals(diagonalWinLeft)) {
                        return checkDiagonalWinRight(board);
                    }
                    return diagonalWinLeft;
                }
                return verticalWin;
            }
            return horizontalWin;
        }
        return null;
    }

    private boolean isBoardValid(String[][] board) {
        // board should not be null
        if (board == null) {
            return false;
        }

        // board width must be at least 4
        if (board.length < 4) {
            return false;
        }

        // board must have columns of identical heights
        int size = -1;
        for (String[] arr : board) {
            if (arr.length < 4) {
                return false;
            }
            if (size == -1) {
                size = arr.length;
                continue;
            }
            if (size != arr.length) {
                return false;
            }
        }

        // board must be filled with " ", "O" or "X"
        for (String[] arr : board) {
            for (String s : arr) {
                if (!" XO".contains(s)) {
                    return false;
                }
            }
        }

        return true;
    }

    private String checkWinHorizontally(String[][] board) {
        // all string arrays has the same length
        for (int row = 0; row < board[0].length; row++) {
            StringBuilder sb = new StringBuilder();
            for (String[] strings : board) {
                sb.append(strings[row]);
            }
            if (sb.length() >= 4) {
                if (X_PATTERN.matcher(sb.toString()).matches()) {
                    return X;
                }
                if (O_PATTERN.matcher(sb.toString()).matches()) {
                    return O;
                }
            }
        }
        return WHITESPACE;
    }

    private String checkWinVertically(String[][] board) {
        for (String[] col : board) {
            StringBuilder sb = new StringBuilder();
            for (String s : col) {
                sb.append(s);
            }
            if (sb.length() >= 4) {
                if (X_PATTERN.matcher(sb.toString()).matches()) {
                    return X;
                }
                if (O_PATTERN.matcher(sb.toString()).matches()) {
                    return O;
                }
            }
        }
        return WHITESPACE;
    }

    private String checkDiagonalWinLeft(String[][] board) {
        int width = board.length;
        int height = board[0].length;
        for (int i = 0; i < width + height; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                int k = i - j;
                if (k < board.length && j < board.length) {
                    sb.append(board[k][j]);
                }
            }
            if (sb.length() >= 4) {
                if (X_PATTERN.matcher(sb.toString()).matches()) {
                    return X;
                }
                if (O_PATTERN.matcher(sb.toString()).matches()) {
                    return O;
                }
            }
        }
        return WHITESPACE;
    }

    private String checkDiagonalWinRight(String[][] board) {
        int width = board.length;
        int height = board[0].length;
        for (int i = height - 1; i >= -width; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < height + width - i; j++) {
                int k = i + j;
                if (j < width && k >= 0 && k < height) {
                    sb.append(board[j][k]);
                }
            }
            if (sb.length() >= 4) {
                if (X_PATTERN.matcher(sb.toString()).matches()) {
                    return X;
                }
                if (O_PATTERN.matcher(sb.toString()).matches()) {
                    return O;
                }
            }
        }
        return WHITESPACE;
    }

}
