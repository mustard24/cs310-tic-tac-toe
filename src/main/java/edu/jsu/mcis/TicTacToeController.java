package edu.jsu.mcis;

public class TicTacToeController {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView();
    }

    public void start() {
    
        /* MAIN LOOP (repeats until game is over) */
		while(model.getResult() != result.X || model.getResult() != result.O){
			view.showBoard(model.toString());
			view.getNextMove(model.isXTurn());
			view.showResult(model.getResult().toString());
		}
        /* Display the board using the View's "showBoard()", then use
           "getNextMove()" to get the next move from the player.  Enter
           the move (using the Model's "makeMark()", or display an error
           using the View's "showInputError()" if the move is invalid. */

        // INSERT YOUR CODE HERE
        
        /* After the game is over, show the final board and the winner */

        
        
    }

}
