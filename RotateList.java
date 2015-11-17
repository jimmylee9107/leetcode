class RotateList {
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
	private int getLen(ListNode head) {
		int res = 0;
		while(head != null) {
			res++;
			head = head.next;
		}
		return res;
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}

		int len = getLen(head);
		k %= len;
		if (k == 0) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode kNode = head;
		for (int i = 1; i <= k; i++) {
			kNode = kNode.next;
		}

		while(kNode != null && kNode.next != null) {
			head = head.next;
			kNode = kNode.next;
		}
		kNode.next = dummy.next;
		dummy.next = head.next;
		head.next = null;
		
		return dummy.next;
    }
}