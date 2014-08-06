import java.lang.reflect.Array;
import java.util.Arrays;


public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] num = {{1,2,4,8,16,32,64,128},{-1, 2, 1, -4}};
		int[] target = {82, 1};
		for(int i = 0; i < num.length; i++) {
			System.out.println(threeSumClosest(num[i], target[i]));
		}
	}

    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int len = num.length;
        int cond = Integer.MAX_VALUE;
        int start = 0, end = len - 1, cur = 0, total = 0, out = 0; 
        for(int i = 0; i < len - 2; i++) {
        	start = i + 1;
        	end = len - 1;
        	cur = num[i];
        	while(start < end) {
        		total = cur + num[start] + num[end];
        		if(cond > Math.abs(total - target)) {
        			cond = Math.abs(total - target);
        			out = cur + num[start] + num[end];
        		}
        		if(total > target) {
        			end --;
        		}
        		else if(total < target) {
        			start++;
        		}
        		else {
        			return total;
        		}
        	}
        }
        return out;
    }
}
