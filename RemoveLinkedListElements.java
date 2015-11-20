/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Remove all elements from a linked list of integers that have value val.

// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5
class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		while(head != null) {
			if (head.val == val) {
				prev.next = head.next;
			} else {
				prev = head;
			}
			head = head.next;
		}

		return dummy.next;
	}
}