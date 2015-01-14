
public class ReverseList {

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
		ListNode node = revRecursive(node1);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
    public static ListNode revRecursive(ListNode head) {
        if (head == null)
            return null;
 
        if (head.next == null)
            return head;
 
        ListNode newHead = revRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
