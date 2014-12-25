
public class MinJumpArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,3,10,1,1,1,1,1},{1}, {0,2,3},{1,2,1,1,-100}, {1,1,0,1}, {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}};
		for(int[] t : test) {
			System.out.println(minJump(t));
		}
	}

	public static int minJump(int[] array) {
		int n = array.length;
		if(n == 1 && array[0] == 0) return 0;
		int[] out = new int[n];

		for(int i = 1; i < n; i ++) {
			out[i] = -1;
			for(int j = 0; j < i; j++) {
				if(out[j] >= 0 && array[j] + j >= i) {
					out[i] = out[i] == -1 ? out[j] + 1 : Math.min(out[i], out[j] + 1);
				}
			}
		}
		return out[n - 1];
	}
}
