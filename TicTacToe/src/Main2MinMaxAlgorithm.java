import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main2MinMaxAlgorithm {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> computerPositions = new ArrayList<Integer>();
	static boolean gameOver;

	private static void printGameBoard(char[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(" " + gameBoard[i][j] + "  ");
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

			} else if ( (playerPositions.size() + computerPositions.size()) == 9) {
				gameOver = true;
				return "It's a tie";
			}
		}
		return " ";
	}

	////////////////////////////////////////////////////
	// MINMAX //computer is O , player is X 
	// 1
	static Boolean isMovesLeft(char gameBoard[][]) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (gameBoard[i][j] == '$')
					return true;
		return false;
	}

	// 2
	static int evaluate(char gameBoard[][]) {
		// Checking for Rows for X or O victory.
		for (int row = 0; row < 3; row++) {
			if (gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2]) {
				if (gameBoard[row][0] == 'O')
					return +10;
				else if (gameBoard[row][0] == 'X')
					return -10;
			}
		}

		// Checking for Columns for X or O victory.
		for (int col = 0; col < 3; col++) {
			if (gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col]) {
				if (gameBoard[0][col] == 'O')
					return +10;

				else if (gameBoard[0][col] == 'X')
					return -10;
			}
		}

		// Checking for Diagonals for X or O victory.
		if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) {
			if (gameBoard[0][0] == 'O')
				return +10;
			else if (gameBoard[0][0] == 'X')
				return -10;
		}

		if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) {
			if (gameBoard[0][2] == 'O')
				return +10;
			else if (gameBoard[0][2] == 'X')
				return -10;
		}

		// Else if none of them have won then return 0
		return 0;
	}

	// 3
	// This is the minimax function. It considers all
	// the possible ways the game can go and returns
	// the value of the board
	static int minimax(char gameBoard[][], int depth, Boolean isMax) {
		int score = evaluate(gameBoard);

		// If Maximizer has won the game
		// return his/her evaluated score
		if (score == 10)
			return score;

		// If Minimizer has won the game
		// return his/her evaluated score
		if (score == -10)
			return score;

		// If there are no more moves and
		// no winner then it is a tie
		if (isMovesLeft(gameBoard) == false)
			return 0;

		// If this maximizer's move
		if (isMax) {
			int best = -1000;

			// Traverse all cells
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// Check if cell is empty
					if (gameBoard[i][j] == '$') {
						// Make the move
						gameBoard[i][j] = 'O';

						// Call minimax recursively and choose
						// the maximum value
						best = Math.max(best, minimax(gameBoard, depth + 1, !isMax));

						// Undo the move
						gameBoard[i][j] = '$';
					}
				}
			}
			return best;
		}

		// If this minimizer's move
		else {
			int best = 1000;

			// Traverse all cells
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// Check if cell is empty
					if (gameBoard[i][j] == '$') {
						// Make the move
						gameBoard[i][j] = 'X';

						// Call minimax recursively and choose
						// the minimum value
						best = Math.min(best, minimax(gameBoard, depth + 1, !isMax));

						// Undo the move
						gameBoard[i][j] = '$';
					}
				}
			}
			return best;
		}
	}

	// 4
	// This will return the best possible
	// move for the player
	static int findBestMove(char board[][]) {
		int bestVal = -1000;
		int row = -1;
		int col = -1;
		int position = 0;

		// Traverse all cells, evaluate minimax function
		// for all empty cells. And return the cell
		// with optimal value.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// Check if cell is empty
				if (board[i][j] == '$') {
					// Make the move
					board[i][j] = 'O';

					// compute evaluation function for this move
					int moveVal = minimax(board, 0, false);

					// Undo the move
					board[i][j] = '$';

					// If the value of the current move is
					// more than the best value, then update
					// best/
					if (moveVal > bestVal) {
						row = i;
						col = j;
						bestVal = moveVal;

					}
				}
			}
		}

		if (row == 0 && col == 0) {
			position = 1;
		}
		if (row == 0 && col == 1) {
			position = 2;
		}
		if (row == 0 && col == 2) {
			position = 3;
		}
		if (row == 1 && col == 0) {
			position = 4;
		}
		if (row == 1 && col == 1) {
			position = 5;
		}
		if (row == 1 && col == 2) {
			position = 6;
		}
		if (row == 2 && col == 0) {
			position = 7;
		}
		if (row == 2 && col == 1) {
			position = 8;
		}
		if (row == 2 && col == 2) {
			position = 9;
		}

		//System.out.printf("The value of the best Move " + "is : %d\n\n", bestVal);

		// i, j --->
		return position;
	}

	///////////////////////////////////////////////////

	private static void gamePlay() {
		char[][] gameBoard = { { '$', '$', '$' }, { '$', '$', '$' }, { '$', '$', '$' } };

		printGameBoard(gameBoard);
		gameOver = false;
		Scanner scan = new Scanner(System.in);
		int counter =0;

		while ( (gameOver == false) && (counter <= 8)) {

			System.out.println("Enter position on the Board: ");
			int playerPosition = scan.nextInt();

			while (playerPositions.contains(playerPosition) || computerPositions.contains(playerPosition)) {
				System.out.println("Position taken. Enter another position");
				playerPosition = scan.nextInt();
			}

			placePosition(gameBoard, playerPosition, "player");
			printGameBoard(gameBoard);
			/////////////////////////////////////////////////////////

			
			int computerPosition = findBestMove(gameBoard);

			placePosition(gameBoard, computerPosition, "computer");
			printGameBoard(gameBoard);

			/////////////////////////////////////////////////////////
			counter++;
			
			System.out.println(checkWinner());

		}

	}

	public static void main(String[] args) {
		System.out.println("Tic Tac Toe game");
		gamePlay();
	}

}
