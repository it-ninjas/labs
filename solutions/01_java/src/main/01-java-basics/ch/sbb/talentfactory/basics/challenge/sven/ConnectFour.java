/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021
 */
package ch.sbb.talentfactory.basics.challenge.sven;

/**
 * Solutions for connect four check.
 *
 * @author u236180 (Sven Jaun)
 */
public class ConnectFour implements ConnectFourCheck {
    @Override
    public String checkWin(String[][] board) {
        if (!this.isBoardValid(board)) {
            return "";
        }
        int dimensionX = board.length - 1;
        int dimensionY = board[0].length - 1;
        String cs = ""; // Current String
        for (int i = 0, boardLength = board.length; i < boardLength; i++) {
            for (int j = 0, stringsLength = board[i].length; j < stringsLength; j++) {
                cs = board[i][j];
                if (cs.equals(" ")) {
                    continue;
                }

                if (i + 3 <= dimensionX && j - 3 >= 0 && board[i + 1][j - 1].equals(cs) && board[i + 2][j - 2].equals(cs) && board[i + 3][j - 3].equals(cs) // LEFT DOWN
                        || i + 3 <= dimensionX && j + 3 <= dimensionY && board[i + 1][j + 1].equals(cs) && board[i + 2][j + 2].equals(cs) && board[i + 3][j + 3].equals(cs) // RIGHT DOWN
                        || j + 3 <= dimensionY && board[i][j + 1].equals(cs) && board[i][j + 2].equals(cs) && board[i][j + 3].equals(cs) // RIGHT
                        || i + 3 <= dimensionX && board[i + 1][j].equals(cs) && board[i + 2][j].equals(cs) && board[i + 3][j].equals(cs)) { // DOWN
                    return cs;
                }
            }
        }

        return "";
    }

    private boolean isBoardValid(String[][] board) {
        if (board.length < 4 || board[0].length < 4) {
            return false;
        }
        int length = board[0].length;
        for (String[] arr : board) {
            if (arr.length != length) {
                return false;
            }
            for (String string : arr) {
                if (string.matches("^(?![XO ]).*$")) {
                    return false;
                }
            }
        }
        return true;
    }
}