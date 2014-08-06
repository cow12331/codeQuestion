import java.util.Stack;


public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{10,9,8,7,6,5,4,3,2,1}};
		for(int[] t : test) {
			System.out.println(maxArea(t));
		}
	}

    public static int maxArea(int[] height) {
    	int start = 0;
    	int end = height.length - 1;
    	int maxArea = 0;
    	
    	while(start < end) {
    		maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * (end - start));
    		if(height[start] < height[end]) {
    			start++;
    		}
    		else end--;
    	}
    	return maxArea;
        
    }
}
