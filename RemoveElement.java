
public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] test= {{1,1},{1,1,2},{1,5}};
		for(int[] i : test) {
			System.out.println(removeElement2(i, 1));
		}

	}
	
    public static int removeElement(int[] A, int elem) {
        int n = A.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
        	if(A[i] == elem) {
        		count++;
        		A[i] = elem + 1;
        	}
        }
        return n - count;
    }
    
    public static int removeElement2(int[] A, int elem) {
        int count = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == elem) {
                ++count;
            } else if(count > 0) {
                A[i - count] = A[i];
            }
        }
        return A.length - count;
    }
}
