package algo.backTracking;

public class NQueensProblem {
	/*
	 * Utility function to check if new queen position sol[row][col]
	 * is according to the constraints. It assumes that we have Queens already placed
	 * in columns left to col. So we check for constraints for the new queen with the already placed queen
	 * **/
	boolean isSafe(int[][] sol,int row,int col,int n) {
		int i,j;
		//check Queen in this row for columns left to col
		for(i=0;i<col;i++) {
			if(sol[row][i]==1)
				return false;
		}
		//check upper left diagonal
		for(i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
			if(sol[i][j]==1)
				return false;
		}
		//check lower left diagonal
		for(i=row+1,j=col-1;i<n && j>=0;i++,j--) {
			if(sol[i][j]==1)
				return false;
		}
		return true;
	}
	
	/* A utility function to print solution */
    void printSolution(int board[][],int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
    }
 
	
	boolean NQueenUtil (int[][] sol,int col,int n){
		if(col==n)
			return true;
		
		//try putting Queen in each row for this column
		for(int i=0;i<n;i++) {
			
			//if this position is correct according to the constraints
			if(isSafe(sol,i,col,n)){
				sol[i][col]=1;
				//check if we reach the final solution when queen is in this row and column
				if(NQueenUtil(sol,col+1,n)==true)
					return true;
				//if we don't reach the solution with this column backtrack
				sol[i][col]=0;
			}
		}
		//if we don't get solution for any row return false, so last column can be back tracked
		return false;
	}
	
	boolean NQueens(int n){
		//create matrix to store result of NQueens problem
		int[][] sol = new int[n][n];
		
		//intialize all places with 0
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sol[i][j]=0;
			}
		}
		if(NQueenUtil(sol,0,n)==false) {
			System.out.println("No Solution exists");
			return false;
		}
		
		printSolution(sol,n);
		return true;
	}

	public static void main(String[] args) {
		NQueensProblem test = new NQueensProblem();
		test.NQueens(1);
		test.NQueens(2);
		test.NQueens(3);
		test.NQueens(4);
		test.NQueens(5);
	}
}
