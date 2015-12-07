// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		Queue<RandomListNode> queue = new LinkedList<>();
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		map.put(head, new RandomListNode(head.label));
		queue.offer(head);

		while(!queue.isEmpty()) {
			RandomListNode node = queue.poll();
			RandomListNode copy = map.get(node);
			if (node.next != null) {
				queue.offer(node.next);
				map.put(node.next, new RandomListNode(node.next.label));
				copy.next = map.get(node.next);
			}

			if (node.random != null) {
				if (!map.containsKey(node.random)) {
					map.put(node.random, new RandomListNode(node.random.label));
				}
				copy.random = map.get(node.random);
			}
		}

		return map.get(head);
    }
}