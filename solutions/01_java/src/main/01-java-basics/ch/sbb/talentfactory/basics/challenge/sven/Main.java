package ch.sbb.talentfactory.basics.challenge.sven;

public class Main {
    ConnectFour connectFour = new ConnectFour();

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {

        String[][] x = {
                {" ", " ", " ", " ", "X", "O", "X", "X"},
                {" ", " ", " ", " ", "X", "X", "O", "O"},
                {"X", " ", "O", "O", "X", "X", "X", "O"},
                {"O", "O", "X", "O", "X", "X", "O", "O"},
                {"O", "X", "X", "X", "O", "O", "X", "X"},
        };

        String[][] o = {
                {" ", " ", " ", " ", "X", "O", "X", "X"},
                {" ", " ", " ", " ", "X", "X", "O", "O"},
                {"X", "O", "O", "O", "O", "X", "X", "O"},
                {"O", "O", "X", "O", "X", "X", "O", "O"},
                {"O", "X", "X", "X", "O", "O", "X", "X"},
        };

        String[][] x2 = {
                {" ", " ", "O", "O", "X",},
                {"X", "X", "X", "X", "O",},
                {"X", "X", "O", "O", "O",},
                {"X", "O", "O", "O", "X",},
                {"O", "X", "X", "O", "X",},
        };

        System.out.printf("\"%s\"\n", this.connectFour.checkWin(x));
        System.out.printf("\"%s\"\n", this.connectFour.checkWin(o));
        System.out.printf("arr \"%s\"\n", this.connectFour.checkWin(x2));

    }
}
