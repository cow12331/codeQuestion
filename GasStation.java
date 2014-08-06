public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0;
        int start = 0;
        int end = 0;
        int count = 1;
        remain += gas[start] - cost[start];
        int n = gas.length;
        
        while(count < n) {            
            if(remain >= 0) {
            	end = (++end) % n;
            	remain += gas[end] - cost[end];
            } else {
            	start = (--start) > 0 ? (start % n) : (start % n + n); 
            	remain += gas[start] - cost[start];
            }
            count++;
        }
        if(remain >= 0) return start;
        else return -1;
    }
    
    public static void main(String args[]) {
    	int[][] test1 = {{1,2,3,3},{1, 2}};
    	int[][] test2 = {{2,1,5,1},{2, 1}};
    	for(int i = 0; i < test1.length; i++) {
    		System.out.println(canCompleteCircuit(test1[i],test2[i]));
    	}
    	
    }
}