
public class ValidNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"46.e.3","46.e3","1 a","+1e-1","01", ".01" ,"1e2"," 0.1","2e10" ,"abc"};
		
		ValidNumber fac = new ValidNumber();
		for(String t : test) {
			System.out.println(fac.isNumber(t));
		}
	}

	// A.B Ae(+ -)B
    public boolean isNumber(String s) {
    	s = s.trim();
    	if(s.length() == 0) return false;
    	if(s.charAt(0) == '+' || s.charAt(0) == '-') {
    		s = s.substring(1);
    	}
    	boolean exp = false;
    	boolean dot = false;
    	boolean num = false;
    	
    	for(int i = 0; i < s.length(); i++) {
    		char cur = s.charAt(i);
    		if(cur >= '0' && cur <= '9') {
    			num = true;
    		}
    		else if(cur == '.') {
    			if(dot == true || exp == true) return false;
    			dot = true;
    		}
    		else if(cur == 'e') {
    			if(num == false || exp == true) return false;
    			exp = true;
    			num = false;
    		}
    		else if(cur == '+' || cur == '-') {
    			if(i < 1 || s.charAt(i - 1) != 'e') return false;
    		}
    		else {
    			return false;
    		}
    	}
    	return num;
    }
   
   public static boolean isNumber2(String s) {
	    try {
	        s = s.trim();
	        int n = s.length();
	        if ( n == 0 || (s.charAt(n-1) != '.' && (s.charAt(n-1) - '0' < 0 || s.charAt(n-1) - '0' > 9 )) ) {
	            return false;
	        }
	        double i = Double.parseDouble(s);
	        return true;
	    }
	    catch (NumberFormatException e) {
	        return false;
	    }
	}
}
