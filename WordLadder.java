import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		 String[] stringset = { "si", "go", "se", "cm", "so", "ph", "mt",
		 "db",
		 "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci",
		 "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn",
		 "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au",
		 "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb",
		 "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li",
		 "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh",
		 "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne",
		 "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb",
		 "ni", "mr", "pa", "he", "lr", "sq", "ye" };
		//String[] stringset = { "ebb", "edb", "cdb" };
		for (String str : stringset) {
			dict.add(str);
		}
		WordLadder fac = new WordLadder();
		System.out.println(fac.ladderLength("si", "ti", dict));
	}

	public int ladderLength2(String start, String end, Set<String> dict) {
		LinkedList<String> list = new LinkedList<String>();
		Set<String> visited = new HashSet<>();
		int level = 1;
		list.add(start);
		int cur_count = 1;
		int next_count = 0;
		visited.add(start);
		while(cur_count > 0) {
			start = list.pop();
			cur_count--;
			for(int i = 0; i < start.length(); i++) {
				for(int j = 0; j < 26; j++) {
					if(start.charAt(i) != 'a' + j) {
						String t_start = start.substring(0, i) + (char)('a' + j) + start.substring(i + 1);
						if(t_start.equals(end)) return level + 1;
						if(dict.contains(t_start) && !visited.contains(t_start)) {
							list.add(t_start);
							visited.add(t_start);
							next_count++;
							
						}
					}
				}
			}
			if(cur_count == 0) {
				level++;
				cur_count = next_count;
				next_count = 0;
			}
		}
		return 0;
	}
	
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start.equals(end))
			return 1;
		Set<String> visited = new HashSet<String>();
		ladderLengthHelp(start, end, dict, 1, visited);
		return min == 2147483647 ? 0 : min;
	}

	int min = Integer.MAX_VALUE;
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public void ladderLengthHelp(String start, String end, Set<String> dict,
			int count, Set<String> visited) {
		if (map.containsKey(start) && map.get(start) < count) {
			return;
		}
		for (int i = 0; i < start.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (start.charAt(i) == 'a' + j)
					continue;
				String t_start = start.substring(0, i) + (char) ('a' + j)
						+ start.substring(i + 1);
				if (t_start.equals(end))
					min = Math.min(min, count + 1);
				else if (dict.contains(t_start) && !visited.contains(t_start)) {
					map.put(t_start, count + 1);
					dict.remove(t_start);
					visited.add(t_start);
					ladderLengthHelp(t_start, end, dict, count + 1, visited);
					dict.add(t_start);
					visited.remove(t_start);
				}
			}
		}
	}
}
