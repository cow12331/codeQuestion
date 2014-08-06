
public class BestTimeBuyandSellStockIII {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxProfToN = new int[n + 1];
        maxProfToN[0] = 0;
        for(int i = 1; i < n; i++) {
        	for(int j = 0; j < i; j++) {
        		maxProfToN[i + 1] = Math.max(maxProfToN[i + 1], maxProfToN[j] + prices[i] - prices[j]);
        	}
        }
        return maxProfToN[n];
    }
    
    public static void main(String[] args) {
    	int[][] test = {{4,2,6,1,2},{1},{1,2,3},{1,3,1,3}};
    	for(int[] t: test) {
        	System.out.println(maxProfit(t));
    	}

    }
}
