import java.util.*;


public class PalindromePartitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning fac = new PalindromePartitioning();
		System.out.println(fac.partition("aab"));
	}

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] isPa = new boolean[n][n];
        List<List<String>>[] out = new List[n + 1];
        out[0] = new ArrayList<List<String>>(); //need a empty list
        out[0].add(new ArrayList<String>());
        
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            out[i + 1] = new ArrayList<List<String>>(); //ini array
            for(int j = 0; j <= i; j++) {
                if(i == j) isPa[j][i] = true;
                else {
                    if(c == s.charAt(j)) {
                        if(j == i - 1) isPa[j][i] = true;
                        else isPa[j][i] = isPa[j + 1][i - 1];
                    }
                }
                if(isPa[j][i] == true) {
                    for(List<String> list : out[j]) {
                    	List<String> tlist = new ArrayList<String>(list);
                    	tlist.add(s.substring(j, i + 1));
                    	out[i + 1].add(tlist);
                    }
                }
            }
        }
        return out[n];
    }
    
    public List<List<String>> partition2(String s) {
    int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for(int i=0; i<s.length(); i++){
            result[i+1] = new ArrayList<List<String>>();
            char c = s.charAt(i);
            for(int j=0; j<=i; j++){
                if(j == i)
                    pair[j][i] = true;
                else{
                    if(s.charAt(j) != c)
                        continue;
                    if(j == i-1)
                        pair[j][i] = true;
                    else
                        pair[j][i] = pair[j+1][i-1];
                }
                if(pair[j][i]){
                    String str = s.substring(j, i+1);
                    for(List<String> r : result[j]){
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i+1].add(ri);
                    }
                }
            }
        }

        return result[len];        
    }
}
