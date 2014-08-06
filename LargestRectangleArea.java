
import java.util.Stack;

public class LargestRectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = { { 2, 1, 5, 6, 2, 3 }, { 2, 1, 2 }, { 1 }, {} };
		for (int[] t : test) {
			System.out.println(largestRectangleArea(t));
		}
	}

	public static int largestRectangleArea(int[] height) {
		Stack<Integer> hstack = new Stack<Integer>();
		Stack<Integer> istack = new Stack<Integer>();
		int area = 0;

		for (int i = 0; i < height.length; i++) {
			if (hstack.isEmpty() || height[i] >= hstack.peek()) {
				hstack.push(height[i]);
				istack.push(i);
			} else if (hstack.peek() > height[i]) {
				int li = 0;
				while (!hstack.isEmpty() && hstack.peek() > height[i]) {
					int th = hstack.pop();
					li = istack.pop();
					area = Math.max(area, (i - li) * th);

				}
				hstack.push(height[i]);
				istack.push(li);
			}
		}

		while (!hstack.isEmpty()) {
			int th = hstack.pop();
			int ti = istack.pop();
			area = Math.max(area, (height.length - ti) * th);
		}
		return area;
	}
}
