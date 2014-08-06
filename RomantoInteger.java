import java.util.HashMap;


public class RomantoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomantoInteger romantoInteger = new RomantoInteger();
		String[] test = {"X","DCXXI", "XII", "VIV"};
		for(String s : test) {
			System.out.println(romantoInteger.romanToInt(s));
		}
	}

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int n = s.length();
        int num = 0;
        //boolean[] check = new boolean[s.length()];
        
        for(int i = 0; i < s.length() - 1; i++) {
        	int cur = map.get(s.charAt(i));
        	int seccur = map.get(s.charAt(i + 1));
        	
        	if(cur >= seccur) {
        		num += cur;
        	}
        	else {
        		num -= cur;
        		//num += seccur - cur;
        		//check[i] = true;
        		//i++;
        	}
        	//check[i] = true;  
        }
        //return check[n - 1] == false ? num + map.get(s.charAt(n - 1)) : num;
        return num + map.get(s.charAt(n - 1));
    }
    
}
