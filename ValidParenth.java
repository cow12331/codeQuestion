import java.util.Stack;

public class ValidParenth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"{}{{}[", "{}[]", "([)]"};
		for(String s : test) {
			System.out.println(isValid(s));
		}
		
	}

	public static boolean isValid(String s) {
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		Stack stack3 = new Stack();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c == ')' && stack1.empty()) | (c == ']' && stack2.empty())
					| (c == '}' && stack3.empty())) {
				return false;
			} else if (c == '(') {
				stack1.push(c);
			} else if (c == '[') {
				stack2.push(c);
			} else if (c == '{') {
				stack3.push(c);
			} else if (c == ')') {
				stack1.pop();
			} else if (c == ']') {
				stack2.pop();
			} else if (c == '}') {
				stack3.pop();
			}
		}
		if ((stack1.empty()) && stack2.empty() && stack3.empty()) {
			return true;
		}
		else return false;
	}
}
