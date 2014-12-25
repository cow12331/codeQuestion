
public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int uniquePaths2(int m, int n) {
        if(m <= 1 || n <= 1) return 1;
        int[][] path  = new int[m][n];
        for(int i = 0; i < n; i++) {
            path[0][i] = 1;
        }
        for(int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }
    
    public int uniquePaths3(int m, int n) {
    	int[] path = new int[n];
    	for(int i = 0; i < n; i++) {
    		path[i] = 1;
    	}
    	for(int i = 1; i < m; i++) {
    		for(int j = 1; j < n; j++) {
    			path[j] = path[j] + path[j - 1];
    		}
    	}
    	return path[n - 1];
    }
    
    public int uniquePaths(int m, int n) {
    	double out = 1;
    	double deno = 1;
    	double numer = m + n - 2;
    	for(int i = 0; i < n - 1; i++) {
    		out *= ((numer - i)/(deno + i));
    	}
    	return (int)out;
    }
}
