import java.util.*;

public class LRUCache {
	public static void main(String args[]) {
		LRUCache fac = new LRUCache(2);
//		System.out.println(fac.get(1));
		fac.set(2,1);
		fac.set(2,2);
		System.out.println(fac.get(2));
		fac.set(2,1);
		fac.set(1,1);
		fac.set(2,5);
		System.out.println(fac.get(2));
		System.out.println(fac.get(1));
//		fac.set(1, 1);
//		fac.set(2, 2);
//		fac.set(3, 3);
//		fac.set(3, 3);
//		System.out.println(fac.get(1));
//		fac.set(4, 4);
//		System.out.println(fac.get(2));
	}
	/*
	 * 
	 */
    int max;
    Node root;
    Node tail;
    HashMap<Integer, Node> nodeMap = new HashMap<Integer, Node>();
    int curCap = 0;
    
    public LRUCache(int capacity) {
        this.max = capacity;
        this.root = null;
        this.tail = null;
    }
    
    public int get(int key) {
    	if(!nodeMap.containsKey(key)) return -1;
    	else {
    		moveFirst(nodeMap.get(key));
    		return nodeMap.get(key).value;
    	}
    }
    
    public void set(int key, int value) {
        Node tnode = new Node();
        tnode.key = key;
        tnode.value = value;
        if(curCap == max && !nodeMap.containsKey(key)) {
        	nodeMap.remove(tail.key);
        	if(tail.pre == null) {
        		tail = null;
        		root = null;
        	} 
        	else {
	        	tail = tail.pre;
	        	tail.next = null;
	            
        	}
        	curCap--;
        }
        
        if(root == null) {
        	root = tnode;
        	tail = tnode;
        	curCap++;
        	nodeMap.put(key, tnode);
        }
        else {
        	if(nodeMap.containsKey(key)) {
        		Node tempNode = nodeMap.get(key);
        		tempNode.value = value;
        		moveFirst(tempNode);
        		nodeMap.put(key, tempNode); //different with tnode
        	}
        	else {
            	tnode.next = root;
    	        root.pre = tnode;	        
    	        root = tnode;
    	        curCap++;
    	        nodeMap.put(key, tnode);
        	}
        }
        

    }
    
    public void moveFirst(Node node) {
    	if(node.next == null && node.pre == null) {
    		return;
    	} 
    	else if(node.next == null && node.pre != null) {
    		tail = node.pre;
    		node.pre.next = null;
    		node.next = root;
    		node.pre = null;
    		root.pre = node;
    		root = node;
    	} 
    	else if(node.pre == null && node.next != null) {
    		return;
    	}
    	else {
    		node.next.pre = node.pre;
    		node.pre.next = node.next;
    		node.pre = null;
    		root.pre = node;
    		node.next = root;
    		root = node;
    	}
    }
    
    class Node {
        Node pre;
        Node next;
        Node cur;
        int key;
        int value;
    }
}