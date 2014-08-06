import java.util.*;


public class Combinations {

	public static void main(String[] args) {
		int[] n = {4,4};
		int[] k = {2,0};
		for(int i = 0; i < n.length; i++) {
			System.out.println(combine2(n[i],k[i]));
		}
	}
	
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l = new ArrayList<Integer>();
		list.add(l);
    	int time = 0;
    	int start = 1;
    	//解决new数组的问题
    	//解决初值的问题
    	while(time < k) {
    		ArrayList<ArrayList<Integer>> tlist = new ArrayList<ArrayList<Integer>>();
    		for(ArrayList<Integer> itemList : list) {
    			start = itemList.size() > 0 ? itemList.get(itemList.size() - 1) : 0;
    			//start = itemList.get(itemList.size() - 1);
    			for(int i = start + 1; i <= n - k + time + 1; i++) {
    				ArrayList<Integer> titem = new ArrayList<Integer>();
    				titem = (ArrayList<Integer>)itemList.clone();
    				titem.add(i);
    				tlist.add(titem);
    			}
    		}
    		list = tlist;   
    		time++;
    	}
    	return list;
    }
    
    //static List<List<Integer>> flist = new ArrayList<List<Integer>>();
    public static List<List<Integer>> combine2(int n, int k){
    	List<List<Integer>> flist = new ArrayList<List<Integer>>();
    	ArrayList<Integer> tlist = new ArrayList<Integer>();
    	combineImpl(1, 1, n, k, tlist, flist);
    	return flist;
    }
    
    public static void combineImpl(int len, int start, int n, int k, ArrayList<Integer> tlist, List<List<Integer>> flist) {
    	if(len > k) {
    		flist.add(tlist);
    		return;
    	}
    	for(int i = start; i <= n; i++) {
    		ArrayList<Integer> ttlist = (ArrayList<Integer>)tlist.clone();
    		ttlist.add(i);
    		combineImpl(len + 1, i + 1, n, k, ttlist, flist);
    	}
    }
}
