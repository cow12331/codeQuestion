import java.util.*;

public class CopyListwithRandomPointer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
//		map.put(null, null);
//		map.get(null);
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		node1.next = node2;
		node1.random = node1;
		node2.next = node3;
		
		RandomListNode out = copyRandomList(node1);
		while(out != null) {
			System.out.print(out.label + " ");
			if(out.random != null) System.out.println(out.random.label);
			else System.out.println("null");
			out = out.next;
		}
		
		
	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		RandomListNode saveOriginalHead = head;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		while (head != null) {
			RandomListNode thead = new RandomListNode(head.label);
			map.put(head, thead);
			head = head.next;
		}
		
		head = saveOriginalHead;
		while (head != null) {
			map.get(head).random = map.get(head.random);
			map.get(head).next = map.get(head.next);
			head = head.next;
		}
		return map.get(saveOriginalHead);
	}

}
