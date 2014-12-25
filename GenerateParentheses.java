import java.util.*;


public class GenerateParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses fac = new GenerateParentheses();
		System.out.println(fac.generateParenthesis(2));
	}

	List<String> outList = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
    	rev(n, 0, "");
    	return outList;
    }
    
    public void rev(int left, int right, String out) {
    	if(left == 0 && right == 0) outList.add(out);
    	if(left > 0) rev(left - 1, right + 1, out + "(");
    	if(right > 0) rev(left, right - 1, out + ")");
    }
}
