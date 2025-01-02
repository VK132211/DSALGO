package dynamicprogramming;

import java.util.Scanner;

public class CoinChange {
//	https://leetcode.com/problems/coin-change/description/
	public static int[] c; // global coins array
	public static int[] dp;

	public int f(int amount) {
		if (amount < 0)
			return Integer.MAX_VALUE; // if amt is less than 0 then its not possible
		if (amount == 0)
			return 0; // if amt is 0, give nothing
		if (dp[amount] != -1)
			return dp[amount];
		int ans = Integer.MAX_VALUE;
		int n = c.length;
		for (int i = 0; i < n; i++) { // i -> [0, n-1]
			if (amount >= c[i]) {
				ans = Math.min(ans, f(amount - c[i]));
			}
		}
		// if ans is still Integer.MAX_VALUE, then this amount is not possible
		if (ans == Integer.MAX_VALUE) {
			return dp[amount] = Integer.MAX_VALUE;
		}
		return dp[amount] = 1 + ans;
	}

	public static int f_bu(int value) {
		dp = new int[10005];
		dp[0] = 0;
		for (int amount = 1; amount <= value; amount++) {
			int ans = Integer.MAX_VALUE;
			int n = c.length;
			for (int i = 0; i < n; i++) { // i -> [0, n-1]
				if (amount >= c[i]) {
					ans = Math.min(ans, dp[amount - c[i]]);
				}
			}
			if (ans == Integer.MAX_VALUE) {
				dp[amount] = Integer.MAX_VALUE;
			} else {
				dp[amount] = 1 + ans;
			}
		}
		return dp[value];
	}

	public int coinChange(int[] coins, int amount) {
		c = coins;
		int ans = f_bu(amount);
		return (ans == Integer.MAX_VALUE) ? -1 : ans;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Prompt user to enter the coins array
		System.out.println("Enter the number of coins:");
		int n = scanner.nextInt();
		int[] coins = new int[n];
		System.out.println("Enter the coin denominations:");
		for (int i = 0; i < n; i++) {
			coins[i] = scanner.nextInt();
		}

		// Prompt user to enter the amount
		System.out.println("Enter the amount:");
		int amount = scanner.nextInt();

		// Solve the coin change problem
		CoinChange coinChange = new CoinChange();
		int result = coinChange.coinChange(coins, amount);

		// Print the result
		if (result == -1) {
			System.out.println("It's not possible to make the amount with the given coins.");
		} else {
			System.out.println("Minimum number of coins required: " + result);
		}

		scanner.close();
	}
}
