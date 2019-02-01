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
		// model.Mark.EMPTY;
        /* MAIN LOOP (repeats until game is over) */
		while(!(model.isGameover())){
			view.showBoard(model.toString());
			TicTacToeMove move = view.getNextMove(model.isXTurn());
			while(!(model.makeMark(move.getRow(),move.getCol()))){
				view.showInputError();
			}
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
