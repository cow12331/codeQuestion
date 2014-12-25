import java.util.ArrayList;
import java.util.HashSet;


public class MergeList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeList fac = new MergeList();
		String[] testStr = {"ab","bc","cddd"};
		ArrayList<String> list = new ArrayList<String>();
		for(String str : testStr) {
			list.add(str);
		}
		System.out.println(fac.mergeList(list));
	}

	public ArrayList<String> mergeList(ArrayList<String> list) {
		int[][] matrix = new int[26][26];
		ArrayList<String> out = new ArrayList<String>();
		for(String str : list) {
			for(int i = 0; i < str.length(); i++) {
				for(int j = 0; j < str.length(); j++) {
					matrix[str.charAt(i) - 97][str.charAt(j) - 97] = 1;
				}
			}
		}
		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0; i < 26; i++) {
			String subStree = dfsGraph(matrix, i, set);
			if(!subStree.equals("")) {
				out.add(subStree);
			}
		}
		return out;
	}
	
	public String dfsGraph(int[][] matrix, int row, HashSet<Character> set) {
		for(int i = 0; i < 26; i++) {
			if(matrix[row][i] != 0) {
				char c = (char)(i + 97);
				if(!set.contains(c)) {
					set.add(c);
					matrix[row][i] = 0;
					return c + dfsGraph(matrix, i, set);		
				}
			}
		}
		return "";
	}
}

