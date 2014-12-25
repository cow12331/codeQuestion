import java.util.ArrayList;
import java.util.HashSet;

public class PermutationsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testArr = { 1, 2, 3, 4 };

		ArrayList<ArrayList<Integer>> perLiss = new ArrayList<ArrayList<Integer>>();
		System.out.print(permute2(testArr));
	}

	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		HashSet<ArrayList<Integer>> perSet = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> perList = new ArrayList<Integer>();
		return null;
	}

	public static void permute(int[] num, int index, ArrayList<ArrayList<Integer>> perLists) {
		while(index < num.length) {
			for(int i = index; i < num.length; i++) {
				// ArrayList<Integer> perList = new ArrayList<Integer>();
				permute(num, ++i, perLists);
				ArrayList<Integer> perList = new ArrayList<Integer>();
				perList.add(num[i]);						
			}
		}
		perLists.add(perList);
	}

	public static ArrayList<ArrayList<Integer>> permute2(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		//start from an empty list
		result.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			//list of list in current iteration of the array num
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	 
			for (ArrayList<Integer> l : result) {
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size()+1; j++) {
					// + add num[i] to different locations
					l.add(j, num[i]);
	 
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
	 
					//System.out.println(temp);
	 
					// - remove num[i] add
					l.remove(j);
				}
			}
	 
			result = new ArrayList<ArrayList<Integer>>(current);
		}
	 
		return result;
	}
	
	public ArrayList<ArrayList<Integer>> permute3(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permute(num, 0, result);
		return result;
	}
	
	//
	//
	//
	void permute3(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
	 
		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}
	 
		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
		}
	}
	 
	private ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
