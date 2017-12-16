package algo.backTracking;
/*
 * In ordinary chess, the pieces are only of two colors, black and white. In our version of chess, we are including new pieces with unique movements. One of the most powerful pieces in this version is the red knight.
 * The red knight can move to six different positions based on its current position (UpperLeft, UpperRight, Right, LowerRight, LowerLeft, Left) as shown in the figure below.
 * image

The board is a grid of size . Each cell is identified with a pair of coordinates , where  is the row number and  is the column number, both zero-indexed. Thus,  is the upper-left corner and  is the bottom-right corner.

Complete the function printShortestPath, which takes as input the grid size , and the coordinates of the starting and ending position  and  respectively, as input. The function does not return anything.

Given the coordinates of the starting position of the red knight and the coordinates of the destination, print the minimum number of moves that the red knight has to make in order to reach the destination and after that, print the order of the moves that must be followed to reach the destination in the shortest way. If the destination cannot be reached, print only the word "Impossible".

Note: There may be multiple shortest paths leading to the destination. Hence, assume that the red knight considers its possible neighbor locations in the following order of priority: UL, UR, R, LR, LL, L. In other words, if there are multiple possible options, the red knight prioritizes the first move in this list, as long as the shortest path is still achievable. Check sample input  for an illustration.

Input Format

The first line of input contains a single integer . The second line contains four space-separated integers .  denotes the coordinates of the starting position and  denotes the coordinates of the final position.

Constraints

the starting and the ending positions are different
Output Format

If the destination can be reached, print two lines. In the first line, print a single integer denoting the minimum number of moves that the red knight has to make in order to reach the destination. In the second line, print the space-separated sequence of moves.

If the destination cannot be reached, print a single line containing only the word Impossible.

Sample Input 0

7
6 6 0 1
Sample Output 0

4
UL UL UL L
 * 
 * */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class KnightRiderMinimumSteps {
    class cell {
        int i;
        int j;
        int steps;
        String path;
        
        cell(int i,int j, int steps,String path) {
            this.i=i;
            this.j=j;
            this.steps=steps;
            this.path=path;
        }
    }

    void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        //  Print the distance along with the sequence of moves.
        //  i and j direction, where a knight can move
        int di[] = {-2, -2, 0, 2, 2, 0};
        int dj[] = {-1, 1, 2, 1, -1, -2};
        String[] path = {"UL ", "UR ", "R ", "LR ", "LL ", "L "};
        StringBuffer result = new StringBuffer();
        Queue<cell> q =new LinkedList<cell>();
        cell start=new cell(i_start,j_start,0,"");
        q.add(start);
        
        cell temp;
        boolean[][] visited = new boolean[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                visited[i][j]=false;
            }
        }
        while(!q.isEmpty()) {
            temp=q.poll();
            visited[temp.i][temp.j]=true;
            result.append(temp.path+" ");
            if(temp.i==i_end && temp.j==j_end) {
                System.out.println(temp.steps);
                System.out.println(temp.path);
                return;
            }
            int x,y;
            for (int i = 0; i < 6; i++)
            {
              x = temp.i + di[i];
              y = temp.j + dj[i];
 
             // If rechable state is not yet visited and
             // inside board, push that state into queue
             if (isSafe(x, y, n) && !visited[x][y]) {
                q.add(new cell(x, y, temp.steps + 1,temp.path+path[i]));
             }
 
            }
        }
        System.out.println("Impossible");
    }
    
    private static boolean isSafe(int i,int j,int n) {
        if(i>=0 && i<n && j>=0 && j<n)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        KnightRiderMinimumSteps sol=new KnightRiderMinimumSteps();
        sol.printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }
}