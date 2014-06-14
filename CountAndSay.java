import java.util.ArrayList;

public class CountAndSay {
    public static String countAndSay(int n) {
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("1");
    	//get nth in list
    	for(int i = 1; i < n ; i++) {
    		//traverse the nth item
        	int count = 0;
        	String item = "";
    		String str = list.get(i - 1);
    		int len = str.length();
    		for(int j = 0; j < len; j++) {
    			//end of str
    			if(j == len - 1) {
    				if(len == 1) {
    					list.add("11");
    				}
    				//compare the last with the sencond last
    				else if(str.charAt(j) == str.charAt(j - 1)) {
    					count++;
    					item += count+"" + str.charAt(j);
    					list.add(item);
    				}
    				else {
    				item += "1" + str.charAt(j);
    				list.add(item);
    				}
    			}  
    			else if(str.charAt(j) == str.charAt(j + 1)) {
    				count++;
    			}
    			else {
    				count++;
    				item += count+"" + str.charAt(j);
    				count = 0;
    			}
    		}
    	}
        return list.get(n - 1);
    }
    
    public static String countAndSay2(int n) {
        
        String str = "1";
        String out = "";
        int i = 1;
        		
        if(n == 1) return str;
        else {
            while(i < n) {
                int count = 1;
                int j = 1;
                while(j < str.length()) {
                    if(str.charAt(j) == str.charAt(j - 1)) {
                        count++;
                        j++;
                    }
                    else {
                    	out += count + "" + str.charAt(j - 1);
                        count = 1;
                        j++;
                    }
                }
                out += count + "" + str.charAt(j - 1);
                str = out;
                out = "";
                i++;
            }
        }
        return str;
    }
    public static void main(String[] args) {
    	for(int i = 1; i < 10; i++) {
    		System.out.println(countAndSay(i));
    		System.out.println(countAndSay2(i));
    		System.out.println("=============");
    	}
    	
    }
}
