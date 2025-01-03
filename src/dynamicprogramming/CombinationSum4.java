package dynamicprogramming;

import java.util.Arrays;

public class CombinationSum4 {
//	https://leetcode.com/problems/combination-sum-iv/description/
	public static int[] arr;
	public static int[] dp = new int[1005];

	public int f(int target) {
		if (target == 0)
			return 1;
		if (dp[target] != -1)
			return dp[target];
		int n = arr.length;
		int result = 0;
		for (int k = 0; k < n; k++) {
			if (target - arr[k] >= 0) {
				result += f(target - arr[k]);
			}
		}
		return dp[target] = result;
	}

	public int combinationSum4(int[] nums, int target) {
		arr = nums;
		Arrays.fill(dp, -1);
		return f(target);
	}
}
