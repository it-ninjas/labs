/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021
 */
package ch.sbb.talentfactory.basics.challenge.claudio3;

/**
 * Solution for basic challenge.
 *
 * @author u210148 (Claudio Zesiger)
 */
public class ConnectFourExtra implements ConnectFourCheck {

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
            String result = new ch.sbb.talentfactory.basics.challenge.claudio2.ConnectFourExtra().checkWin(board);
            long duration = System.nanoTime() - start;
            System.out.println("Duration: " + (duration / 1000.0) + " micro-seconds");

            System.out.println("Winner: " + result);
        }
    }

    @Override
    public String checkWin(String[][] board) {
        String[] players = {"X", "O"};
        for (String player : players) {
            // vertical check
            String winner = this.verticalCheck(board, player);
            if (!" ".equals(winner)) {
                return winner;
            }

            // horizontal check
            winner = this.horizontalCheck(board, player);
            if (!" ".equals(winner)) {
                return winner;
            }
            // diagonal check
            winner = this.diagonalCheck(board, player);
            if (!" ".equals(winner)) {
                return winner;
            }
        }
        return " ";
    }

    private String verticalCheck(String[][] board, String player) {
        for (int col = 0; col < board.length - 3; col++) {
            for (int row = 0; row < board[col].length; row++) {
                if (board[col][row].equals(player) && board[col + 1][row].equals(player) && board[col + 2][row].equals(player) && board[col + 3][row].equals(player)) {
                    return player;
                }
            }
        }
        return " ";
    }

    private String horizontalCheck(String[][] board, String player) {
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[col].length - 3; row++) {
                if (board[col][row].equals(player) && board[col][row + 1].equals(player) && board[col][row + 2].equals(player) && board[col][row + 3].equals(player)) {
                    return player;
                }
            }
        }
        return " ";
    }

    private String diagonalCheck(String[][] board, String player) {
        for (int col = 3; col < board.length; col++) {
            for (int row = 0; row < board[col].length - 3; row++) {
                if (board[col][row].equals(player) && board[col - 1][row + 1].equals(player) && board[col - 2][row + 2].equals(player) && board[col - 3][row + 3].equals(player)) {
                    return player;
                }
            }
        }
        for (int col = 3; col < board.length; col++) {
            for (int row = 3; row < board[col].length; row++) {
                if (board[col][row].equals(player) && board[col - 1][row - 1].equals(player) && board[col - 2][row - 2].equals(player) && board[col - 3][row - 3].equals(player))
                    return player;
            }
        }
        return " ";
    }

}
