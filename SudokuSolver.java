// Write a program to solve a Sudoku puzzle by filling the empty cells.

// Empty cells are indicated by the character '.'.

// You may assume that there will be only one unique solution.

class SudokuSolver {
	private boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					continue;
				}

				for (char a = '1'; a <= '9'; a++) {
					if (isValid(board, i, j, a)) {
						board[i][j] = a;
						if (solve(board)) {
							return true;
						} else {
							board[i][j] = '.';
						}
					}
				}
				return false;
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int x, int y, char a) {
		//colunm
		for (int i = 0; i < 9; i++) {
			if (board[i][y] == '.') {
				continue;
			}
			if (board[i][y] == a) {
				return false;
			}
		}
		//row
		for (int i = 0; i < 9; i++) {
			if (board[x][i] == '.') {
				continue;
			}
			if (board[x][i] == a) {
				return false;
			}
		}
		//for chamber
		for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
			for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (board[i][j] == a) {
					return false;
				}
			}
		}
		return true;
	}

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		solve(board);
    }
}