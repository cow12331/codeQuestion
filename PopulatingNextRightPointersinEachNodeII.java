import java.util.HashSet;


public class PopulatingNextRightPointersinEachNodeII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void connect(TreeLinkNode root) {
        TreeLinkNode lastLevel = new TreeLinkNode(0);
        lastLevel.next = root;
        while(lastLevel.next != null) {
            TreeLinkNode lastConnect = new TreeLinkNode(0);
            TreeLinkNode head = lastConnect;
            while(lastLevel != null) {
                if(lastLevel.left != null) {
                    lastConnect.next = lastLevel.left;
                    lastConnect = lastConnect.next;
                }
                if(lastLevel.right != null) {
                    lastConnect.next = lastLevel.right;
                    lastConnect = lastConnect.next;
                }
                lastLevel = lastLevel.next;
            }
            lastLevel = head;
        }
	}
	
    HashSet<TreeLinkNode> set = new HashSet<TreeLinkNode>();
    public void connect2(TreeLinkNode root) {
        if(set.contains(root)) return;
        set.add(root);
        if(root == null) return;
        if(root.left != null && root.right != null) root.left.next = root.right;
        if(root.left != null && root.right == null) {
            root.left.next = findNext(root.next);
            //connect(root.next);
        }
        if(root.right != null) {
            root.right.next = findNext(root.next);
            //connect(root.next);
        }
        connect(root.next);
        connect(root.left);
        connect(root.right);
    }
    
    public TreeLinkNode findNext(TreeLinkNode root) {
        if(root == null) return null;
        if(root.left != null) return root.left;
        if(root.right != null) return root.right;
        return findNext(root.next);
    }
}
