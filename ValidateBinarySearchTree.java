
public class ValidateBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isValidBST(TreeNode root) {
        return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);  
    }  
      
    public boolean isBSTRec(TreeNode root, int left, int right) {  
        if(root == null) {  
            return true;  
        }  
        if(root.val <= left || root.val >= right) {  
            return false;  
        }  
          
        return isBSTRec(root.left, left, root.val) && isBSTRec(root.right, root.val, right);  
    }  
}
