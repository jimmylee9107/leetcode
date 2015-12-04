class FourInteger {
	private void swap(int[] res, int a, int b) {
		int temp = res[a];
		res[a] = res[b];
		res[b] = temp;
	}

	public int[] fourInteger(int A, int B, int C, int D) {
		int[] res = new int[4];
		res[0] = A;
		res[1] = B;
		res[2] = C;
		res[3] = D;
		Arrays.sort(res);
		swap(res, 0, 1);
		swap(res, 2, 3);
		swap(res, 0, 3);
		return res;
	}
}