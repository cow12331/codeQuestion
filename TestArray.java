public class TestArray {
	public static void main(String[] args) {
		//revise an array directly without return
		String[] test = {"test"};
		voidReturn(test);
		System.out.println(test[0]);
		//revise an array directly with return
		String[] test2 = {"test2"};
		String[] outtest2 = arrayReturn(test2);
		System.out.println(outtest2[0]);
		//revise an array by another way
		String[] test3 = {"test3"};
		voidReturn2(test3);
		System.out.println(test3[0]);
	}

	public static void voidReturn(String[] a) {
		String[] b = {"b"};
		a = b;
		System.out.println("a in voidReturn is "+ a[0]);
	}
	
	public static String[] arrayReturn(String[] a) {
		String[] b = {"b"};
		a = b;
		System.out.println("a in arrayReturn is "+ a[0]);
		return a;
	}
	
	public static void voidReturn2(String[] a) {
		a[0] = "b";
		System.out.println("a in voidReturn2 is "+ a[0]);
	}
	

}
