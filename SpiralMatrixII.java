
public class SpiralMatrixII {

	public static void main(String[] args) {
		int[] test= {0, 5, 3};
		for(int t : test) {
			int[][] matrix = generateMatrix(t);
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix.length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println("=========");
		}
	}

    
    public static int[][] generateMatrix(int n) {
        int[][] matric = new int[n][n];
        
        int index = 1;
        int count = 0;
        while(true) {
        	if(index == n * n) {
        		matric[n/2][n/2] = n*n; 
        		break;
        	}
            for(int i = count; i < n - count - 1; i++) {
            	matric[count][i] = index++;
            }
            for(int i = count; i < n - count - 1; i++) {
            	matric[i][n - count - 1] = index++;
            }
            for(int i = count; i < n - count - 1; i++) {
            	matric[n - count - 1][n - 1 - i] = index++;
            }
            for(int i = count; i < n - count - 1; i++) {
            	matric[n - i - 1][count] = index++;
            }           
            count++;
            if(index > n * n) break;
        }
        return matric;
    }
}
