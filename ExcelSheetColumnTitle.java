public class ExcelSheetColumnTitle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = {1,701, 702, 52, 26, 1, 27, 40 };
		//System.out.println((char)('A' + 0 % 26));
		for (int i : test) {
			System.out.println(convertToTitle2(i));
		}
	}

    public static String convertToTitle2(int n) {
        String ans = "";
        while(n != 0) {
            int r = n % 26;
            n = n / 26;
            if(r == 0) {
                ans = 'Z' + ans;
                n--;
            } else {
                ans = (char)('A' + r - 1) + ans;
            }
        }
        return ans;
    }
    
	public static String convertToTitle(int n) {
		char[] map = new char[26];
		map[0] = 'Z';
		for (int i = 1; i < 26; i++) {
			map[i] = (char) ('A' + i - 1);
		}
		String out = "";
		while (n > 26) {
			int div = 1;
			int sum = 0;
			while (n / div > 25) {
				sum += div;
				div *= 26;
			}
			if (n - n / div * div < sum) {
				if(n / div - 1 == 0) {
					out += 'Z';
					n = n - div;
				} else {
					out += map[n / div - 1];
					n = n - (n / div - 1) * div;
				}
			} else {
				out += map[n / div];
				n = n - n / div * div;
			}
		}
		return out + map[n % 26];

	}
}
