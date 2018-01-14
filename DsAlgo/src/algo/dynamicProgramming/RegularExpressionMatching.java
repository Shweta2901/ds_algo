package algo.dynamicProgramming;

public class RegularExpressionMatching {

	public static boolean matchReExp(String text, String pattern) {
		if (pattern.length() == 0 || pattern.isEmpty() || (text == null
				|| text.isEmpty() && (pattern != null || !pattern.isEmpty() && pattern.charAt(0) != '*')))
			return false;

		if (pattern == null && text == null)
			return true;

		boolean[][] result = new boolean[text.length() + 1][pattern.length() + 1];

		// for text as null and pattern as null, it is a match
		result[0][0] = true;

		// if pattern is null, it is "No Match" for any text
		for (int i = 1; i <= text.length(); i++)
			result[i][0] = false;

		// if text is null
		for (int j = 1; j <= pattern.length(); j++) {
			if (pattern.charAt(j - 1) == '*')
				result[0][j] = result[0][j - 1];
			else
				result[0][j] = false;
		}
		// for rest of the result
		for (int i = 1; i < text.length() + 1; i++) {
			for (int j = 1; j < pattern.length() + 1; j++) {
				if (pattern.charAt(j - 1) == '*') {
					result[i][j] = result[i - 1][j] || result[i][j - 1];
				} else if (pattern.charAt(j - 1) == '?' || pattern.charAt(j - 1) == text.charAt(i - 1)) {
					result[i][j] = result[i - 1][j - 1];
				} else {
					result[i][j] = false;
				}
			}
		}
		return result[text.length()][pattern.length()];
	}

	public static void main(String[] args) {
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "*****ba*****ab"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "ba*****ab"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "ba*ab"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "a*ab"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "a*****ab"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "*a*****ab"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "ba*ab****"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "****"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "*"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "aa?ab"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "b*b"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "a*a"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "baaabab"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "?baaabab"));
		System.out.println(RegularExpressionMatching.matchReExp("baaabab", "*baaaba*"));
	}

}
