import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] test = {{"tea","and","ate","eat","dan"},{"a"}};
		for(String[] s : test) {
			System.out.println(anagrams(s));
		}
	}

    public static List<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        List<String> ans = new ArrayList<String>();
        
        for(String word : strs) {
        	int[] count = new int[26];
            for(int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }
            StringBuffer temp = new StringBuffer();
            for(int c : count) {
                temp.append(c + "");
            }
            String ts = temp.toString();
            if(map.containsKey(ts)) {
                map.get(ts).add(word);
            } else {
            	ArrayList<String> tl = new ArrayList<String>();
            	tl.add(word);
                map.put(ts.toString(), tl);
            }
        } 
        
        for(ArrayList<String> list : map.values()) {
        	if(list.size() > 1) {
        		ans.addAll(list);
        	}
        }
        
        return ans;
    }
}
