import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class preorderTree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(2);
		TreeNode root2 = new TreeNode(1);
		root2.right = node3;
		root1.left = node2;
		root1.right = node3;
		System.out.print(preorderTraversal2(root1));
		System.out.print(preorderTraversal2(root2));
	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {		
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSet<TreeNode> set = new HashSet<TreeNode>();
		if(root == null) return list;
		list.add(root.val);
		preorder(root, set, list);
		return list;
	}

	public static void preorder(TreeNode root, HashSet<TreeNode> set, ArrayList<Integer> list) {
		if (root.left != null && !set.contains(root.left)) {
			set.add(root.left);
			list.add(root.left.val);
			preorder(root.left, set, list);
		}
		if ((root.right != null && root.left == null) || (root.right != null && root.left != null && list.contains(root.left.val))) {
			set.add(root.right);
			list.add(root.right.val);
			preorder(root.right, set, list);
		}
	}
	
	public static List<Integer> preorderTraversal2(TreeNode root) {		
		//Stack<Integer> path = new Stack<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) return list;
		preorder(root, list);
		return list;
	}

	public static void preorder(TreeNode root, List<Integer> list) {
		if(root != null) {
			list.add(root.val);
			preorder(root.left, list);
			preorder(root.right, list);
		}
	}
}
