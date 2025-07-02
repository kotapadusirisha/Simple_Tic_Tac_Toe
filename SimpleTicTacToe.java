import java.util.Scanner;

public class SimpleTicTacToe {
    static char[] board = {'1','2','3','4','5','6','7','8','9'};
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int moves = 0;

        while (true) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", choose (1-9): ");
            int pos = sc.nextInt();

            if (pos < 1 || pos > 9 || board[pos - 1] == 'X' || board[pos - 1] == 'O') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[pos - 1] = currentPlayer;
            moves++;

            if (checkWin()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (moves == 9) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    static void printBoard() {
        System.out.println("\n" +
            board[0] + " | " + board[1] + " | " + board[2] + "\n" +
            "--+---+--\n" +
            board[3] + " | " + board[4] + " | " + board[5] + "\n" +
            "--+---+--\n" +
            board[6] + " | " + board[7] + " | " + board[8] + "\n");
    }

    static boolean checkWin() {
        int[][] winCombos = {
            {0,1,2}, {3,4,5}, {6,7,8}, // rows
            {0,3,6}, {1,4,7}, {2,5,8}, // columns
            {0,4,8}, {2,4,6}           // diagonals
        };
        for (int[] combo : winCombos) {
            if (board[combo[0]] == currentPlayer &&
                board[combo[1]] == currentPlayer &&
                board[combo[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }
}