package algo.dynamicProgramming;
/* Dynamic Programming is an algorithmic paradigm that solves a given complex problem by breaking it into subproblems 
 * and stores the results of subproblems to avoid computing the same results again.
 *  Following are the two main properties of a problem that suggest that
 *   the given problem can be solved using Dynamic programming:
 *   1) Overlapping Subproblems:
 *       Dynamic Programming is mainly used when solutions of same subproblems are needed again and again. 
 *       In dynamic programming, computed solutions to subproblems are stored in a table 
 *       so that these don’t have to recomputed. 
 *       So Dynamic Programming is not useful when there are no common (overlapping) subproblems 
 *       because there is no point storing the solutions if they are not needed again. 
 *       For example, Binary Search doesn’t have common subproblems.
 *       Fibonacci series problem has many sob problems
 *       
 *       There are following two different ways to store the values of sub problem so that these values can be reused:
 *         a) Memoization (Top Down)
 *              The memoized program for a problem is similar to the recursive version with a small modification 
 *              that it looks into a lookup table before computing solutions. 
 *              We initialize a lookup array with all initial values as NIL. 
 *              Whenever we need solution to a subproblem, we first look into the lookup table. 
 *              If the precomputed value is there then we return that value, 
 *              otherwise we calculate the value and put the result in lookup table so that it can be reused later.
 *         b) Tabulation (Bottom Up)
 *               The tabulated program for a given problem builds a table in bottom up fashion 
 *               and returns the last entry from table. 
 *               For example, for the same Fibonacci number, we first calculate fib(0) 
 *               then fib(1) then fib(2) then fib(3) and so on. 
 *               So literally, we are building the solutions of subproblems bottom-up.
 *   2) Optimal Substructure
 *        A given problems has Optimal Substructure Property if 
 *        "optimal solution of the given problem can be obtained by using optimal solutions of its subproblems."
 *        
 *        The Shortest Path problem has following optimal substructure property:
 *        If a node x lies in the shortest path from a source node u to destination node v then 
 *        the shortest path from u to v is combination of shortest path from u to x 
 *        and shortest path from x to v. 
 *        The standard All Pair Shortest Path algorithms like
 *         Floyd–Warshall and Bellman–Ford are typical examples of Dynamic Programming.
 *         
 *         On the other hand, the Longest Path problem doesn’t have the Optimal Substructure property. 
 *         Here by Longest Path we mean longest simple path (path without cycle) between two nodes.
 *         Below longest path from q to t != longest path from (q to r) + longest path from (r to t)
 *         q -> r
 *         |    |
 *         V    V
 *         s -> t
 * */
public class DyanmicProgramming {

	public void longestIncreasingSubsequence(){
		
	}
	
	/*
	 * The problem is to count all the possible paths from top left to bottom right of a mXn matrix 
	 * with the constraints that from each cell you can either move only to right or down
	 * 
	 * */
	
	
	/*
	 * The problem is to print all the possible paths from top left to bottom right of a mXn matrix 
	 * with the constraints that from each cell you can either move only to right or down.
	 * 
	 * The algorithm is a simple recursive algorithm, 
	 * from each cell first print all paths by going down and then print all paths by going right.
	 * Do this recursively for each cell encountered.
	 * 
	 * */
	/*https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
	 * https://www.geeksforgeeks.org/trapping-rain-water/
	 * https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
	 * https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
	 */
}
