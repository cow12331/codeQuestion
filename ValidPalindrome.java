public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"","1a2", "A man, a plan, a canal: Panama", "race a car" };
		for (String t : test) {
			System.out.println(isPalindrome3(t));
		}
	}

	public static boolean isPalindrome(String s) {
		int n = s.length();
		if (n == 0)
			return true;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			if (isLetter(s.charAt(i))) {
				sb.append(parse(s.charAt(i)));
			}
		}
		String fs = sb.toString().trim();
		System.out.println(fs);
		for (int i = 0; i < fs.length() / 2; i++) {
			if (fs.charAt(i) != fs.charAt(fs.length() - 1 - i))
				return false;
		}
		return true;
	}

	public static boolean isLetter(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
			return true;
		} else {
			return false;
		}
	}

	public static char parse(char c) {
    	if(c >= 'A' && c <= 'Z') {
    		//can not accept minus 32 directly
    		return (char)(c - ('A' - 'a'));

    	}
    	else {
    		return c;
    	}
    }
	
    public boolean isPalindrome2(String s) {

        //replace non letter char to ""
           s=s.replaceAll("\\W","");
           s=s.toLowerCase();
           int n = s.length();
           int i=0,j=n-1;
           while(i<j){
               if(s.charAt(i)!=s.charAt(j)) return false;

               i++;j--;
           }
           return true;

   }
    
    public static boolean isPalindrome3(String s) {
    	s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    	int start = 0;
    	int end = s.length() - 1;
    	if(end < 0) return true;
    	while(start < end) {
    		if(s.charAt(start) != s.charAt(end)) return false;
    		start++;
    		end--;
    	}
    	return true;
    }
}
