package stacks;

import java.util.Stack;

public class AsteroidCollision {

	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> st = new Stack<>();
		int i = 0;
		while (i < asteroids.length) {
			if (st.isEmpty()) {
				st.push(asteroids[i]);
				i++;
			} else {
				if (st.peek() > 0 && asteroids[i] < 0) {

					if (Math.abs(st.peek()) == Math.abs(asteroids[i])) {
						st.pop();
						i++;
					} else {
						if (Math.abs(st.peek()) > Math.abs(asteroids[i])) {
							i++;
						} else {
							while (!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0
									&& Math.abs(st.peek()) < Math.abs(asteroids[i])) {
								st.pop();
							}
						}
					}
				} else {
					st.push(asteroids[i]);
					i++;
				}
			}
		}
		int[] result = new int[st.size()];
		for (int idx = result.length - 1; idx >= 0; idx--) {
			result[idx] = st.peek();
			st.pop();
		}
		return result;
	}
}
