
public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int searchInsert(int[] A, int target) {
        int n = A.length;
        int start = 0;
        int end = n - 1;
        
        while(start <= end) {
            int mid = (start + end)/2;
            if(target > A[mid]) {
                start = mid + 1;
            }
            else if(target < A[mid]) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        //if(target > A[start]) return start + 1;
        //else return start;
        return start;
    }
}
