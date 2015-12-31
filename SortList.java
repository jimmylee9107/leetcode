//Sort a linked list in O(n log n) time using constant space complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SortList {
	private ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				ListNode temp = l2.next;
				tail.next = l2;
				l2.next = null;
				l2 = temp;
			} else {
				ListNode temp = l1.next;
				tail.next = l1;
				l1.next = null;
				l1 = temp;
			}
			tail = tail.next;
		}

		if (l1 != null) {
			tail.next = l1;
		}

		if (l2 != null) {
			tail.next = l2;
		}
		return dummy.next; 
	}

	private ListNode partition(ListNode head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		ListNode mid = partition(head);
		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		return merge(left, right);
    }
}