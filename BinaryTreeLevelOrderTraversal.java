import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		if(root == null) {
			return out;
		}
		queue.push(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> tl = new ArrayList<Integer>();
			while (count > 0) {
				TreeNode head = queue.pop();
				tl.add(head.val);
				if (head.left != null) {
					queue.add(head.left);
				}
				if (head.right != null) {
					queue.add(head.right);
				}
				count--;
			}
			out.add(tl);
		}
		return out;
	}
	
	
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		levelOrderHelp(root, 1, out);
		return out;
	}
	
	public void levelOrderHelp(TreeNode root, int level, List<List<Integer>> list) {
		if(root != null) {
			if(list.size() < level) {
				list.add(new ArrayList<Integer>());
			}
			list.get(level - 1).add(root.val);
			levelOrderHelp(root.left, level + 1, list);
			levelOrderHelp(root.right, level + 1, list);
		}
	}
}
