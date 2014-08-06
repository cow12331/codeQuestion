import java.util.HashMap;

public class MaxDepthTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		root.left = node2;
		root.right = node3;
		System.out.print(maxDepth(root));
	}



    public static int maxDepth(TreeNode root) {
        if(root==null)
        return 0;
        int nLeftDeep = maxDepth(root.left);
        int nRightDeep = maxDepth(root.right);
        return 1+Math.max(nLeftDeep,nRightDeep);
    }
}
