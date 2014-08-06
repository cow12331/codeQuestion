import java.util.Stack;

public class LongestValidParentheses {
	public static void main(String[] args) {
		String[] test = {"(()","()(()", "()()()", "" };
		for(String t : test) {
			System.out.println(longestValidParentheses(t));
		}
	}

	public static int longestValidParentheses2(String s) {
		if (s.length() <= 1)
			return 0;
		int curMax = 0;
		int[] longest = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					longest[i] = (i - 2) >= 0 ? (longest[i - 2] + 2) : 2;
					curMax = Math.max(longest[i], curMax);
				} else { 
					// if s[i] == ')', combine the previous length.
					if (i - longest[i - 1] - 1 >= 0
							&& s.charAt(i - longest[i - 1] - 1) == '(') {
						longest[i] = longest[i - 1]
								+ 2
								+ ((i - longest[i - 1] - 2 >= 0) ? longest[i
										- longest[i - 1] - 2] : 0);
						curMax = Math.max(longest[i], curMax);
					}
				}
			}
			// else if s[i] == '(', skip it, because longest[i] must be 0
		}
		return curMax;
	}
	
	public static int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int n = s.length();
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
				stack.pop();
			} 
			else {
				stack.add(i);
			}
		}
		//if(stack.isEmpty()) return n;
		int count = 0;
		int top = n;
		while(!stack.isEmpty()) {
			count =  Math.max(count, top - stack.peek() - 1);
			top = stack.pop();
		}
		return Math.max(top, count);
	}
}
