import java.util.*;
class WordMatchM {
	//static stuff
	public static int score =0;
	public static int userRow , userCol , userRow2 , userCol2;
	public static Random rd = new Random(); 
	public static Scanner sc = new Scanner(System.in); 
  public static void main(String[] args){
	  	// change the "Name" strings in the 2d array to desired names 
		String[][] board ={{"Name","Name","Name","Name"},
                            {"Name","Name","Name","Name"},
                            {"Name","Name","Name","Name"},
                            {"Name","Name","Name","Name"}};
		String[][] newBoard = new String[board.length][board[0].length]; 
		randBoard(board);
		hideBoard(newBoard);
		useBoard(newBoard,board,score);
  }
	/*--Methods--*/
	public static void PrintBoard(String [][] board){
		for(String[] row: board ){
      for(String values:row){
        System.out.print(values+"\t");
      }
			 System.out.println();
    }
	}
	/*--start of choice methods-- */
	public static String ChoiceOne(String[][] board,int userRow, int userCol){
		return board[userRow][userCol];
	}
	public static String ChoiceTwo(String[][] board,int userRow, int userCol){
		return board[userRow][userCol];
	}
	// compare content in each choice 
	public static boolean isMatch(String[][] newBoard, String[][] board,int userRow, int userCol, int userRow2, int userCol2){
		/* these values are given in the Inputs method 
				calls the Choice methods 
		*/
		if(ChoiceOne(board,userRow,userCol).equals(ChoiceTwo(board,userRow2,userCol2))){
            newBoard[userRow][userCol] = board[userRow][userCol];
            newBoard[userRow2][userCol2] = board[userRow2][userCol2];
			return true; 
		}
		if(!ChoiceOne(board,userRow,userCol).equals(ChoiceTwo(board,userRow2,userCol2))){
			hideBoard(newBoard);
		}
		return false;
	}
	/*--end of choice methods--
		--Start of game methods--*/
		// randomizes the board so its never the same 
	   public static String[][] randBoard(String[][] board){
		   int randNum = rd.nextInt(3)+1;
		   for(int r =0; r< board.length; r++){
			for(int c =0; c< board[r].length; c++){
			   board[r][c] =board[randNum][randNum];
			}  
		   }
		   return board;
	   }
	   // hides the board so user cant see it 
       public static String[][] hideBoard(String[][] newBoard){
		   for(int r =0; r< newBoard.length; r++){
			   for(int c =0; c< newBoard[r].length; c++){
					newBoard[r][c] = "_______";
			   }
		   }
		   return newBoard;
	   }
	   // after a user chooses a spot it shows it 
	   public static void showChosenVals(String [][] newBoard, String [][]board ,int userRow,int userCol){
			newBoard[userRow][userCol] = board[userRow][userCol];
	   }
	   // gets user inputs 
	   public static void Questions(String[][] newBoard,String[][] board){
		   System.out.println("\n"+"choose a row:");
			userRow = sc.nextInt();
		System.out.println("choose a col");
			userCol = sc.nextInt();
			//TODO make the first word appear when chosen 
			showChosenVals(newBoard, board, userRow, userCol);
			PrintBoard(newBoard);
		System.out.println("choose a row for match:");
			 userRow2 = sc.nextInt();
		System.out.println("choose a col for match: ");
			 userCol2 = sc.nextInt();
	   }
	// uses user inputs 
	public static boolean Inputs(String[][] newBoard,String[][] board,int score){
		PrintBoard(newBoard);
		Questions(newBoard,board);
		// so they cant choose the first choice think of it as a filter 
		if(userRow == userRow2 && userCol == userCol2){
			System.out.println("this is the same spot try a different location");
			return false;
		}
		// using the is match method see if the given locals are equal 
		if(isMatch(newBoard,board,userRow,userCol,userRow2,userCol2) == true){
			System.out.println("MATCH!!!!");
			score++; 
			System.out.println("Score:"+score);
			return false;
		}
		//if its the max score aka all the spaces are solved then the game ends 
		if(score == board.length+board[0].length){
			return true;
		}
		else if(isMatch(newBoard,board,userRow,userCol,userRow2,userCol2) == false){
			System.out.println("no match found:(");
		}
			return false;
		}
	
	public static void useBoard(String[][] newBoard,String[][] board,int score){
		if(Inputs(newBoard,board,score) == true){
			System.out.println("YOU SOLVED THE BOARD :)!!!!!!"); 
		}
		else if(Inputs(newBoard,board,score)== false){
			 Inputs(newBoard,board,score); 
		}
	}
	/*end of game methods 
	 end of methods*/  
}
