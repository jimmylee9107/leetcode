//Reverse a singly linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode prev = null;
		while(head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
    }
}