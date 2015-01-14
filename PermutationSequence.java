import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation2(3, 2));
		System.out.println(getPermutation2(3, 3));
		System.out.println(getPermutation2(3, 6));
	}

	public static String getPermutation(int n, int k) {
		int[] fac = new int[n];
		fac[0] = 1;
		int[] out = new int[n];
		boolean[] used = new boolean[n];

		for (int i = 1; i < n; i++) {
			fac[i] = fac[i - 1] * (i + 1);
		}

		int index = 0;
		// find the highest order number
		while (index < n) {
			int top = 1;
			while (n - index - 2 >= 0 && k - fac[n - index - 2] > 0) {
				k -= fac[n - index - 2];
				top++;
			}

			int count = 0;
			for (int i = 0; i < n; i++) {
				if (used[i] != true) {
					count++;
				}
				if (count == top) {
					top = i + 1;
					used[i] = true;
					break;
				}
			}
			out[index] = top;
			index++;

		}
		String ans = "";
		for (int i : out) {
			ans = ans + i;
		}
		return ans;
	}

	// For the n th number, we can get it by k mod factorial of (n - 1) and use
	// remain to do this
	public static String getPermutation2(int n, int k) {
		String ans = "";
		List<Integer> num = new ArrayList<Integer>();
		int[] fac = new int[n];
		fac[0] = 1;
		for (int i = 1; i < n; i++) {
			fac[i] = fac[i - 1] * i;
		}
		for (int i = 1; i < n + 1; i++) {
			num.add(i);
		}
		k--;
		for (int i = 0; i < n; i++) {
			//get the highest number
			int highest = k / (fac[n - 1 - i]);
			//get next  
			k = k % fac[n - 1 - i];
			highest = highest == 0 ? 0 : highest;
			ans = ans + num.get(highest);
			num.remove(highest);
		}
		return ans;
	}
}
