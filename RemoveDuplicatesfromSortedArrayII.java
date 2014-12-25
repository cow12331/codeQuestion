
public class RemoveDuplicatesfromSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,1,1,2,2,3},{1,1,1,2},{1,2,2,2}};
		for(int[] t : test) {
			System.out.println(removeDuplicates(t));
		}
	}

	
    public static int removeDuplicates(int[] A) {
     	int n = A.length;
    	if(n < 3) return n;
    	int index = 2;
    	
    	for(int i = 2; i < n; i++) {
    		if(A[i] != A[index - 2]) {
    			A[index++] = A[i];
    		}
    	}
    	
    	return index;
    }
    
    public static int removeDuplicates2(int[] A) {
     	int n = A.length;
    	if(n < 3) return n;
    	int count = 1;
    	int index = 0;
    	
    	//compare the index that we will place
    	for(int i = 1; i < A.length; i++) {
    		if(A[i] == A[index]) count++;
    		else {
    			count = 1;
    		}
    		
    		if(count < 3) {
    			index++;
    		}
    		A[index] = A[i];
    	}
    	
    	return index + 1;
    }
}
