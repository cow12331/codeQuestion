
public class SearchinRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,3},{3,4,5,1,2},{5, 1, 3},{1,3,5},{4, 5, 6, 7, 0, 1, 2}};
		int[] t = {3,5,5, 1,3};
		for(int i =0; i < test.length; i++) {
			System.out.println(search(test[i], t[i]));
		}
	}

    public static int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        int mid = (start + end) / 2; 
        while(start <= end) {
        	mid = (start + end) / 2;
        	if(A[mid] == target) return mid;
        	if(target < A[mid]) {
        		if(target < A[start]) {
        			if(A[mid] < A[start]) {
        				end = mid - 1;
        			} else {
            			start = mid + 1; 				
        			}
        		}
        		else {
        			end = mid - 1;
        		}
        	}
        	else {
        		if(target < A[start]) {
        			start = mid + 1;
        		} else {
        			if(A[mid] >= A[start]) { //
        				start = mid + 1;
        			} else {
        				end = mid - 1;
        			}
        		}
        	}
        	
        }
        return -1;
    }
}
