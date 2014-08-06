import java.util.ArrayList;

public class MergeTwoLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l3.next = l4;
		ListNode out = mergeTwoLists(l1, l3);
		while (out.next != null) {
			System.out.println(out.val);
			out = out.next;
		}
		System.out.println(out.val);

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l2 == null)
			return l1;
		if (l1 == null)
			return l2;
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		run(l1, l2, list);
		for (int i = 0; i < list.size() - 1; i++) {
			list.get(i).next = list.get(i + 1);
		}
		return list.get(0);
	}

	public static void run(ListNode l1, ListNode l2, ArrayList<ListNode> list) {
		if (l1 == null && l2 != null) {
			list.add(l2);
			run(l1, l2.next, list);
		}
		if (l2 == null && l1 != null) {
			list.add(l1);
			run(l1.next, l2, list);
		}
		if (l1 != null && l2 != null) {

			if (l1.val > l2.val) {
				list.add(l2);
				run(l1, l2.next, list);
			}
			if (l2.val >= l1.val) {
				list.add(l1);
				run(l1.next, l2, list);
			}
		}

	}

}
