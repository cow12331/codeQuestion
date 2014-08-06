package test;

public class UniqueBinarySearchTrees {
	public static int numTrees(int n) {
		if (n == 0 || n == 1)
			return 1;
		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				count[i] += count[j] * count[i - 1 - j];
			}
		}
		return count[n];
	}

	public static int numTree2(int n) {
		int[] count = new int[n + 1];
		return numTreeRun(n, count);
	}
	
	public static int numTreeRun(int n, int[] count) {
		if (n == 0 || n == 1)
			return 1;
		else if(count[n] != 0) return count[n];
		else {
			int num = 0;
			for (int i = 0; i < n; i++) {
				{
					num += numTreeRun(i, count) * numTreeRun(n - 1 - i, count);
				}
			}
			count[n] = num;
			return num;
		}
	}

	public static void main(String[] args) {
		System.out.println(numTrees(3));
		System.out.println(numTree2(3));
	}
}
