import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class DecodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test = {"4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948","1212","0","10","12"};
		for(String t : test) {
			System.out.println(numDecodings(t));
		}
	}
    public static int numDecodings2(String s) {
        HashMap<Integer, String> codeMap = new HashMap<Integer, String>();
        HashMap<Integer, HashSet<String>> dpMap = new HashMap<Integer, HashSet<String>>();
        int n = s.length();
        HashSet<String> set = new HashSet<String>();
        set.add("");
        dpMap.put(0, set);
        for(int i = 1, c = 'A'; i < 27 && c <= 'Z'; i++, c++) {
        	codeMap.put(i, Character.toString((char)c));
        }
        
        for(int i = 0; i < n; i++) {
        	int start = i - 1 >= 0 ? i - 1 : 0;
        	HashSet<String> tSet = new HashSet<String>();
        	for(int j = start; j <= i; j++) {
        		int code = Integer.parseInt(s.substring(j, i + 1));
        		if(dpMap.containsKey(j) && codeMap.containsKey(code)) {
        			for(String str : dpMap.get(j)) {
        				tSet.add(str + codeMap.get(code));
        			}
        			dpMap.put(i + 1, tSet);
        		}
        	}
        }
        if(dpMap.containsKey(n)) return dpMap.get(n).size();
        else return 0;
    }
    
    public static int numDecodings(String s) {
    	int n = s.length();
    	if(n == 0) return 0;
    	int[] count = new int[n];
    	for(int i = 0; i < n; i++) {
    		char c = s.charAt(i);
    		if(i == 0) {
    			if(c != '0') count[0] = 1;
    		}
    		else if(i == 1) {
    			int code = Integer.parseInt(s.substring(i - 1, i + 1));
    			if(code == 10 || code == 20) count[1] = 1;
    			else if(code >= 11 && code <= 26) count[1] = 2;
    			else if(c != '0') count[1] = count[0];
    		}
    		else {
    			int code = Integer.parseInt(s.substring(i - 1, i + 1));
    			if(code >= 11 && code <= 26 && code != 20) count[i] = count[i - 2] + count[i - 1];
    			else {
    				if(code == 10 || code == 20) {
    					count[i] = count[i - 2];
    				}
    				else if(s.charAt(i) != '0') count[i] = count[i - 1];
    			}
    		}
    	}
    	return count[n - 1];
    }

}
