/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Given a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		while(head != null && head.next != null) {
			ListNode temp = head.next.next;
			prev.next = head.next;
			prev = head;
			head.next.next = head;
			head.next = temp;
			head = head.next;
		}

		return dummy.next;
    }
}