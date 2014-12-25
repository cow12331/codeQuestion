import java.util.HashSet;


public class LongestSequence {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{-1, 0, 1},{2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645}};

		for(int[] i : test) {
			System.out.println(longestConsecutive(i));
		}
	}

    public static int longestConsecutive(int[] num) {
    	HashSet<Integer> set = new HashSet<Integer>();   	
    	int max = 0;   	
    	for(int i : num) {
    		set.add(i);
    	}
    	
    	while(set.iterator().hasNext()) {
    		int count = 0;
    		int temp = set.iterator().next();
    		int temp2 = temp + 1;
    		while(set.contains(temp)) {
    			count++;
    			set.remove(temp);
    			temp--;
    		}
    		while(set.contains(temp2)) {
    			count++;
    			set.remove(temp2);
    			temp2++;
    		}
    		max = Math.max(max, count);
    	}
    	return max;
    }    
}
