import java.util.HashSet;

public class SignleNumber {
	public static void main(String[] args) {
		int[][] test = { { 1, 1, 2, 3, 2 }, { 3 } };
		for (int[] i : test) {
			System.out.println(singleNumber2(i));
		}
	}

	public static int singleNumber(int[] A) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int a : A) {
			if (!set.contains(a)) {
				set.add(a);
			} else {
				set.remove(a);
			}
		}
		/**
		 * for(Integer i : set) { return i; }
		 *return A[0];//need one useless return
		/**
		 * while(set.iterator().hasNext()) { return set.iterator().next(); }
		 * return A[0];//need one useless return
		 */
		return set.toArray(new Integer[1])[0];
	}

	public static int singleNumber2(int[] A) {
		int x = 0;
		for (int i : A) {
			// think all number as 0 and 1, then delete by pairs, the remain is
			// answer.
			x ^= i;
		}
		return x;
	}

}
