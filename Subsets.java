import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(1 << 3);
//		ArrayList<ArrayList<Integer>> l1 = new ArrayList<ArrayList<Integer>>();
//		l1.add(new ArrayList());
//		ArrayList<ArrayList<Integer>> l2 = new ArrayList<ArrayList<Integer>>(l1);
//		l2.get(0).add(1);
//		System.out.println(l1.get(0));
		
		System.out.println(subsets4(new int[] {1,2,3}));
	}

	public static List<List<Integer>> subsets4(int[] S) {
		Arrays.sort(S);
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		out.add(new ArrayList<Integer>());
		List<List<Integer>> prelist = new ArrayList<List<Integer>>();
		prelist.add(new ArrayList<Integer>());

		for (int i = 0; i < S.length; i++) {
			List<List<Integer>> t_prelist = new ArrayList<List<Integer>>();
			for (List<Integer> lt : prelist) {
				int start = lt.size() == 0 ? -999 : lt.get((lt.size() - 1));
				for(int j = 0; j < S.length; j++) {
					if(S[j] > start) {
						List<Integer> t_inner_list = new ArrayList<Integer>(lt);
						t_inner_list.add(S[j]);
						t_prelist.add(t_inner_list);
					}
				}
			}
			prelist = t_prelist;
			out.addAll(t_prelist);
		}
		return out;
	}

	public static List<List<Integer>> subsets3(int[] S) {
		Arrays.sort(S);
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		out.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length; i++) {
			List<List<Integer>> tout = new ArrayList<List<Integer>>();
			// new ArrayList<ArrayList<>>() will fail
			for (List<Integer> list : out) {
				tout.add(new ArrayList<Integer>(list));
			}
			for (List<Integer> list : tout) {
				list.add(S[i]);
			}
			out.addAll(tout);
		}
		return out;
	}

	public List<List<Integer>> subsets2(int[] S) {
		Arrays.sort(S);
		int totalNumber = 1 << S.length;
		List<List<Integer>> collection = new ArrayList<List<Integer>>(
				totalNumber);
		for (int i = 0; i < totalNumber; i++) {
			List<Integer> set = new LinkedList<Integer>();
			for (int j = 0; j < S.length; j++) {
				if ((i & (1 << j)) != 0) {
					set.add(S[j]);
				}
			}
			collection.add(set);
		}
		return collection;
	}

	public static List<List<Integer>> subsets(int[] S) {
		List<String> binary = new ArrayList<String>();
		Arrays.sort(S);
		int len = (1 << S.length) - 1;
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for (int i = 0; i <= len; i++) {
			binary.add(toBinary(i, S.length));
		}
		for (String bi : binary) {
			List<Integer> ls = new ArrayList<Integer>();
			for (int i = 0; i < S.length; i++) {
				if (bi.charAt(i) == '1')
					ls.add(S[i]);
			}
			ans.add(ls);
		}
		return ans;
	}

	public static String toBinary(int num, int len) {
		String out = "";
		while (num > 0) {
			out = num % 2 + out;
			num /= 2;
		}
		while (out.length() < len) {
			out = "0" + out;
		}
		return out;
	}
}
