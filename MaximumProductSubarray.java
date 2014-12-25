
public class MaximumProductSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{-2}, {2,3,-2,4}};
		for(int[] t : test) {
			System.out.println(maxProduct(t));
		}
	}

    public static int maxProduct(int[] A) {
        int len = A.length;
        int[] pos = new int[len];
        pos[0] = A[0] >= 0 ? A[0] : 1;
        int[] neg = new int[len];
        neg[0] = A[0] < 0 ? A[0] : 0;
        int out = A[0];
        for(int i = 1; i < A.length; i++) {
        	if(A[i] >= 0) {
        		pos[i] = Math.max(pos[i - 1] * A[i], A[i]);
        		neg[i] = neg[i - 1] * A[i]; 
        		
        	} else {
        		pos[i] = neg[i - 1] * A[i];
        		neg[i] = Math.min(pos[i - 1] * A[i], A[i]);
        	}
        	out = Math.max(out, pos[i]);
        }
        return out;
    }
}
