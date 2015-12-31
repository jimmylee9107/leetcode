//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		PriorityQueue<ListNode> minheap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
			public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		});

		for (ListNode head : lists) {
			if (head != null) {
				minheap.offer(head);
			}
		}

		while(!minheap.isEmpty()) {
			ListNode head = minheap.poll();
			if (head.next != null) {
				minheap.offer(head.next);
			}
			tail.next = head;
			head.next = null;
			tail = tail.next;

		}
		return dummy.next;
    }
}