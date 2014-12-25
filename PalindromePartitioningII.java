import java.util.*;


public class PalindromePartitioningII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCut("abccbaa"));
	}

    public static int minCut(String s) {
    	int n = s.length();
    	int[] minCut = new int[n];
    	boolean[][] isPa = new boolean[n][n];
    	minCut[0] = 1;
        for(int i = 1; i < n; i++) {
        	int count = 0;
        	char c = s.charAt(i);
            for(int j = 0; j <= i; j++) {
            	if(i == j) isPa[j][i] = true;
            	else {
            		if(c == s.charAt(j)) {
            			if(j == i - 1) isPa[j][i] = true;
            			else isPa[j][i] = isPa[j + 1][i - 1];
            		}
            	}
            	if(isPa[j][i] == true) {
            		count++;
            		if(minCut[i] != 0) {
            			if(j - 1  >= 0)
            			minCut[i] = Math.min(minCut[i], count + minCut[j - 1]);
            			else minCut[i] = Math.min(minCut[i], 1);
            		} else {
            			if(j - 1  >= 0)
            			minCut[i] = count + minCut[j - 1];
            			else minCut[i] = minCut[i] + 1;
            		}
            	}
            }
        }
        return minCut[n - 1] - 1;
    }
}
