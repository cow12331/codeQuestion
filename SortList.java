
public class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(1);
//		int[][] lists = {{3, 2, 4, 1}};
//		for(int[]  list : lists) {
//			for(int i = 0; i < list.length; i++) {
//				ListNode node = new ListNode(list[i]);
//			}
//		}
		SortList fac = new SortList();
		ListNode node = fac.sortList(node1);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
//    public ListNode sortList(ListNode head) {
//    	return sortListHelp(head);
//    }

    public ListNode sortList(ListNode head) {
    	ListNode saveHead = head;
        if(head == null || head.next == null){
        	return head;
        }
        ListNode fast = head;
    	while(fast.next != null && fast.next.next != null) {
    		head = head.next;
        	fast = fast.next.next;
        }
    	ListNode theadNext = head.next;
    	head.next = null;
    	ListNode first = sortList(saveHead);
    	ListNode second = sortList(theadNext);
    	return merge(first, second);
    }
    
    public ListNode merge(ListNode node1, ListNode node2) {
    	ListNode head = new ListNode(0);
    	ListNode saveHead = head;
    	while(node1 != null && node2 != null) {
    		if(node1.val > node2.val) {
    			head.next = node2;
    			node2 = node2.next;
    		} else {
    			head.next = node1;
    			node1 = node1.next;
    		}
    		head = head.next;
    	}
    	if(node1 == null) {
    		head.next = node2;
    	} else {
    		head.next = node1;
    	}
    	return saveHead.next;
    }
}
