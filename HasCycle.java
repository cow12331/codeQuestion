public class HasCycle {	
    public boolean hasCycle(ListNode head) {
    	//the list is null
    	if(head == null) return false;
    	//next is null
    	else if(head.next == null) return false;
    	//if next exist, change its value to Max_value,
    	//if meet Max_value again, the cycle exist.
    	else if(head.val == Integer.MAX_VALUE) return true;
    	else {
    		head.val = Integer.MAX_VALUE;
    		return hasCycle(head.next);
    	}   	
    }
    
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
