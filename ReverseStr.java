public class reverseStr {
	public static void main(String[] args) {
		String testsa[] = { "", " ", "       ", "a ", " a", " aa bd  cs " };
		for (String tests : testsa) {
			System.out.println(tests + "|" + reverseWords2(tests) + "|");
		}
	}

	public static String reverseWords2(String s) {
		String[] sa;
		String out = "";
		sa = s.split(" ");
		for (int i = 0; i < sa.length; i++) {
			String word = sa[sa.length - 1 - i];
			// exclude "" in splited array
			if (!word.equals("")) {
				//add space between two words
				out += word + " ";
			}
		}
		//exclude the last space and return when string is void
		int n = out.length();
		if (n > 0) {
			return out.substring(0, out.length() - 1);
		} else {
			return "";
		}
	}

}
