import java.util.HashMap;


public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int a : A) {
        	if(map.containsKey(a)) {
        		map.put(a, map.get(a) + 1);
        	}
        	else {
        		map.put(a, 1);
        	}
        }
        for(int i : map.keySet()) {
        	if(map.get(i) == 1) return i;
        }
        return -1;
    }
}
