// Given two sparse matrices A and B, return the result of AB.

// You may assume that A's column number is equal to B's row number.

// Example:

// A = [
//   [ 1, 0, 0],
//   [-1, 0, 3]
// ]

// B = [
//   [ 7, 0, 0 ],
//   [ 0, 0, 0 ],
//   [ 0, 0, 1 ]
// ]


//      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
// AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                   | 0 0 1 |

class SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		if (A == null || B == null || A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0) {
			return new int[0][0];
		}

		int m_a = A.length;
		int n_a = A[0].length;
		int m_b = B.length;
		int n_b = B[0].length;
		int[][] C = new int[m_a][n_b];

		Map<Integer, Map<Integer, Integer>> mapA = new HashMap<>();
		Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();

		//init
		for (int i = 0; i < m_a; i++) {
			for (int j = 0; j < n_a; j++) {
				if (A[i][j] != 0) {
					if (!mapA.containsKey(i)) {
						mapA.put(i, new HashMap<>());
					}
					mapA.get(i).put(j, A[i][j]);
				}
			}
		}

		for (int i = 0; i < n_b; i++) {
			for (int j = 0; j < m_b; j++) {
				if (B[j][i] != 0) {
					if (!mapB.containsKey(i)) {
						mapB.put(i, new HashMap<>());
					}
					mapB.get(i).put(j, B[j][i]);
				}
			}
		}

		for (int i = 0; i < C.length; i++) {
			if (mapA.containsKey(i)) {
				for (int j = 0; j < C[0].length; j++) {
					if (mapB.containsKey(j)) {
						if (mapA.get(i).size() > mapB.get(j).size()) {
							for (Map.Entry<Integer, Integer> entry : mapB.get(j).entrySet()) {
								if (mapA.get(i).containsKey(entry.getKey())) {
									C[i][j] += entry.getValue() * mapA.get(i).get(entry.getKey());
								}
							}
						} else {
							for (Map.Entry<Integer, Integer> entry : mapA.get(i).entrySet()) {
								if (mapB.get(j).containsKey(entry.getKey())) {
									C[i][j] += entry.getValue() * mapB.get(j).get(entry.getKey());
								}
							}
						}
					}
				}
			}
		}

		return C;
    }
}