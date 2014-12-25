
public class LastNList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		LastNList fac= new LastNList();
		System.out.println(fac.getLastZ(node1, 2).val);
		
	}
	ListNode result;
	int k;
	public ListNode getLast(ListNode head, int i) {
		getLastHelp(head, i);
		return result;
	}
	
	public int getLastHelp(ListNode head, int i) {
		if(head == null) return 0;
		int last = getLastHelp(head.next, i) + 1;
		if(last == i) {
			result = head;
		}
		return last;
	}
	
	public ListNode getLastZ(ListNode head, int i) {
		k = i;
		getLastK(head);
		
		return result;
	}
	
	public void getLastK(ListNode head)  {
	    if (head == null) {
	        return;
	    }
	    
	    getLastK(head.next);
	    k--;
	    if (k == 0) {
	        result = head;
	        return;
	    }
	}
}
