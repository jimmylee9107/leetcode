//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}