
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(Integer.MIN_VALUE);
		int[] test= {Integer.MAX_VALUE, Integer.MIN_VALUE, 123, -123, 100};
		for(int i : test) {
			System.out.println(reverse(i));
		}
	}

	public static int reverse(int x){
		long rev = 0;
		while(x != 0) {
			rev = rev*10 + x%10;
			x = x/10;
		}
		//assert( rev < Integer.MAX_VALUE);
		if(rev > (long) Integer.MAX_VALUE || rev < (long)Integer.MIN_VALUE) return -0;
		return x >= 0 ? (int)rev : (int)-rev;
	}
	
    public static int reverse2(int x) {
        int isNegative = x < 0? -1 : 1;
        
        long n = isNegative*x;
        
        long result = 0;
        
        long tmp = 1;
        
        while( n / tmp > 0 ){
            long prev = tmp;
            tmp *= 10;
            long k = ( n % tmp ) / prev;
            result = result*10 + k;
        }
        
        return (int)result*isNegative;
    }
}
