import java.util.*;


public class PopulatingNextRightPointersinEachNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		node1.left = node2;
		node1.right = node3;
		connect(node1);
	}

    public static void connect2(TreeLinkNode root) {
    	if(root == null) return;
    	ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
    	list.add(root);
    	while(!list.isEmpty()) {
    		ArrayList<TreeLinkNode> tlist = new ArrayList<TreeLinkNode>();
        	for(int i = 0; i < list.size(); i++) {
        		TreeLinkNode tnode = list.get(i);
        		if(i == list.size() - 1) {
        			tnode.next = null;
        		} else {
            		tnode.next = list.get(i + 1);        			
        		}
        		if(tnode.left != null) {
            		tlist.add(tnode.left);
            		tlist.add(tnode.right);
        		}
        	}
        	list = tlist;
    	}
    }
    
    public static void connect(TreeLinkNode root) {
    	if(root == null) return;
    	root.next = null;
    	
    	while(root.left != null) {
    		TreeLinkNode first = root;
    		while(root.next != null) {
    			root.left.next = root.right;
    			root.right.next = root.next.left;
    			root = root.next;
    		}
    		root.left.next = root.right;
    		root.right.next = null;
    		root = first.left;
    	}
    }
}
