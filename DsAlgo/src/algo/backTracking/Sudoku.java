package algo.backTracking;

public class Sudoku {
	public static final int ROW = 9;
	public static final int COLUMN = 9;
	int[][] sudokuValues;

	boolean isSafe(int x, int y, int input) {
		if(x>ROW-1 || y>COLUMN-1)
			return false;
		for (int i = 0; i < ROW; i++) {
			if (sudokuValues[x][i] == input)
				return false;
		}
		for (int j = 0; j < COLUMN; j++) {
			if (sudokuValues[j][y] == input)
				return false;
		}
		int row_start = x - x % 3;
		int col_start = y - y % 3;
		for (int k = row_start; k < 3; k++) {
			for (int l = col_start; l < 3; l++) {
				if (sudokuValues[k][l] == input)
					return false;
			}
		}
		return true;
	}

	public boolean sudoku(int row, int col) {
		//
		if (row >= (ROW - 1) || col >= (COLUMN - 1))
			return true;

		if (sudokuValues[row][col] != 0) {
			for(int i=row;i<ROW;i++){
				for(int j=col;j<COLUMN;j++) {
					if(sudokuValues[i][j]==0) {
						row=i;
						col=j;
						break;
					}
				}
			}
		}
		for (int value = 1; value <= 9; value++) {
			if (isSafe(row, col, value)) {
				sudokuValues[row][col] = value;
				int nrow = row;
				int ncol = 0;
				if (col < COLUMN - 1)
					ncol = col+1;
				else
					nrow = row+1;
				if (sudoku(nrow, ncol))
					return true;
				sudokuValues[row][col] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Sudoku testObject = new Sudoku();
		int[][] test = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		testObject.sudokuValues = test;
		testObject.sudoku(0, 0);
		//if (testObject.sudoku(0, 0)) {
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COLUMN; j++) {
					System.out.print(testObject.sudokuValues[i][j]+" ");
				}
				System.out.println("\n");
			}
		//}
	}
}
