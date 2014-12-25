import java.util.ArrayList;
import java.util.Arrays;

public class VisibleTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(20);
		TreeNode node5 = new TreeNode(21);
		TreeNode node6 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		VisibleTree fac = new VisibleTree();
		System.out.println(fac.isVisibleTree(node1));
	}

	ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<Integer> isVisibleTree(TreeNode root) {
		isVisibleTreeHelper(root, Integer.MIN_VALUE);
		return list;
	}

	public void isVisibleTreeHelper(TreeNode root, int max) {
		if (root != null) {
			if (root.val >= max) {
				list.add(root.val);
				isVisibleTreeHelper(root.left, root.val);
				isVisibleTreeHelper(root.right, root.val);
			} else {
				isVisibleTreeHelper(root.left, max);
				isVisibleTreeHelper(root.right, max);
				Arrays.sort()
			}

		}
	}
}
