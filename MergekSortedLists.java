import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class MergekSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < lists.size(); i++) {
        	ListNode node = lists.get(i);
        	while(node != null) {
        		int val = node.val;
        		if(map.containsKey(val)) {
        			map.put(val, map.get(val) + 1);
        		} else {
        			map.put(val, 1);
        		}
        		node = node.next;
        	}
        }
        ArrayList<Integer> array = new ArrayList<Integer>(map.keySet());
        Collections.sort(array);
        for(Integer val : array) {
        	int num = map.get(val);
        	while(num > 0) {
        		ListNode node = new ListNode(val);
        		head.next = node;
        		head = head.next;
        		num--;
        	}
        }
        return dummy.next;
    }

}
