package tic_tac_toe_attempt_one;


public class Board{
	
	// Returns true if the board space is empty. Returns fall otherwise
	public boolean spaceChecker(String[] board, int move) {
		
		if (noSpace(board)) {
			System.out.println("Tied Game");
			System.exit(0);
		}
		
		if (move > 8 | move < 0) {
			return false;
		} else if (board[move] == "") {
			return true;
		}
		
		return false;
	}
	
	public boolean midChecker(String[] board) {
		if (noSpace(board)) {
			return true;
		}
		return false;
	}
	
	public boolean noSpace(String[] board) {
		for (int i = 0; i <= 8; i++) {
			if (board[i] == "") {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean winChecker(String[] board) {
		if (checkHor(board)) {
			return true;
		}
		if (checkVert(board)) {
			return true;
		}
		if (checkDiag(board)) {
			return true;
		}
		return false;
	}
	
	public boolean checkDiag(String[] board) {
		if (board[4] == "") {
			return false;
		}
		if (board[0] == board[4] & board[4] == board[8]) {
			return true;
		}
		if (board[2] == board[4] & board[4] == board[6]) {
			return true;
		}
		return false;
	}
	
	public boolean checkVert(String[] board) {
		int i = -1;
			for (int k = 0; k <= 2; k++) {
				i += 1;
				if (board[i] != "") {
					boolean onwards = vertChecker(board, i);
					if (onwards == true) {
						return true;
					}
				}
			}
		return false;
	}
	
	public boolean vertChecker(String[] board, int i) {
		
		if (board[i] == board[i + 3] & board[i + 3] == board[i + 6]) {
			return true;
		}
		return false;
	}
	
	public boolean checkHor(String[] board) {
		int i = -3;
		for (int k = 0; k <= 2; k++) {
			i += 3;
			if (board[i] != "") {
				boolean onwards = horChecker(board, i);
				if (onwards == true) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean horChecker(String[] board, int i) {
		
		if (board[i] == board[i + 1] & board[i + 1] == board[i + 2]) {
			return true;
		}
		return false;
	}
	
	
	
	public void printBoard(String[] board) {
		
		horLine();
		Row(0, board);
		horLine();
		Row(3, board);
		horLine();
		Row(6, board);
		horLine();
	}
	
	private void Row(int i, String[] board) {
		int j = i + 2;
		for (i = j - 2; i <= j; i++) {
			cellPaddingPrefix();
			if (board[i] == "x") {
				System.out.print("x");
			} else if (board[i] == "y") {
				System.out.print("y");
			} else {
				System.out.print("-");
			}
			cellPaddingSuffix();
		}
		System.out.print("|\n");
	}
	
	private void cellPaddingSuffix() {
		System.out.print("   ");
	}
	
	private void cellPaddingPrefix() {
		System.out.print("|   ");
	}
	
	private void horLine() {
		System.out.println("- - - - - - - - - - - - -");
	}
	
}