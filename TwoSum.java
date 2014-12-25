import java.util.HashMap;


public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum fac = new TwoSum();
		int[][] test = {{1,2,1}, {3,2,4}, {2, 7, 11, 15}};
		int[] target = {2, 6, 9};
		for(int i = 0; i < test.length; i++) {
			int[] out = new int[3];
			out = fac.twoSum(test[i], target[i]);
			System.out.println(out[0] + " " + out[1]);
		}
	}

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] out = new int[3];
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])) {
            	out[1] = i + 1;
            	out[0] = map.get(target - numbers[i]);
            } else {
            	map.put(numbers[i], i + 1);
            }
        }
        return out;
    }
}
