import java.util.StringTokenizer;

public class ReverseStrByStrBuf {
	public static void main(String[] args) {
		String testsa[] = { "", " ", "       ", "a ", " a", "aa bd  cs" };
		// String sa[] = { "  a b   c  d" };
		for (String tests : testsa) {
			System.out.println(tests + "|" + reverseStrByStrBuf(tests) + "|");
		}
	}

	public static String reverseStrByStrBuf(String s) {
        s=s.trim();
        if(s.length()==0){
            return "";
        }
        StringTokenizer tokens = new StringTokenizer(s);
        StringBuffer buf = new StringBuffer();
        while(tokens.hasMoreTokens()){
            buf.insert(0,new StringBuffer(tokens.nextToken()));
            buf.insert(0," ");
        }
        buf.deleteCharAt(0);
        return buf.toString();
	}
}
