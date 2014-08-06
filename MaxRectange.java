public class MaxRectange {
    public static int maximalRectangle(char[][] matrix) {
    	
    	if(matrix.length == 0)return 0;
    	int[][] intMatrix = convertToInt(matrix);
        int maxArea = 0;
        int matricH = intMatrix.length;
        int matricW = intMatrix[0].length;

        for(int i = 0; i < matricH; i++) {
        	for(int j = 0; j < matricW; j++) {
        		int wid = 0;
        		int lon = 0; 
        		int area = 0;
        		
        		for(int w = j; w < matricW; w++) {
        			if(intMatrix[i][w] == 1) wid++;
        			else break;
        		}
        		for(int l = i; l < matricH; l++) {
        			if(intMatrix[l][j] == 1) lon++;
        			else break;
        		}
        		area = wid * lon;
        		if(area > maxArea) maxArea = area;
        	}
        }
        return maxArea;
    }
    
    
    public static int[][] convertToInt(char[][] matrix) {  
        int[][] converted = new int[matrix.length][matrix[0].length];  
        for (int i = 0; i < matrix.length; i++) {  
            for (int j = 0; j < matrix[0].length; j++) {  
                converted[i][j] = matrix[i][j] - '0';  
            }  
        }  
        return converted;  
    }  
    
    public static void main(String[] args) {
    	char[][][] test= {{{'1', '1'}},{{'1','1','1'}}, {{'1','1','1'},{'1','1','1'},{'1','1','1'}}, {{'0','1','1'},{'1','1','1'},{'1','1','1'}}, {{'0','0','0'},{'0','0','0'},{'0','0','0'}},{}, {{'0','1','0'},{'0','1','0'},{'1','1','1'}}};
    	for(char[][] t : test) {
    		System.out.println(maximalRectangle(t));
    	}
    }
}