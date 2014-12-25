
public class MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{-1}};
		for(int[] t : test) {
			System.out.println(maxSubArray(t));
		}
	}

	//iterate the array from left to right
	//record the max sum of subArray that end at A[i]
	//when iterate next, compare A[i] with A[i] + A[i - 1]
    public static int maxSubArray(int[] A) {
        int sum = A[0];
        for(int i = 1; i < A.length; i++) {
            if(A[i - 1] + A[i] >= A[i]) {
                A[i] = A[i - 1] + A[i];
            }
            sum = Math.max(sum, A[i]);
        }        
        return sum;
    }
}
