package SideProjects;
import java.util.Scanner;
public class Tic_Tac_Toe_Game {

	public static void main(String[] args) {
		GameBoard board = new GameBoard(3,3);
		board.initializeBoard();
		// successfully initialized
		Scanner scn = new Scanner(System.in);
		boolean winner = false;
		boolean player1 = true;
		boolean player2 = false;
		int rowInput = 0;
		int colInput=0;
		boolean wantToPlay = true;
		
		System.out.println("Welcome to Tic-Tac-Toe. ");
		System.out.println("Press enter to start");
		scn.nextLine();
		board.print_Board();
		while (wantToPlay){
			while(player1){
				System.out.println("Turn: Player1");
				System.out.print("Enter the row: ");
				rowInput=scn.nextInt();
				System.out.println();
				System.out.print("Enter the column: ");
				colInput=scn.nextInt();
				System.out.println();
				if (validInput(rowInput-1,colInput-1,board)==false){
					System.out.println("That is not a valid input. Try again");
					do{
						System.out.println("Enter the row: ");
						rowInput=scn.nextInt();
						System.out.println("Enter the column: ");
						colInput=scn.nextInt();
					} while(validInput(rowInput-1,colInput-1,board)==false);
				}
				board.board[rowInput-1][colInput-1] = "X";
				board.print_Board();
				winner = checkWin(board.board);
				if(winner==true){
					System.out.println("Player 1 wins!");
					return;
				}
				player1=false;
				player2=true;
			}
			while(player2){
				System.out.println("Turn: Player2");
				System.out.print("Enter the row: ");
				rowInput=scn.nextInt();
				System.out.print("Enter the column: ");
				colInput=scn.nextInt();
				if (validInput(rowInput-1,colInput-1,board)==false || rowInput<0 || colInput<0){
					System.out.println("That is not a valid input. Try again");
					do{
						System.out.println("Enter the row: ");
						rowInput=scn.nextInt();
						System.out.println("Enter the column: ");
						colInput=scn.nextInt();
					} while(validInput(rowInput-1,colInput-1,board)==false);
				}
				board.board[rowInput-1][colInput-1] = "O";
				board.print_Board();
				winner = checkWin(board.board);
				if(winner==true){
					System.out.println("Player 2 wins!");
					return;
				}
				player2=false;
				player1=true;
			}
		}
	}
	public static boolean checkVerticalWin(String[][]x){
		for (int i=0;i<x.length;i++){
			int j=0;
				if(x[j][i]!="*" && x[j][i].equals(x[j+1][i]) && x[j][i].equals(x[j+2][i])){
					return true;
				}else{
					
				}
			
		}
		return false;
		
	}
	public static boolean checkHorizontalWin(String[][]x){
		for (int i=0;i<1;i++){
			for(int j=0;j<x.length;j++){
				if(x[j][i]!="*" && x[j][i].equals(x[j][i+1]) && x[j][i].equals(x[j][i+2])){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean checkDiagonalWin(String[][]x){
		boolean answer = true;
		if(x[0][0]!="*" && x[0][0].equals(x[1][1]) && x[0][0].equals(x[2][2])){
			answer = true;
		}else if (x[0][2]!="*" && x[0][2].equals(x[1][1]) && x[0][2].equals(x[2][0])){
			answer = true;
		}else{
			answer = false;
		}
		return answer;
	}
	public static boolean checkWin(String [][]x){
		if(checkVerticalWin(x) || checkHorizontalWin(x) || checkDiagonalWin(x)){
			return true;
		}
		return false;
	}
	//method below will check if the player put in valid indexes to put their piece
	//method will return true only if space is empty
	public static boolean validInput(int rows, int cols, GameBoard example){
		if (example.board[rows][cols]!= "*"){
			return false;
		}
		return true;
	}
}


