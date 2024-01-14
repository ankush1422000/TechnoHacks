import java.util.Scanner;

public class Tic_Tac_Toe{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        char currentPlayer = 'X';

        printBoard(board);

        // Main game loop
        while (true) {
            System.out.println("Player " + currentPlayer + "'s turn");
            int row, col;

            // Get valid user input for row and column
            do {
                System.out.print("Enter row (1-3) and column (1-3) separated by a space: ");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            } while (!isValidMove(board, row, col));

            // Make the move
            board[row][col] = currentPlayer;

            // Print the updated board
            printBoard(board);

            // Check for a win or a draw
            if (isWinner(board, currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isBoardFull(board)) {
                System.out.println("It's a draw!");
                break;
            }

            // Switch to the other player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        scanner.close();
    }

    // Method to print the Tic Tac Toe board
    private static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Method to check if a move is valid
    private static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("Invalid move. Try again.");
            return false;
        }
        return true;
    }

    // Method to check if a player has won
    private static boolean isWinner(char[][] board, char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    // Method to check if the board is full (a draw)
    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}