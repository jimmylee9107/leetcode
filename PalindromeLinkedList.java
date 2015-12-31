//Given a singly linked list, determine if it is a palindrome.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class PalindromeLinkedList {
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
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

	private ListNode partition(ListNode head) {
		if (head == null || head.next == null) {
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

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		ListNode mid = partition(head);
		ListNode right = reverse(mid.next);
		mid.next = null;
		while(right != null && head != null) {
			if (right.val != head.val) {
				return false;
			}
			right = right.next;
			head = head.next;
		}
		return true;
    }
}