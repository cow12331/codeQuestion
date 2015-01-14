
public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"};
		for(String t : test) {
			System.out.println(longestPalindrome(t));
		}
	}

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isP = new boolean[n][n];
        int max = 0;
        String out = "";
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || isP[j + 1][i - 1] == true)) {
                    isP[j][i] = true;
                }
                if(isP[j][i] == true && i - j + 1 > max) {
                	max = i - j + 1;
                    out = s.substring(j, i + 1);
                }
            }
        }
        return out;
    }
    
    public boolean isPalindrome(String s, int startIndex, int endIndex) {
        for(int i = startIndex, j = endIndex; i <= j; i++, j--) 
                if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }

    // go though string
    // check substring that end at current point and length is cur longest palidrome len and len + 1
    
    public String longestPalindrome2(String s) {
        int n = s.length();
        int longestLen = 0;
        int longestIndex = 0;

        for(int currentIndex = 0; currentIndex < n; currentIndex++) {
            if(isPalindrome(s,currentIndex - longestLen, currentIndex)){
                longestLen += 1;
                longestIndex = currentIndex;
            } else if(currentIndex - longestLen - 1 >= 0 && 
                      isPalindrome(s, currentIndex - longestLen - 1, currentIndex)) {
                longestLen += 2;
                longestIndex = currentIndex;
            }   
        }
        longestIndex++;
        return s.substring(longestIndex - longestLen, longestIndex);
    }
}
