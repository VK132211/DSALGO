package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumCostForTickets {
//	https://leetcode.com/problems/minimum-cost-for-tickets/
	public static int[] c;
	public static int lastDay;
	public static HashSet<Integer> s;
	public static int[] dp;

	public static int f(int day) {
		if (day > lastDay)
			return 0;
		if (!s.contains(day))
			return f(day + 1);
		if (dp[day] != -1)
			return dp[day];
		int ans = Math.min(c[0] + f(day + 1), Math.min(c[1] + f(day + 7), c[2] + f(day + 30)));
		return dp[day] = ans;
	}

	public int mincostTickets(int[] days, int[] costs) {
		c = costs;
		s = new HashSet<>();
		for (int day : days) {
			s.add(day);
		}
		lastDay = days[days.length - 1];
		dp = new int[400];
		Arrays.fill(dp, -1);
		return f(1);
	}
}
