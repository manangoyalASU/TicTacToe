package tic_tac_toe_attempt_one;

import java.util.Scanner;

public class GameEngine extends Board{

	boolean gameOver;
	String[] board = new String[9];
	
	
	public GameEngine(boolean gameOver) {
		this.gameOver = gameOver;
		for (int i = 0; i <= 8; i++) {
			board[i] = "";
		}
	}
	
	
	public static void main(String[] args) {		
		// Create an instance of GameEngine game
		GameEngine game = new GameEngine(false);
		Board gameBoard = new Board();

		
		// Creates a Scanner object to collect user input
		Scanner scnr = new Scanner(System.in);
		
		// Stores name of Player X
		System.out.print("Welcome to Tic Tac Toe. \nEnter the name of Player X: ");
		String nameX = scnr.next();
		System.out.println();
		
		// Stores name of Player Y
		System.out.print("Enter the name of Player Y: ");
		String nameY = scnr.next();
		System.out.println();
		
		// Creates a playerX onject
		PlayerX playerX = new PlayerX(nameX);
		
		// Creates a playerY object
		PlayerY playerY = new PlayerY(nameY);
		
		// Tells players who is Player X and who is Player Y
		System.out.println("Player X is: " + playerX.retName());
		System.out.println("Player Y is: " + playerY.retName() + "\n");
		
		boolean emptySpace = false;
		int move;
		
		while (!game.gameOver) {
			
			// ask player x the move - resolved
			
			move = game.askPlayer(1);
			
			// check if available. if yes, then change the board. if no, then tell the player and keep asking until available. - resolved
			
			if (gameBoard.spaceChecker(game.board, move - 1)) {
				game.board[move-1] = "x";
			} else {
				while (emptySpace == false) {
					System.out.println("Full");
					move = game.askPlayer(1);
					if (gameBoard.spaceChecker(game.board, move - 1)) {
						game.board[move-1] = "x";
						emptySpace = true;
					}
				}
			}
			
			// print the board. Call a method in the Board class that prints the board to the console - resolved
			
			gameBoard.printBoard(game.board);
			if (gameBoard.midChecker(game.board)) {
				System.out.println("Tied Game");
				System.exit(0);
			}
			
			// check if game is won or tied
			
			if (gameBoard.winChecker(game.board)) {
				System.out.println(playerX.retName() + " wins");
				System.exit(0);
			}
			
			// ask player y the move - resolved
			
			move = game.askPlayer(2);
			
			// check if available. if yes, then change the board. if no, then tell the player and keep asking until available. - resolved
			
			if (gameBoard.spaceChecker(game.board, move - 1)) {
				game.board[move-1] = "y";
			} else {
				while (emptySpace == false) {
					System.out.println("Full");
					move = game.askPlayer(2);
					if (gameBoard.spaceChecker(game.board, move - 1)) {
						game.board[move-1] = "y";
						emptySpace = true;
					}
				}
			}
			
			// print the board - resolved
			
			gameBoard.printBoard(game.board);
			
			// check if game is won or tied
			
			if (gameBoard.winChecker(game.board)) {
				System.out.println(playerY.retName() + " wins");
				game.gameOver = true;
			}
		}
		
		
		
	}
	
	private int askPlayer(int p) {
		Scanner scnr = new Scanner(System.in);
		
		if (p == 1) {
			System.out.println("Player X, enter your move (1-9): ");
			return scnr.nextInt();
		} else {
			System.out.println("Player Y, enter your move (1-9): ");
			return scnr.nextInt();
		}
	}
	
	

}
