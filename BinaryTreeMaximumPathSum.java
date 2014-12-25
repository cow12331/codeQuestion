
public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(10);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		BinaryTreeMaximumPathSum fac = new BinaryTreeMaximumPathSum();
		System.out.println(fac.maxPathSum(node1));
	}

	int max;
	
    public int maxPathSum(TreeNode root) {
    	findMax(root);
    	return max;    	
    }
        
    public int findMax(TreeNode root) {
        if(root == null) return 0;
        //DFS
        int left = findMax(root.left);
        int right = findMax(root.right);
        //left subtree + right subtree + root val
        max = Math.max(left + right + root.val, max);
        //get the max path that end at root
        return Math.max(Math.max(left, right) + root.val, 0);        
    }
}
