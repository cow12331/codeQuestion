
public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		TreeNode node1 = new TreeNode(1);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		node1.left = node2;
//		node1.right = node3;
//		System.out.println(isBalanced(node1));
		Integer i = new Integer(0);
		int[] arr = {1};
		p1(i);
		p2(arr);
		System.out.println(i);
		System.out.println(arr[0]);
	}

	boolean check = true;
    public boolean isBalanced(TreeNode root) {
        isBalancedRe(root);
        return check;
    }
    
    public int isBalancedRe(TreeNode root) {
        if(root == null) return 0;
        else {
            int left = isBalancedRe(root.left) + 1;
            int right = isBalancedRe(root.right) + 1;
            if(Math.abs(left - right) > 1) {
            	check = false;
            }
            return Math.max(left, right);
        }
    }
    
    public static void p1(Integer i) {
    	i = 2;
    }
    
    public static void p2(int[] i) {
    	i[0] = 2;
    }
}
