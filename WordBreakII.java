import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] testStr = {"abc",  "catsanddog", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaac","aaaaaaa"};
		String[][] testStrArr = {{"a","b","c"},
				{ "cat", "cats", "and", "sand", "dog" },
				{ "a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"},{"a","aa","aaa", "cd"},{"aaaa","aa"}};


		for (int j = 0; j < testStr.length; j++) {
			Set<String> testSet = new HashSet<String>();
			for (int i = 0; i < testStrArr[j].length; i++) {
				testSet.add(testStrArr[j][i]);
			}
			//long startTime = System.nanoTime();
			System.out.println(wordBreak2(testStr[j], testSet));
			//long endTime = System.nanoTime();
			//System.out.println("time2: " + (endTime - startTime));
//			long startTime2 = System.nanoTime();
//			System.out.println(wordBreak(testStr[j], testSet));
//			long endTime2 = System.nanoTime();
//			System.out.println("time1: " + (endTime2 - startTime2));
		}

	}

	public static List<String> wordBreak1(String s, Set<String> dict) {
		int n = s.length();
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		String secStr = "";
		ArrayList<String> tempMapList = new ArrayList<String>();
		ArrayList<String> List0 = new ArrayList<String>();
		List0.add("");
		map.put(-1, List0);
		int count = 0;
		for (int i = 0; i < n; i++) {
			ArrayList<String> arrLisForLenI = new ArrayList<String>();
			for (int j = 0; j <= i; j++) {

				secStr = s.substring(j, i + 1);
				if (dict.contains(secStr)) {
					tempMapList = map.get(j - 1);
					for (int k = 0; k < tempMapList.size(); k++) {
						String strForLenI = "";
						strForLenI = tempMapList.get(k);
						strForLenI += secStr + " ";
						arrLisForLenI.add(strForLenI);
						count++;
					}
				}
			}
			map.put(i, arrLisForLenI);
		}
		System.out.println(count+"in 1");
		return map.get(n - 1);
		
	}

	public static List<String> wordBreak2(String s, Set<String> dict) {
		int n = s.length();
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		String secStr = "";
		List out = new ArrayList();
		
		int[] check = new int[n];
 		for(int i = 0; i < n; i++) {
 			if(dict.contains(s.substring(0, i + 1))) {
 				check[i] = 1;
 				continue;
 			}
			for(int j = 0; j < n - 1; j++) {
				if(check[j] == 1 && dict.contains(s.substring(j + 1, i + 1))) {
					check[i] = 1;
					continue;
				}
				
			}
		}
		if(check[n - 1] == 0) return out;
		
		for (int i = 0; i < n; i++) {
			ArrayList<String> arrLisForLenI = new ArrayList<String>();
			String wordForLenI = s.substring(0, i + 1);
			if(dict.contains(wordForLenI)) {
				arrLisForLenI.add(wordForLenI);
				map.put(i, arrLisForLenI);
			}
			for(int j : map.keySet()) {
				//if(i - j > maxLen) continue;
				secStr = s.substring(j + 1, i + 1);
				if(dict.contains(secStr)) {
					for(String sentence : map.get(j)) {
						sentence += " " + secStr;
						arrLisForLenI.add(sentence);
					}
				}
			}
			if(!arrLisForLenI.isEmpty()) {
				map.put(i, arrLisForLenI);
			}				
		}		
		return map.get(n - 1) == null ? out : map.get(n - 1);
	}
	
	
	
	static HashMap<String, List<String>> map3= new HashMap<String, List<String>>();
	public static List<String> wordBreak3(String s, Set<String> dict) {
	    List<String> list=new ArrayList<String>();

	    if(map3.containsKey(s)) return map3.get(s);

	    for(int i=1; i<=s.length();i++){
	        String left=s.substring(0,i);
	        String right=s.substring(i);
	        if(dict.contains(left)){
	            List<String> a=wordBreak3(right, dict);
	            for(String b:a){
	                list.add(left+" "+b);
	            }
	            if(right.length()==0) list.add(left);
	        }

	    }

	    map3.put(s, list);
	    return list;
	}
	
	static HashMap<String, List<String>> map4= new HashMap<String, List<String>>();
	public static List<String> wordBreak(String s, Set<String> dict) {
		List<String> temp = new ArrayList<String>();
		if(map4.containsKey(s)) return map4.get(s);
		for(int i = 1; i <= s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			
			if(dict.contains(left)) {
				List<String> temp2 = wordBreak(right, dict);
				for(String str : temp2) {
					temp.add(left + " " + str);
				}
				if(right.length() == 0) temp.add(left);
			}
			
			
		}
		map4.put(s, temp);
		return temp;
	}
}
