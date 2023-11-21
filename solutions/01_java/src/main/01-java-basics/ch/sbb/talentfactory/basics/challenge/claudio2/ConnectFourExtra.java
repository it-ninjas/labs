/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021
 */
package ch.sbb.talentfactory.basics.challenge.claudio2;

import java.util.regex.Pattern;

/**
 * Solution for basic challenge.
 *
 * @author u210148 (Claudio Zesiger)
 */
public class ConnectFourExtra implements ConnectFourCheck {

    private static final int INNER_SQUARE_WIDTH = 4;

    private static final Pattern X_PATTERN = Pattern.compile(".*[X]{" + INNER_SQUARE_WIDTH + "}.*");

    private static final Pattern O_PATTERN = Pattern.compile(".*[O]{" + INNER_SQUARE_WIDTH + "}.*");

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
            System.out.println("Board is valid");
            for (int i = 0; i < board.length - INNER_SQUARE_WIDTH + 1; i++) {
                for (int j = 0; j < board[i].length - INNER_SQUARE_WIDTH + 1; j++) {
                    String[][] innerSquare = this.buildInnerSquare(board, i, j);
                    String winner = this.checkInnerSquare(innerSquare);
                    if (!" ".equals(winner)) {
                        return winner;
                    }
                }
            }
        }
        return " ";
    }

    private boolean isBoardValid(String[][] board) {
        // board should not be null
        if (board == null) {
            return false;
        }

        // board width must be at least inner square width
        if (board.length < INNER_SQUARE_WIDTH) {
            return false;
        }

        // board must have columns of identical heights and the height must be at least inner square width
        int size = -1;
        for (String[] arr : board) {
            if (arr.length < INNER_SQUARE_WIDTH) {
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

    private String[][] buildInnerSquare(String[][] board, int i, int j) {
        String[][] innerSquare = new String[4][4];
        for (int a = i, row = 0; a < i + INNER_SQUARE_WIDTH; a++, row++) {
            for (int b = j, col = 0; b < j + INNER_SQUARE_WIDTH; b++, col++) {
                innerSquare[row][col] = board[b][a];
            }
        }
        return innerSquare;
    }

    private String checkInnerSquare(String[][] innerSquare) {
        if (this.containsEnoughTokens(innerSquare)) {
            // columns
            String winner = this.checkColumns(innerSquare);
            if (" ".equals(winner)) {
                // rows
                winner = this.checkRows(innerSquare);
                if (" ".equals(winner)) {
                    // diagonals
                    winner = this.checkDiagonals(innerSquare);
                }
            }
            return winner;
        }
        return " ";
    }

    private boolean containsEnoughTokens(String[][] innerSquare) {
        int xCounter = 0;
        int oCounter = 0;
        for (String[] col : innerSquare) {
            for (String row : col) {
                if ("X".equals(row)) {
                    xCounter++;
                }
                if ("O".equals(row)) {
                    oCounter++;
                }
            }
        }
        return xCounter >= 4 || oCounter >= 4;
    }

    private String checkColumns(String[][] innerSquare) {
        for (String[] col : innerSquare) {
            StringBuilder sb = new StringBuilder();
            for (String value : col) {
                sb.append(value);
            }
            String winner = this.checkConnectFour(sb);
            if (!" ".equals(winner)) {
                return winner;
            }
        }
        return " ";
    }

    private String checkRows(String[][] innerSquare) {
        for (int i = 0; i < INNER_SQUARE_WIDTH; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < INNER_SQUARE_WIDTH; j++) {
                sb.append(innerSquare[j][i]);
            }
            String winner = this.checkConnectFour(sb);
            if (!" ".equals(winner)) {
                return winner;
            }
        }
        return " ";
    }

    private String checkDiagonals(String[][] innerSquare) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < INNER_SQUARE_WIDTH && j < INNER_SQUARE_WIDTH; i++, j++) {
            sb.append(innerSquare[i][j]);
        }
        String winner = this.checkConnectFour(sb);
        if (!" ".equals(winner)) {
            return winner;
        }

        sb = new StringBuilder();
        for (int i = INNER_SQUARE_WIDTH - 1, j = 0; i >= 0 && j < INNER_SQUARE_WIDTH; i--, j++) {
            sb.append(innerSquare[i][j]);
        }
        winner = this.checkConnectFour(sb);
        if (!" ".equals(winner)) {
            return winner;
        }

        return " ";
    }

    private String checkConnectFour(StringBuilder sb) {
        if (X_PATTERN.matcher(sb.toString()).matches()) {
            return "X";
        }
        if (O_PATTERN.matcher(sb.toString()).matches()) {
            return "O";
        }
        return " ";
    }

}
