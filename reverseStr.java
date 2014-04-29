public class reverseStr2 {
	public static void main(String[] args) {
		String testsa[] = { "", " ", "       ", "a ", " a", "aa bd  cs" };
		// String sa[] = { "  a b   c  d" };
		for (String tests : testsa) {
			System.out.println(tests + "|" + reverseWords2(tests) + "|");
		}
	}

	public static String reverseWords2(String s) {
		String[] sa;
		String out = "";
		if (s.isEmpty() | s.equals(" ")) {
			return "";
		} else {
			sa = s.split(" ");
			for (int i = 0; i < sa.length; i++) {
				String word = sa[sa.length - 1 - i];
				if (word.equals(" ")) {
					continue;
				} else {
					if (!word.equals("")) {
						out += word + " ";
					}
				}
			}
			//exclude the last space
			int n = out.length();
			if (n > 0) {
				return out.substring(0, out.length() - 1);
			} else {
				return "";
			}
		}
	}

}
