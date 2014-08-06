
public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		////-2147483648
		int[] test = {-2147447412, 12321 };
		for(int i : test) {
			System.out.println(isPalindrome(i));
		}
	}

    public static boolean isPalindrome(int x) {
    	if(x < 0) return false;
        if(reverse(x) == x) return true;
        else return false;
    }
    
    public static int reverse(int x) {
        long out = 0;
        while(x != 0) {
            out = out * 10 + x % 10;
            x /= 10;
        }
        if(out > Integer.MAX_VALUE || out < Integer.MIN_VALUE) return 12;
        return x >= 0 ? (int) out : (int)-out; 
    }
}
