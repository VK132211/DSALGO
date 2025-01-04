package dynamicprogramming;

import java.util.Arrays;

public class ArithmeticSlice {

	public static int[] arr;
	public static int[] dp = new int[5004];

	public static int f(int i) {
		if (i == 0 || i == 1)
			return 0;
		if (dp[i] != -1)
			return dp[i];
		if (arr[i] - arr[i - 1] != arr[i - 1] - arr[i - 2]) {
			return dp[i] = 0;
		} else {
			return dp[i] = 1 + f(i - 1);
		}
	}

	public int numberOfArithmeticSlices(int[] nums) {
		int ans = 0;
		arr = nums;
		Arrays.fill(dp, -1);
		for (int i = 0; i < nums.length; i++) {
			ans += f(i);
		}
		return ans;

	}
}
