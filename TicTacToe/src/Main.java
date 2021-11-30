import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> computerPositions = new ArrayList<Integer>();
	static boolean gameOver;

	private static void printGameBoard(char[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(" "+gameBoard[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void placePosition(char[][] gameBoard, int position, String user) {
		char symbol = ' ';
		if (user.equals("player")) {
			symbol = 'X';
			playerPositions.add(position);
		}
		if (user.equals("computer")) {
			symbol = 'O';
			computerPositions.add(position);
		}

		switch (position) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][1] = symbol;
			break;
		case 3:
			gameBoard[0][2] = symbol;
			break;
		case 4:
			gameBoard[1][0] = symbol;
			break;
		case 5:
			gameBoard[1][1] = symbol;
			break;
		case 6:
			gameBoard[1][2] = symbol;
			break;
		case 7:
			gameBoard[2][0] = symbol;
			break;
		case 8:
			gameBoard[2][1] = symbol;
			break;
		case 9:
			gameBoard[2][2] = symbol;
			break;
		default:
			break;
		}
	}

	private static String checkWinner() {
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);

		List rightCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List leftCol = Arrays.asList(3, 6, 9);

		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);

		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(midRow);
		winningConditions.add(botRow);
		winningConditions.add(rightCol);
		winningConditions.add(midCol);
		winningConditions.add(leftCol);
		winningConditions.add(cross1);
		winningConditions.add(cross2);

		for (List l : winningConditions) {
			if (playerPositions.containsAll(l)) {
				gameOver = true;
				return "You won";

			} else if (computerPositions.containsAll(l)) {
				gameOver = true;
				return "CPU won";

			} else if (playerPositions.size() + computerPositions.size() == 9) {
				gameOver = true;
				return "It's a tie";
			}
		}
		return " ";
	}

	private static void gamePlay() {
		char[][] gameBoard = { { '$', '$', '$' }, { '$', '$', '$' }, { '$', '$', '$' } };

		printGameBoard(gameBoard);
		gameOver = false;
		Scanner scan = new Scanner(System.in);

		while (gameOver == false) {
			
			System.out.println("Enter position on the Board: ");
			int playerPosition = scan.nextInt();

			while (playerPositions.contains(playerPosition) || computerPositions.contains(playerPosition)) {
				System.out.println("Position taken. Enter another position");
				playerPosition = scan.nextInt();
			}

			placePosition(gameBoard, playerPosition, "player");
			printGameBoard(gameBoard);
			/////////////////////////////////////////////////////////

			Random random = new Random();
			int computerPosition = random.nextInt(9) + 1;
			while (playerPositions.contains(computerPosition) || computerPositions.contains(computerPosition)) {
				computerPosition = random.nextInt(9) + 1;
			}

			placePosition(gameBoard, computerPosition, "computer");
			printGameBoard(gameBoard);

			System.out.println(checkWinner());

		}

	}

	public static void main(String[] args) {
        System.out.println("Tic Tac Toe game");
		gamePlay();
	}

}
