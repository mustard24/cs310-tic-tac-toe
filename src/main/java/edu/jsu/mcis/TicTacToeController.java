package edu.jsu.mcis;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
    }
	public String getMarkAsString(int row, int col) {       
        return (model.getMark(row, col).toString());       
    }
   
    public TicTacToeView getView() {       
        return view;       
    }

    
    public void start() {
		
        /* MAIN LOOP (repeats until game is over) */
		/*
		while(!(model.isGameover())){
			view.showBoard(model.toString());
			TicTacToeMove move = view.getNextMove(model.isXTurn());
			while(!(model.makeMark(move.getRow(),move.getCol()))){
				view.showInputError();
				move = view.getNextMove(model.isXTurn());
			}
			view.showResult(model.getResult().toString());
		}
		*/
        /* Display the board using the View's "showBoard()", then use
           "getNextMove()" to get the next move from the player.  Enter
           the move (using the Model's "makeMark()", or display an error
           using the View's "showInputError()" if the move is invalid. */

        // INSERT YOUR CODE HERE
        
        /* After the game is over, show the final board and the winner */

        
        
    }
	@Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton)event.getSource();
		String squareName = button.getName();
		squareName = squareName.replaceFirst("Square","");
		
		String[] coordinate = squareName.split("");
		int row = Integer.parseInt(coordinate[0]);
		int col = Integer.parseInt(coordinate[1]);
		model.makeMark(row, col);
		
		view.updateSquares();
		if(model.isGameover()){
			view.disableSquares();
			view.showResult(model.getResult().toString());
		}
    }
}
