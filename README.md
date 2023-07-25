# TicTacToeGame
A simple tic tac toe game that you can play with the computer in the command prompt / console of IDE.
The user is X and the computer O.
There are 3 versions of Main :
- the first commited Main used Random method for the computer to set a random position that was not yet
taken.
- the second Main instead of Random method, the computer calculates the best position using MinMaxAlgorithm
- in the third Main is fixed the game where it is a tie, using a counter to get out of the while loop from
the gamePlay() method.


Explanation : 
1 Main.java Overview

This code implements a command-line version of the classic game "Tic Tac Toe." The game is designed for two players, one being the user (player) and the other controlled by the computer. The players take turns placing their symbols ('X' for the player and 'O' for the computer) on a 3x3 game board until there is a winner or a tie.
Code Structure

    Import Statements: The code includes several import statements to bring in necessary classes from the java.util package.

    Global Variables: The program declares three global variables:
        playerPositions: An ArrayList to store positions chosen by the player.
        computerPositions: An ArrayList to store positions chosen by the computer.
        gameOver: A boolean variable to track whether the game is over or still in progress.

    printGameBoard Method: This method is responsible for printing the current state of the game board on the console.

    placePosition Method: This method is used to place a symbol ('X' or 'O') on the game board at the specified position.

    checkWinner Method: This method checks if there is a winner or a tie condition in the current game state.

    gamePlay Method: The core of the game, this method handles the gameplay process, including turns for the player and computer.

    main Method: The entry point of the program, which starts the Tic Tac Toe game by calling the gamePlay method.

Pros

    Simple and Understandable: The code is relatively straightforward and easy to comprehend, making it accessible to beginner developers and a good educational example.

    Lightweight: As a command-line game, the code does not rely on heavy graphical user interfaces, making it efficient in terms of resources.

    Modularity: The code is organized into different methods, which enhances readability and facilitates maintenance and future improvements.

    Randomized Computer Moves: The computer makes its moves randomly, which introduces an element of unpredictability to the game, preventing repetitive patterns.

    Basic Error Handling: The code ensures that players cannot select already taken positions, reducing the chance of invalid moves.

Cons

    Lack of Extensibility: The code is designed specifically for a 3x3 Tic Tac Toe game, and it might require significant modifications to support different board sizes or additional features.

    Limited User Interface: Being a command-line game, the user interface is minimalistic, providing only basic text prompts and game board visualization.

    Weak AI: The computer's move is entirely random, making it easy for experienced players to predict and exploit the computer's behavior.

    No Configurability: The game does not offer any configuration options, such as changing symbols, starting positions, or difficulty levels.

    Single-Player Only: The game is limited to a player-versus-computer setup, and there is no option for two human players to play against each other.

Conclusion

   The Tic Tac Toe game code provided above serves as a simple and functional implementation of the classic game. While it demonstrates fundamental programming concepts and logic, it may require further enhancements to provide a more engaging and customizable gaming experience. Introducing features such as a graphical user interface, better AI strategies, adjustable board sizes, and multiplayer support could make it a more versatile and enjoyable game.
