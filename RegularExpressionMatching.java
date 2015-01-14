
public class RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"abcdede", "a", "aa", "aab", "aab"};
		String[] p = {"ab.*de", ".*", ".*", "c*a*b", "a*b"};
		for(int i = 0; i < s.length; i++) {
			System.out.println(isMatch(s[i], p[i]));
		}
	}

    public static boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        boolean[][] check = new boolean[lenp + 1][lens + 1];
        check[0][0] = true;
        for(int i = 1; i < lenp + 1; i++) {
        	for(int j = 0; j < lens + 1; j++) {
        		// * match empty, same s and move p
        		if(i - 2 >= 0 && check[i - 2][j] == true && p.charAt(i - 2) != '*' && p.charAt(i - 1) == '*') check[i][j] = true;
        		// match no empty, move s and move p
        		if(j - 1 >= 0 && check[i - 1][j - 1] == true 
        				&& (p.charAt(i - 1) == s.charAt(j - 1) 
        				|| p.charAt(i - 1) == '.' )) {
        			check[i][j] = true;
        		}
        		// * match any length, move s and same p
        		if(i - 2 >= 0 && j - 1 >= 0
        				&& check[i][j - 1] == true
        				&& p.charAt(i - 1) == '*' 
        				&& (p.charAt(i - 2) == s.charAt(j - 1) 
        				|| (p.charAt(i - 2) == '.'))) {
        			check[i][j] = true;
        		}
        	}
        }
        return check[lenp][lens];
    }
}
