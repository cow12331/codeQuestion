import java.util.ArrayList;
import java.util.Arrays;


public class NextPermutaion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,2,1,5,4,3,3,2,1},{1,1,5},{1}};
		for(int[] t : test) {
			nextPermutation(t);
			for(int i : t) {
				System.out.print(i +" ");
			}
			System.out.print("\n");
		}
	}

    public static void nextPermutation(int[] num) {
        int n = num.length;
        int swap1 = -1;
        int rightMin = Integer.MAX_VALUE;
        int swap2 = -1;
        for(int i = n - 1; i >= 1; i--) {
        	if(num[i] > num[i - 1]) {
        		swap1 = i - 1;
        		break;
        	}
        }
        if(swap1 == -1) {
        	Arrays.sort(num);
        	return;
        }
        for(int i = n - 1; i >= swap1 + 1; i--) {
        	if(num[i] > num[swap1] && num[i] < rightMin) {
        		rightMin = num[i];
        		swap2 = i;
        	}
        }
        int temp = num[swap2];
        num[swap2] = num[swap1];
        num[swap1] = temp;
        Arrays.sort(num, swap1 + 1, n);
    }
}
