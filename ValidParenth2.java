import java.util.Stack;

public class ValidParenth2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"(", "([)]", ")", "]"};
		for (String s : test) {
			System.out.println(isValid(s));
		}

	}

	public static boolean isValid(String s) {
		Stack stack = new Stack();
		s = s.trim();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (stack.empty() && (c == '}' |c == ']' |c == ')'))
				return false;
			else if (c == '{' | c == '[' | c == '(')
				stack.push(c);
			else if (c == ')') {
				if ((char) stack.peek() != '(')
					return false;
				else
					stack.pop();
			}
			else if (c == '}') {
				if ((char) stack.peek() != '{')
					return false;
				else
					stack.pop();
			} else if (c == ']') {
				if ((char) stack.peek() != '[')
					return false;
				else
					stack.pop();
			}
		}
		if (stack.empty())
			return true;
		else
			return false;
	}
}
