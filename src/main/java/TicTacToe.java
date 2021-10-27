import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        start();

    }
    static void start () {
        char[][] field = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };

        drawField(field);
        doPlayerMove(field);
        drawField(field);
    }

    static void doPlayerMove (char[][] field) {
        int h, v;
        do {
            System.out.println("Please enter coordinate....");
            h = getCoordinate('h');
            v = getCoordinate('v');
        } while (field[h][v] != '-');

        field[h][v] = 'x';
    }

    static int getCoordinate (char axis) {
        Scanner scanner = new Scanner(System.in);
        int coord;
        do {
            System.out.printf("Please enter %s-coordinate [1..3] %n", axis);
            coord = scanner.nextInt() - 1;
        } while (coord < 0 || coord > 2 );
        return coord;
    }

    static void drawField (char[][] field) {
        for (int i = 0; i <field.length ; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
