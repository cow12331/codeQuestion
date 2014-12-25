import java.util.ArrayList;
import java.util.List;


public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(root, list);
        return list;
    }
    
    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) return;
        if(root.left != null) {
            inorderTraversal(root.left, list);
        }
        list.add(root.val);
        if(root.right != null) {
            inorderTraversal(root.right, list);
        }
    }
}
