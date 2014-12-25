import java.util.*;


public class ClimbingStairs {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {1, 25, 2, 3};
		for(int t : test) {
			System.out.println(climbStairs(t));
		}
	}

//    public int climbStairs(int n) {
//    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//    	return climbStairsImpl(n, map) + climbStairsImpl(n - 1, map);
//    }	
//	
//    
//    public static int climbStairsImpl(int n, HashMap<Integer, Integer> map) {
//    	if(map.containsKey(n)) return map.get(n);
//    	else if(n <= 1) return 1;
//        else if(n == 2) return 2;
//        else {
//        	int n1 = climbStairsImpl(n - 1, map);
//        	int n2 = climbStairsImpl(n - 2, map);
//        	map.put(n - 1, n1);
//        	map.put(n - 2, n2);
//        	return  n1 + n2;
//        }
//    }
	
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static int climbStairs(int n) {
    	if(map.containsKey(n)) return map.get(n);
    	else if(n == 1) return 1;
    	else if(n == 2) return 2;
		else {
			int n1 = climbStairs(n - 1);
			int n2 = climbStairs(n - 2);
			map.put(n - 1, n1);
			map.put(n - 2, n2);
			return n1 + n2;
		}
    }	
}
