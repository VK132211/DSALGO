package stacks;

import java.util.Stack;

public class RemoveStars {

	public String removeStars(String s) {
		Stack<Character> st = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) != '*') {
				st.push(s.charAt(i));
			} else if (s.charAt(i) == '*') {
				st.pop();
			}
			i++;
		}
		StringBuilder sb = new StringBuilder("");
		while (!st.isEmpty()) {
			sb.append(st.peek());
			st.pop();
		}
		return sb.reverse().toString();
	}

}
