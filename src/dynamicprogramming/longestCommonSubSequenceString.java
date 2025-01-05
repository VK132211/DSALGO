package dynamicprogramming;

public class longestCommonSubSequenceString {
//	https://leetcode.com/problems/longest-common-subsequence/
	public static int[][] dp = new int[1005][1005];

	public static int f(String s1, String s2, int i, int j) {
		if (i == -1 || j == -1) {
			return 0;
		}
		if (dp[i][j] != -1)
			return dp[i][j];
		if (s1.charAt(i) == s2.charAt(j)) {
			return dp[i][j] = 1 + f(s1, s2, i - 1, j - 1);
		} else {
			return dp[i][j] = Math.max(f(s1, s2, i - 1, j), f(s1, s2, i, j - 1));
		}
	}

	public int longestCommonSubsequence(String text1, String text2) {
		for (int i = 0; i < 1005; i++) {
			for (int j = 0; j < 1005; j++) {
				dp[i][j] = -1;
			}
		}
		return f(text1, text2, text1.length() - 1, text2.length() - 1);

	}
}
