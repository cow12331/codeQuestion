import java.util.*;


public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(grayCode2(2));
		//System.out.println(Integer.valueOf("0",2));
		//System.out.println(1<<3);
	}
	
	//try to generate all possible code by 0 1-> 0+0 0+1 1+1 1+0 ->...
	//add 0 at begin forward the array such as 0 1 -> 00 01
	//add 1 at begin reverse the array such as 0 1 -> 11 10
    public List<Integer> grayCode(int n) {
    	List<Integer> outlist = new ArrayList<Integer>();
    	if(n == 0) {
    		outlist.add(0);
    		return outlist;
    	}
    	
    	List<String> list = new ArrayList<String>();
    	list.add("0");
    	list.add("1");
    	
    	for(int i = 0; i < n - 1; i++) {
    		List<String> tlist = new ArrayList<String>();
    		int listLen =  list.size();
    		for(int j = 0; j < listLen; j++) {
    			tlist.add("0" + list.get(j));
    		}
    		for(int j = 0; j < listLen; j++) {
    			tlist.add("1" + list.get(list.size() - 1 - j));
    		}
    		list = tlist;
    	}
    	
    	for(String s : list) {
    		outlist.add(Integer.valueOf(s,2));
    	}
    	return outlist;
    }
    
    public static List<Integer> grayCode2(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        
        for(int i = 0; i < n; i++) {
            int var = 1 << i;
            for(int j = list.size() - 1; j >= 0; j--) {
                list.add(list.get(j) + var);
            }
        }
        
        return list;
    }
}
