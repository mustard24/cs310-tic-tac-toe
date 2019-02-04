package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				board[i][j] = Mark.EMPTY;
			}
		}
        // INSERT YOUR CODE HERE
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
		this.width = width;
		if(isValidSquare(row,col) && !(isSquareMarked(row,col))){
			if(xTurn){
				xTurn = false;
				board[row][col] = Mark.X;
			}
			else{
				xTurn = true;
				board[row][col] = Mark.O;
			}
			
			return true;
		}
		else{
			return false;
		}
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        this.width = width;
		System.out.println(width);
        // INSERT YOUR CODE HERE
		if(row < 0 || row > width - 1){
			return false;
		}
		else if (col < 0 || col > width - 1){
			return false;
		}
		return true;
    }
	
    private boolean isSquareMarked(int row, int col) {
        /* Return TRUE if the square at specified location is marked */
		if(board[row][col] == Mark.EMPTY){
			return false;
		}
        return true; // remove this line later!
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE
		return board[row][col];
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
		if(isMarkWin(Mark.X)){
			return Result.X;
		}
		else if(isMarkWin(Mark.O)){
			return Result.O;
		}
		else if(isTie()){
			return Result.TIE;
		}
		else{
			return Result.NONE;
		}
        // INSERT YOUR CODE HERE
        
    }
	
    private boolean isMarkWin(Mark mark) {
        boolean winDiagonalWest = true;
		boolean winDiagonalEast = true;
		boolean winVertical = true;
		boolean winHorizontal = true;
        for(int i = 0; i < width; i++){
			if(!(board[i][i] == mark)){
				winDiagonalWest = false;
			}
		}
		if(winDiagonalWest){
			return true;
		}
		int jj = 0;
		for(int j = width-1; j >= 0; j--){
			
			if(!(board[jj][j] == mark)){
				winDiagonalEast = false;
			}
			jj++;
		}
		if(winDiagonalEast){
			return true;
		}
		for(int k = 0; k < width; k++){
			for(int l = 0; l < width; l++){
				if(!(board[k][l] == mark)){
					winVertical = false;
				}
			}
			if(winVertical){
				return true;
			}
			winVertical = true;
		}
		for(int m = 0; m < width; m++){
			for(int n = 0; n < width; n++){
				if(!(board[n][m] == mark)){
					winVertical = false;
				}
			}
			if(winVertical){
				return true;
			}
			winVertical = true;
		}

        return false; // remove this line later!

    }
	
    private boolean isTie() {
        
        for(int i = 0; i < width; i ++){
			for(int j = 0; j < width; j++){
				if(board[i][j] == Mark.EMPTY){
					return false;
				}
			}
			
		}

        return true; // remove this line later!
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
		
		for(int k = 0; k < width; k++){
			output.append(k);
		}
		output.append("\n");
        for(int i = 0; i < width; i++){
			
			output.append(i + " ");
			
			
			for(int j = 0; j < width; j++){
				output.append(board[i][j]);
			}
			output.append("\n");
		}
        // INSERT YOUR CODE HERE
        
        return output.toString();
        
    }
    
}
