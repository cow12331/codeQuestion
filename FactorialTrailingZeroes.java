
public class FactorialTrailingZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes2(1808548329 ));
	}

    public static int trailingZeroes(int n) {
        int count = 0;
        int div = 5;
        while(n / div > 0) {
            count += n / div;
            div *= 5;
            if(div >= Integer.MAX_VALUE / 5) {
            	count += 1;
            	break;
            }
        }
        return count;
    }
    
    public static int trailingZeroes2(int n) {
        int count = 0;
        while(n > 1) {
        	n /= 5;
            count += n;
        }
        return count;
    }
}
