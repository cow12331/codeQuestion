import java.util.LinkedList;

public class ConvertSortedArraytoBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
		int start = 0;
		int end = num.length - 1;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		sortedArrayToBSTRes(num, mid + 1, end, root, 1);
		sortedArrayToBSTRes(num, start, mid - 1, root, 0);
		return root;
	}

	public void sortedArrayToBSTRes(int[] num, int start, int end,
			TreeNode root, int flag) {
		if (start <= end) {
			int mid = (start + end) / 2;
			TreeNode node = new TreeNode(num[mid]);
			if (flag == 0) {
				root.left = node;
			} else
				root.right = node;
			sortedArrayToBSTRes(num, start, mid - 1, node, 0);
			sortedArrayToBSTRes(num, mid + 1, end, node, 1);
		}
	}
//better way
	public TreeNode sortedArrayTo2(int[] num) {
		if (num.length == 0)
			return null;
		return sortedArrayToRev2(num, 0, num.length - 1);
	}

	public TreeNode sortedArrayToRev2(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = sortedArrayToRev2(num, start, mid - 1);
		node.right = sortedArrayToRev2(num, mid + 1, end);
		return node;
	}
}
