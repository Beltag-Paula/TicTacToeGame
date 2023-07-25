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




2 Main2MinMaxAlgorithm.java Overview
This is the second version of the Tic Tac Toe game code. Similar to the first version, it provides a command-line implementation of the game, where the player competes against the computer. However, this version utilizes the Minimax algorithm to make the computer's moves more strategic and difficult to predict.
Code Structure

    Import Statements: The code includes the same import statements as the first version to bring in necessary classes from the java.util package.

    Global Variables: The program has the same global variables as the first version:
        playerPositions: An ArrayList to store positions chosen by the player.
        computerPositions: An ArrayList to store positions chosen by the computer.
        gameOver: A boolean variable to track whether the game is over or still in progress.

    printGameBoard Method: This method is responsible for printing the current state of the game board on the console, just like in the first version.

    placePosition Method: This method is used to place a symbol ('X' or 'O') on the game board at the specified position, as in the first version.

    checkWinner Method: This method is also the same as in the first version and checks for a winner or a tie condition in the current game state.

    Minimax Algorithm:
        The second version introduces the Minimax algorithm to enhance the computer's moves.
        The Minimax algorithm is a recursive search algorithm used to determine the best possible move for the computer in a two-player, zero-sum game (like Tic Tac Toe).
        The algorithm explores all possible moves and assigns scores to each possible outcome (win, lose, or draw).
        Based on these scores, the computer selects the best move that maximizes its chances of winning or minimizing the player's chances of winning.

    isMovesLeft Method: This method checks whether there are any empty positions left on the game board.

    evaluate Method: This method evaluates the game board and returns a score based on the winning conditions.

    minimax Method: The core of the Minimax algorithm, this method recursively evaluates all possible moves and returns the best possible score for the current player.

    findBestMove Method: This method utilizes the Minimax algorithm to find the best possible move for the computer. It returns the position (1 to 9) where the computer should place its symbol.

Pros

    Strategic Computer Moves: The introduction of the Minimax algorithm makes the computer's moves more strategic, providing a challenging experience for the player.

    Strong AI: The computer's moves are no longer random but instead calculated to maximize its chances of winning or forcing a draw.

    More Challenging Gameplay: The improved computer AI can lead to longer and more engaging gameplay sessions.

    Unpredictable Computer Behavior: The computer's moves are no longer easily predictable, adding an element of surprise to the game.

    Same Simplicity and Modularity: The structure of the code remains simple and modular, making it easy to understand and maintain.

Cons

    Command-Line Interface: The game still lacks a graphical user interface, which may limit its appeal to players who prefer visually appealing games.

    Limited Customization: Like the first version, this version also lacks configurability options, such as changing symbols or board size.

Conclusion

The second version of the Tic Tac Toe game code presents an improved experience over the first version by introducing the Minimax algorithm to control the computer's moves. This version offers stronger AI, providing a more challenging gameplay experience for the player. However, it still retains the limitations of a command-line interface and lack of customization options. Overall, this version demonstrates the application of a strategic algorithm to enhance a simple game and provides a good foundation for further development into a more sophisticated and user-friendly Tic Tac Toe game.


3 MainMinMax2ver2.java Overview :
This is the third version of the Tic Tac Toe game code. It builds upon the second version by introducing a modification to the game flow. Instead of allowing the player to fill all the positions on the board, the player and computer are limited to placing a fixed number of symbols (X and O) on the board. The code now exits the game loop after the player and computer have placed their respective symbols a certain number of times.
Code Structure

    Global Variables: The program has the same global variables as in the previous versions:
        playerPositions: An ArrayList to store positions chosen by the player.
        computerPositions: An ArrayList to store positions chosen by the computer.
        gameOver: A boolean variable to track whether the game is over or still in progress.

    printGameBoard Method: This method is responsible for printing the current state of the game board on the console, just like in the previous versions.

    placePosition Method: This method is used to place a symbol ('X' or 'O') on the game board at the specified position, similar to the previous versions.

    checkWinner Method: This method checks for a winner or a tie condition in the current game state, as in the previous versions.

    Minimax Algorithm: The third version retains the Minimax algorithm introduced in the second version, which provides strategic computer moves.

    isMovesLeft Method: This method checks whether there are any empty positions left on the game board, just like in the previous versions.

    evaluate Method: This method evaluates the game board and returns a score based on the winning conditions, similar to the previous versions.

    minimax Method: This is the core of the Minimax algorithm, which recursively evaluates all possible moves and returns the best possible score for the current player, as in the previous versions.

    findBestMove Method: This method utilizes the Minimax algorithm to find the best possible move for the computer, just like in the previous versions.

    gamePlay Method: This method initiates the game and controls the game flow, introducing the modification to limit the number of player and computer moves.

Pros

    Strategic Computer Moves: The use of the Minimax algorithm provides the computer with strategic moves, making the game more challenging for the player.

    Limited Number of Moves: The modification to limit the number of moves adds an element of strategy and time management to the game.

    Improved Player Experience: The limited number of moves ensures that the game does not drag on indefinitely and allows players to engage in multiple rounds.

    Strong AI: The use of the Minimax algorithm ensures that the computer's moves are calculated to maximize its chances of winning or forcing a draw.

    Modularity: The code retains the modularity and simplicity of the previous versions, making it easy to understand and maintain.

Cons

    Command-Line Interface: The game still lacks a graphical user interface, which may limit its appeal to players who prefer visually appealing games.

    Lack of Customization: The game's board size and symbols are fixed and cannot be easily customized.

Comparison with Previous Versions

    Compared to the first version, the second and third versions both introduce the Minimax algorithm to enhance the computer's moves. However, the third version further modifies the game flow by limiting the number of moves for both the player and the computer.

    The second and third versions have more strategic AI, making the computer's moves harder to predict than in the first version.

    The third version differs from the second version in that it introduces the move counter to limit the number of moves, while the second version allowed the game to continue until all positions were filled.

    The third version may offer a more enjoyable player experience due to the limited number of moves, making the game more engaging and less prone to becoming repetitive.

Conclusion

Among the three versions, the third version appears to be an improved version, as it builds upon the strengths of the second version (strategic computer moves using Minimax) and introduces a modification to limit the number of moves, providing a better player experience. Despite its lack of a graphical user interface and customization options, the third version showcases how the use of strategic algorithms can enhance a simple game like Tic Tac Toe. With further development, this version has the potential to evolve into a more sophisticated and enjoyable game for players.
