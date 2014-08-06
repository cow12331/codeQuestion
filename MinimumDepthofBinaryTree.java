import java.util.ArrayList;

public class MinimumDepthofBinaryTree {
    public static int minDepth(TreeNode root) {
        if(root==null)
        return 0;
        int nLeftDeep = minDepth(root.left);
        int nRightDeep = minDepth(root.right);
        if(nLeftDeep == 0 && nRightDeep != 0) return 1 + nRightDeep;
        if(nRightDeep == 0 && nLeftDeep != 0) return 1 + nLeftDeep;
        if(nLeftDeep != 0 && nRightDeep != 0) return 1+Math.min(nLeftDeep,nRightDeep);
        else return 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		root.left = node2;
		//node2.left = node3;
		//root.right = node3;
		System.out.print(minDepth(root));
	}
}
