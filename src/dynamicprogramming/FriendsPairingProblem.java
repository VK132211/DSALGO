package dynamicprogramming;

import java.util.Scanner;

//Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up
//Bottom Up Approach
public class FriendsPairingProblem {
	public static int numberOfWays(int n) {
		int[] a = new int[10005];
		a[0] = 0;
		a[1] = 1;
		a[2] = 2;
		for (int i = 3; i <= n; i++) {
			a[i] = a[i - 1] + (i - 1) * a[i - 2];
		}
		System.out.println(a[n]);
		return a[n];

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of friends:");
		int numberOfFriends = sc.nextInt();
		numberOfWays(numberOfFriends);
		sc.close();
	}
}
