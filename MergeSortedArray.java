import java.util.*;


public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,3,5, 0, 0, 0}};
		int[][] B = {{2,4,6}};
		int[] a = {3};
		int[] b = {3};
		for(int i = 0; i < A.length; i++) {
			merge(A[i], a[i], B[i], b[i]);
			for(int item : A[i]) {
				System.out.print(item +" ");
			}
			System.out.println("");
 		}
 	}

	public static void merge(int A[], int m, int B[], int n) {
		for(int i = m + n - 1; i >= 0; i--) {
			if(m - 1 < 0 && n - 1 >= 0) {
				A[i] = B[n - 1];
				n--;
			}
			else if(n - 1 < 0 && m - 1 >= 0) {
				A[i] = A[m - 1];
				m--;
			}
			else if(A[m - 1] > B[n - 1]) {
				A[i] = A[m - 1];
				m--;
			} 
			else {
				A[i] = B[n - 1];
				n--;				
			}
		}
    }
}
