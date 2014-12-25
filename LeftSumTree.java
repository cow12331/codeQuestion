
public class LeftSumTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		LeftSumTree fac= new LeftSumTree();
		fac.traverse(node1);
		
	}
	
	int sum = 0;
	
	public void traverse(TreeNode root) {
		if(root == null) return;
		if(root.left != null) traverse(root.left);
		System.out.print(root.val+"->");
		root.val += sum;
		System.out.println(root.val);
		sum = root.val;
		if(root.right != null) traverse(root.right);
	}
}
