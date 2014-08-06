import java.util.*;


public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		String[] test = {"wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco", "bbbbb", "abcabcbbb"};
		for(String s : test) {
			System.out.println(lengthOfLongestSubstring(s));
		}
	}
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen =0;
        int count = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < len; i++) {
        	char cur = s.charAt(i);
        	if(map.containsKey(cur)) {
        		maxLen = Math.max(maxLen, i - map.get(cur));
        		maxLen = Math.max(maxLen, count); 
        		count = 0;
        	}
        	map.put(cur, i);
        	count++;
        }
        return maxLen;
        
    }
}
