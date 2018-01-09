package algo.backTracking;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a dictionary, a method to do lookup in dictionary and a M x N board 
 * where every cell has one character. 
 * Find all possible words that can be formed by a sequence of adjacent characters. 
 * Note that we can move to any of 8 adjacent characters, but a word should not have 
 * multiple instances of same cell.
 * 
 * Example:
 * Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
 *       boggle[][]   = {{'G','I','Z'},
 *                       {'U','E','K'},
 *                       {'Q','S','E'}};
 * Output: Following words of dictionary are present
 *            GEEKS
 *            QUIZ
 * */
public class WordBoggle {

	private static int[] xpositions = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static int[] ypositions = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static boolean isSafe(int x, int y, int row, int col) {
		if (x >= row || x < 0 || y < 0 || y >= col)
			return false;
		return true;
	}

	public static void getAllWords(int row, int col, int x, int y, boolean[][] visited, String word, Set<String> dict,
			char[][] booggle) {

		visited[x][y] = true;
		word = word + booggle[x][y];
		if (dict.contains(word)) {
			System.out.println(word);
		}
		int nx, ny;
		// check all eight positions
		for (int i = 0; i < 8; i++) {
			nx = x + xpositions[i];
			ny = y + ypositions[i];
			if (isSafe(nx, ny, row, col) && visited[nx][ny] == false) {
				getAllWords(row, col, x + xpositions[i], y + ypositions[i], visited, word, dict, booggle);
			}
		}
		visited[x][y] = false;
		word = word.substring(0, word.length());
	}

	public static void main(String[] args) {
		char[][] booggle = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
		Set<String> dict = new HashSet<String>();
		dict.add("GEEKS");
		dict.add("FOR");
		dict.add("QUIZ");
		dict.add("GO");
		for (int i = 0; i < booggle.length; i++) {
			for (int j = 0; j < booggle[0].length; j++) {
				boolean[][] visited = new boolean[booggle.length][booggle[0].length];
				getAllWords(booggle.length, booggle[0].length, i, j, visited, "", dict, booggle);
			}
		}
	}
}
