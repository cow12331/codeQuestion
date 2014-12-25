
public class CheckBalanceTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *      1
		 *   2     3
		 * 1  2   1
		 */
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(2);
		TreeNode node6 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		System.out.println(isBalanced(node1));
	}
	
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        else {
            boolean bleft = isBalanced(root.left);
            boolean bright = isBalanced(root.right);
            int lvalue = root.left == null ? 0 : root.left.val;
            int rvalue = root.right == null ? 0 : root.right.val;
            root.val = root.val + lvalue + rvalue;
            return Math.abs(lvalue - rvalue) <= 1 && bleft && bright;
        }
    }

}
