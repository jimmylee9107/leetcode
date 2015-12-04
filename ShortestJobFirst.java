class ShortestJobFirst {
	class Process {
		int arriveTime;
		int durationTime;
		Process(int arriveTime, int durationTime) {
			this.arriveTime = arriveTime;
			this.durationTime = durationTime;
		}
	}

	public float getwaittime(int[] arrive, int[] duration) {
		if (arrive == null || arrive.length <= 1 || duration == null || duration.length <= 1) {
			return 0;
		}

		int curTime = 0;
		int waitTime = 0;
		int index = 0;
		int len = arrive.length;
		PriorityQueue<Process> pq = new PriorityQueue<Process>(len, new Comparator<Process>(){
			public int compare(Process a, Process b) {
				if (a.durationTime == b.durationTime) {
					return a.arriveTime - b.arriveTime;
				}
				return a.durationTime - b.durationTime;
			}
		});

		while(!pq.isEmpty() || index < len) {
			if (!pq.isEmpty()) {
				Process temp = pq.poll();
				waitTime += curTime - temp.arriveTime;
				curTime += temp.durationTime;
				for (; index < len && arrive[index] <= curTime; index++) {
					pq.offer(new Process(arrive[index], duration[index]));
				}
			} else {
				pq.offer(new Process(arrive[index], duration[index]));
				curTime += arrive[index++];
			}
		}

		return (float) waitTime / len;
	}
}