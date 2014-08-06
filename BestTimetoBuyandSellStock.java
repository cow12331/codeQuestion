public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{2,1,2,1,0,0,1},{3,2,1}, {1},{ 1, 2, 3, 4 } };
		for (int[] t : test) {
			System.out.println(maxProfit(t));
		}

	}

	public static int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;
		int n = prices.length;
		int[] max = new int[n];
		int[] min = new int[n];
		max[n - 1] = prices[n - 1];
		min[0] = prices[0];
		int out = 0;

		for (int i = 1; i < n; i++) {
			max[n - i - 1] = Math.max(max[n - i], prices[n - i - 1]);
			min[i] = Math.min(min[i - 1], prices[i]);
		}
		for (int i = 0; i < n; i++) {
			out = Math.max(out, max[i] - min[i]);
		}
		return out;
	}
}
