
public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("".isEmpty());
		
		String[] s1 = {"a", "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc","a", "aabcc", "aabcc"};
		String[] s2 = {"b","abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb","b", "dbbca", "dbbca"};
		String[] s3 = {"a","abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb","ba", "aadbbcbcac", "aadbbbaccc"};
		for(int i = 0; i < s1.length; i++) {
			InterleavingString fun = new InterleavingString();
			System.out.println(fun.isInterleave2(s1[i], s2[i], s3[i]));
		}
	}
	

	boolean checker = false;
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(checker == true) return true;
    	if(s1.isEmpty() && s2.equals(s3)) {
    		checker = true;
    		return true;
    	}
    	if(s2.isEmpty() && s1.equals(s3)) {
    		checker = true;    		
    		return true;
    	}
    	if(s1.isEmpty() && !s2.equals(s3)) return false;
    	if(s2.isEmpty() && !s1.equals(s3)) return false;
    	
    	boolean b1 = false, b2 = false;
    	if(!s3.isEmpty() && !s1.isEmpty() && s3.charAt(0) == s1.charAt(0)) {
    		b1 = isInterleave(s1.substring(1), s2, s3.substring(1));
    	}    	
    	if(!s3.isEmpty() && !s2.isEmpty() && s3.charAt(0) == s2.charAt(0)) {
    		b2 = isInterleave(s1, s2.substring(1), s3.substring(1));
    	}
    	return b1 || b2;
    }
    
    public boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 + len2 != s3.length()) return false;
        boolean[][] chec = new boolean[len1 + 1][len2 + 1];
        chec[0][0] = true;
        
        for(int i = 0; i <= len1; i++) {
            for(int j = 0; j <= len2; j++) {
            	if(i > 0 && chec[i - 1][j] == true && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) chec[i][j] = true;
            	if(j > 0 && chec[i][j - 1] == true && s2.charAt(j - 1) == s3.charAt(j - 1 + i)) chec[i][j] = true;
            }
        }
        return chec[len1][len2];
    }

}
