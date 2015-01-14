public class DistinctSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDistinct2("aaa", "a"));
	}

	/* suppose length of s is m, length of t is n
	 the number of sequence is from two case, one is from the number of
	 sequence of string t in string s of length m - 1
	 the other is s and t has same final char, so the number of sequence of t of n - 1 in s of m - 1
	*/
	public int numDistinct(String S, String T) {
		int slen = S.length();
		int tlen = T.length();
		int[][] num = new int[slen + 1][tlen + 1];
		for (int i = 0; i < slen + 1; i++) {
			num[i][0] = 1;
		}
		for (int i = 1; i < slen + 1; i++) {
			for (int j = 1; j < tlen + 1; j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					num[i][j] = num[i - 1][j - 1];
				}
				num[i][j] += num[i - 1][j];
			}
		}
		return num[slen][tlen];
	}

	public static int numDistinct2(String S, String T) {
		int slen = S.length();
		int tlen = T.length();
		int[] num = new int[tlen + 1];
		num[0] = 1;
		int temp = 1;
		for (int i = 1; i < slen + 1; i++) {
			for (int j = 1; j < tlen + 1; j++) {
				int temp2 = num[j];
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					num[j] += temp;
				}
				temp = temp2;
			}
			temp = 1;
		}
		return num[tlen];
	}
}
