import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your move (Rock, Paper, or Scissors) or 'exit' to end the game:");
            String playerMove = scanner.nextLine().toLowerCase();

            if (playerMove.equals("exit")) {
                System.out.println("Exiting the game. Goodbye!");
                break;
            }

            if (!isValidMove(playerMove)) {
                System.out.println("Invalid move. Please enter Rock, Paper, or Scissors.");
                continue;
            }

            String computerMove = generateComputerMove();

            System.out.println("Computer's move: " + computerMove);

            String result = determineWinner(playerMove, computerMove);
            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    private static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

    private static String generateComputerMove() {
        int random = (int) (Math.random() * 3);

        switch (random) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return "";
        }
    }

    private static String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "It's a tie!";
        } else if (
            (playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))
        ) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}