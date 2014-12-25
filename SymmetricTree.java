
public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		System.out.println(left(node1));
	}

    public boolean isSymmetric(TreeNode root) {
    	return left(root).equals(right(root));
    }
    
    public static String left(TreeNode root) {
        if(root == null) return "#";
        else {
        	return root.val + left(root.left) + left(root.right);
        }
    } 
    
    public static String right(TreeNode root) {
        if(root == null) return "#";
        else {
        	return root.val + right(root.right) + right(root.left);
        }
    } 
}
