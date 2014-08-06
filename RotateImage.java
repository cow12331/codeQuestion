
public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1, 2}, {3, 4}};
		rotate(test);
		System.out.println(test[0][0]);
		int[][] a = {{1, 2}, {3, 4}};
		int[][] b = {{2, 1}, {4, 3}};
		a = b;
		System.out.println(a[0][0]);
	}
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] out = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                out[i][j] = matrix[n - j - 1][i]; 
            }
        }
//        for(int i = 0; i < n; i++) {
//        	for(int j = 0; j < n; j++) {
//        		matrix[i][j] = out[i][j];
//        	}
//        }
        //matrix = out;
        int[][] b = {{2, 1}, {4, 3}};
        matrix = b;
        System.out.println(matrix[0][0]);
    }
    
    
}
