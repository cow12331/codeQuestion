import java.util.*;


public class BinaryTreePreorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();  
        preorderTraversalDfs(root, res);
        return res;
    }
    
    public static void preorderTraversalDfs(TreeNode root, List<Integer> res) {
        if(root != null) {
            res.add(root.val);
            if(root.left != null) preorderTraversalDfs(root.left, res);
            if(root.right != null) preorderTraversalDfs(root.right, res);
        }
        
    }
    
}
