class RoundRobinScheduling {
	class Process {
		int arriveTime;
		int executionTime;
		Process(int arriveTime, int executionTime) {
			this.arriveTime = arriveTime;
			this.executionTime = executionTime;
		}
	}

	public float averageWaitTime(int[] arrive, int[] execute, int q) {
		if (arrive == null || arrive.length <= 1 || execute == null || execute.length <= 1) {
			return 0;
		}

		int index = 0;
		int waitTime = 0;
		int curTime = 0;
		Queue<Process> queue = new LinkedList<>();
		int len = arrive.length;
		while(!queue.isEmpty() || index < len) {
			if (!queue.isEmpty()) {
				Process temp = queue.poll();
				waitTime += curTime - temp.arriveTime;
				curTime += Math.min(q, temp.executionTime);
				if (temp.executionTime > q) {
					queue.offer(new Process(curTime, temp.executionTime - q));
				}

				for (; index < len && arrive[index] <= curTime; index++) {
					queue.offer(new Process(arrive[index], execute[index]));
				}
			} else {
				queue.offer(new Process(arrive[index], execute[index]));
				curTime = arrive[index++];
			}
		}

		return (float) waitTime / len
	}
}