
public class FindMinimuminRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinimuminRotatedSortedArray fac = new FindMinimuminRotatedSortedArray();
		int[][] test = {{1,3},{2,3,-3},{4,5,6,7, 0, 1, 2}};
		for(int[] t : test) {
			System.out.println(fac.findMin(t));
		}
	}
	int min = Integer.MAX_VALUE;
	public int findMin(int[] num) {   	
		findMinHelp(num, 0, num.length - 1);
		return min;
	}
    public void findMinHelp(int[] num, int start, int end) {   	
    	while(start < end) {
    		if(num[start] < num[end]) {
    			min = Math.min(num[start], min);
    			break;
    		}
    		else {
    			int mid = (start + end) / 2;
    			if(num[start] == num[end]) {
    				findMinHelp(num, start, mid);
    				findMinHelp(num, mid + 1, end);
    			}
    			if(num[mid] >= num[start]) start = mid + 1; 
    			else end = mid; 
    		}
    	}
    	min = Math.min(num[start], min);
    }
    
    public int findMin3(int[] num) {
    	int n = num.length;
    	int start = 0;
    	int end = n - 1;
    	int mid = (start + end) / 2;
    	
    	while(start < end) {
    		mid = (start + end) / 2;
    		if(num[start] <= num[end]) return num[start];
    		if(num[end - 1] >= num[end]) return num[end];
    		if(mid > start && mid < end) {
    			if(num[mid] < num[mid - 1] && num[mid] < num[mid + 1]) {
    				return num[mid];
    			}
    			if(num[mid] > num[start]) {
    				start = mid + 1;
    			}
    			else {
    				end = mid - 1;
    			}
    		}
    	}
    	return num[mid];
    }
    
    public int findMin2(int[] num) {
    	int start = 0;
    	int end = num.length - 1;
    	
    	while(start < end) {
    		if(num[start] < num[end]) return num[start];
    		else {
    			int mid = (start + end) / 2;
    			if(num[mid] >= num[start]) start = mid + 1; // start equal to mid
    			else end = mid; //mid maybe is minumn
    		}
    	}
    	return num[start];
    }
}
