
public class RemoveDuplicatesfromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,1,2,2,3},{1,2,2,2},{1,1,1,2,2,3}};
		for(int[] t : test) {
			System.out.println(removeDuplicates(t));
		}
	}
	
    public static int removeDuplicates(int[] A) {
        if(A.length < 2) return A.length;
        int index = 1;
        
        for(int i = 1; i < A.length; i++){
            if(A[i] != A[i - 1]) {
                A[index] = A[i];
                index++;
            }
        }
        return index;
    }

}
