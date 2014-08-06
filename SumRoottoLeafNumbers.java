import java.util.ArrayList;


public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(0);
		n1.left = n2;
		n1.right = n3;
		//n2.left = n4;
		System.out.print(sumNumbers(n5));
	}

    public static int sumNumbers(TreeNode root) {
    	if(root == null) return 0;
    	ArrayList<String> list = new ArrayList<String>();
    	sumNumbersImpl(root, list, root.val+"");
    	int sum = 0;
    	for(String s : list) {
    		sum += Integer.parseInt(s);
    	}
    	return sum;
    }
    
    
    public static void sumNumbersImpl(TreeNode root, ArrayList<String> list, String s) {
        if(root.left != null) {
        	sumNumbersImpl(root.left, list, s + root.left.val);
        }
        if(root.right != null) {
        	sumNumbersImpl(root.right, list, s + root.right.val);
        }
        if(root.right == null && root.left == null) {
        	list.add(s);
        }
       
    }
}
