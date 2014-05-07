
public class CandyBetter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] test = {
				{ 54, 26, 54, 54},
				{ 58, 21, 72, 77, 48, 9, 38, 71, 68, 77, 82, 47, 25, 94, 89,
					54, 26, 54, 54, 99, 64, 71, 76, 63, 81, 82, 60, 64, 29,
					51, 87, 87, 72, 12, 16, 20, 21, 54, 43, 41, 83, 77, 41,
					61, 72, 82, 15, 50, 36, 69, 49, 53, 92, 77, 16, 73, 12,
					28, 37, 41, 79, 25, 80, 3, 37, 48, 23, 10, 55, 19, 51,
					38, 96, 92, 99, 68, 75, 14, 18, 63, 35, 19, 68, 28, 49,
					36, 53, 61, 64, 91, 2, 43, 68, 34, 46, 57, 82, 22, 67,
					89 },
				{ 1, 1, 1 },
				{ 1, 2, 2 },
				{ 14, 18, 63, 35, 19, 68, 28 },
				{ 1, 3, 5 },
				{ 1, 2, 2, 2, 3 },
				{  } };
		// int[][] test = {{1,2,1}, { 14, 18, 63, 35, 19, 68, 28 } };
		 
		for (int[] i : test) {
			System.out.println(candy(i));
		}
	}

	public static int candy(int[] ratings) {
		if(ratings.length == 0) return 0;
		if(ratings.length == 1) return 1;
		int[] candy1 = new int[ratings.length];
		int[] candy2 = new int[ratings.length];
		int[] candy = new int[ratings.length];
		candy1[0] = 1;
		candy2[ratings.length - 1] = 1;
		int count = 0;
		
		for(int i = 1; i < ratings.length; i++) {
			candy1[i] = ratings[i] > ratings[i - 1] ? candy1[i - 1] + 1 : 1;
		}
		for(int i = ratings.length - 2; i >= 0; i--) {
			candy2[i] = ratings[i] > ratings[i + 1] ? candy2[i + 1] + 1 : 1;
		}
		for(int i = 0; i < ratings.length; i++) {
			candy[i] = Math.max(candy1[i], candy2[i]);
			count += candy[i];
		}
		return count;
	}
}
