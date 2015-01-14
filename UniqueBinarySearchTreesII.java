import java.util.ArrayList;
import java.util.List;


public class UniqueBinarySearchTreesII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII fac = new UniqueBinarySearchTreesII();
		List<TreeNode> out = fac.generateTrees(3);
		for(TreeNode node : out) {
			fac.traverse(node);
			System.out.println();
		}
	}

    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelp(1, n);
    }
    
    public List<TreeNode> generateTreesHelp(int start, int end) {
    	if(start > end) {
    		List<TreeNode> list = new ArrayList<TreeNode>();
    		list.add(null);
        	return list;
        }
    	List<TreeNode> list = new ArrayList<TreeNode>();
        for(int i = start; i <= end; i++) {
        	List<TreeNode> left = generateTreesHelp(start, i - 1);
        	List<TreeNode> right = generateTreesHelp(i + 1, end);
        	for(TreeNode l_node : left) {
        		for(TreeNode r_node : right) {
        			TreeNode root = new TreeNode(i);
        			root.left = l_node;
        			root.right = r_node;
        			list.add(root);
        		}
        	}
        }
        return list;
    }
    
    public void traverse(TreeNode root) {
    	if(root == null) {
    		System.out.print("# ");
    		return;
    	}
    	System.out.print(root.val + " ");
    	traverse(root.left);
    	traverse(root.right);
    }
}
