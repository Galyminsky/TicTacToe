import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        start();

    }
    static void start() {
        char[][] field = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        do {
            doPlayerMove(field);
            if (isWin(field, 'X')) {
                System.out.println("Congrats!!! You are winner!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Oh.. It's draw! See you soon.");
                break;
            }
            drawField(field);

            doAIMove(field);
            if (isWin(field, 'O')) {
                System.out.println("Sorry!!! You are loser!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Oh.. It's draw! See you soon.");
                break;
            }
            drawField(field);

        } while(true);

        System.out.println("Final state:");
        drawField(field);
    }

    static boolean isWin(char[][] field, char sign) {
        // horizontal
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign) {
                return true;
            }
        }

        // vertical
        for (int i = 0; i < field.length; i++) {
            if (field[0][i] == sign && field[1][i] == sign && field[2][i] == sign) {
                return true;
            }
        }

        // diagonals
        if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign) {
            return true;
        }
        if (field[0][2] == sign && field[1][1] == sign && field[2][0] == sign) {
            return true;
        }

        return false;
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (isEmptyCell(field, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isEmptyCell(char[][] field, int h, int v) {
        return field[h][v] == '-';
    }

    static boolean isNotEmptyCell(char[][] field, int h, int v) {
        // field[1][1] = '-'
        // isEmptyCell returns true
        // !isEmptyCell
        //          returns true
        //          !true

        // field[1][1] = 'X'
        // isEmptyCell returns false
        // Assert isNotEmptyCell
        // !isEmptyCell
        //          returns false
        //          !false => true
        //          return true

        return !isEmptyCell(field, h, v);
    }

    static void doAIMove(char[][] field) {
        Random random = new Random();
        int h, v;

        do {
            h = random.nextInt(3);
            v = random.nextInt(3);
        } while(isNotEmptyCell(field, h, v));

        field[h][v] = 'O';
    }

    static void doPlayerMove(char[][] field) {
        int h, v;

        do {
            System.out.println("Please enter coordinates...");
            h = getCoordinate('h');
            v = getCoordinate('v');
        } while (isNotEmptyCell(field, h, v));

        field[h][v] = 'X';
    }

    static int getCoordinate(char axis) {
        Scanner scanner = new Scanner(System.in);

        int coord;
        do {
            System.out.printf("Please enter %s-coordinate [1..3]%n", axis);
            coord = scanner.nextInt() - 1;
        } while (coord < 0 || coord > 2);

        return coord;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
