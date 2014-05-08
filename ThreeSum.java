import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public static void main(String[] args) {
		int[][] test = {
				{ -1, 0, -1, 2, -1 },
				{ 0, 0, 0 },
				{ -9, -14, -3, 2, 0, -11, -5, 11, 5, -5, 4, -4, 5, -15, 14, -8,
						-11, 10, -6, 1, -14, -12, -13, -11, 9, -7, -2, -13, 2,
						2, -15, 1, 3, -3, -12, -12, 1, -2, 6, 14, 0, -4, -13,
						-10, -12, 8, -2, -8, 3, -1, 8, 4, -6, 2, 1, 10, 2, 14,
						4, 12, 1, 4, -2, 11, 9, -7, 6, -13, 7, -3, 8, 14, 8,
						10, 12, 11, -4, -13, 10, 14, 1, -4, -4, 2, 5, 4, -11,
						-7, 3, 8, -10, 11, -11, -5, 7, 13, 3, -2, 8, -13, 2, 1,
						9, -12, -11, 6 } };
		for (int[] i : test) {
			long startTime2 = System.currentTimeMillis();
			System.out.println(threeSum2(i));
			long endTime2 = System.currentTimeMillis(); 
			System.out.println("程序运行时间： " + (endTime2 - startTime2) + "ms");
		}
	}

	public static ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
		ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
		int n = num.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				for (int k = 0; k < n; k++) {
					if (i == k || j == k)
						continue;
					ArrayList<Integer> temp = new ArrayList<Integer>();
					if (num[i] <= num[j] && num[j] <= num[k]
							&& num[i] + num[k] + num[j] == 0) {
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						if (!out.contains(temp)) {
							out.add(temp);
						}
					}
				}
			}
		}
		return out;
	}

	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
		int n = num.length;
		//sort array
		Arrays.sort(num);
		
		for(int i = 0; i < n; i++) {
			int first = i;
			int second = i+1;
			int third = n-1;
			//avoid first repeat and avoid (first - 1) out of array
			if(first !=0 && num[first] == num[first - 1]) continue;
				
			while(second < third) {
				//avoid second repeat, first and second can be same
				if(second != i + 1 && num[second] == num[second - 1]) {
					++second;
					continue;
				}
				if(num[second] + num[third] > -num[first]) {
					--third;
					continue;
				}
				else if(num[second] + num[third] < -num[first]) {
					++second;
					continue;
				}
				else {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(num[first]);
					temp.add(num[second]);
					temp.add(num[third]);
					out.add(temp);
					++second;
				}
			}			
		}
		return out;
	}
}
