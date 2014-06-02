import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WorldBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("apple");
		dict.add("ap");
		dict.add("ab");
		// dict.add("banana");
		dict.add("abc");
		long startTime=System.nanoTime();   //获取开始时间
		System.out.println(wordBreak2("apple", dict));
		System.out.println(wordBreak2("apapple", dict));
		System.out.println(wordBreak2("appleap", dict));
		long endTime=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
		
		long startTime2=System.nanoTime();   //获取开始时间
		System.out.println(wordBreak("apple", dict));
		System.out.println(wordBreak("apapple", dict));
		System.out.println(wordBreak("appleap", dict));
		long endTime2=System.nanoTime(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime2-startTime2)+"ns");
	}

	//pass test
	public static boolean wordBreak(String s, Set<String> dict) {
		int n = s.length();
		//save the string has been checked
		boolean[] saveArr = new boolean[n]; 
		
		for(int i = 0; i < n; i++) {
			//check the whole part
			if(dict.contains(s.substring(0, i + 1))) {
				saveArr[i] = true;
			}
			//check two parts
			for(int j = 0; j < i; j++) {
				if(saveArr[j] == true && dict.contains(s.substring(j + 1, i + 1))) {
					saveArr[i] = true;
				}
			}
		}
		return saveArr[n - 1];
	}
	
	
	//out of time limit
	public static boolean wordBreak2(String s, Set<String> dict) {
		HashSet checker = new HashSet();
		wordBreakRun(s, dict, checker);
		if(checker.contains(true)) return true;
		else return false;
	}
		
	public static void wordBreakRun(String s, Set<String> dict, HashSet checker) {
		boolean check = false;
		for (String word : dict) {
			int n = word.length();
			if (s.length() > n - 1 && s.substring(0, n).equals(word)) {
				check = true;				
				wordBreakRun(s.substring(n), dict, checker);
			}			
		}		
		if(s.length() == 0) checker.add(true);
		else checker.add(false);
	}

}
