// Implement an iterator to flatten a 2d vector.

// For example,
// Given 2d vector =

// [
//   [1,2],
//   [3],
//   [4,5,6]
// ]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

class Flatten2DVector {
	private List<List<Integer>> matrix = null;
	private int index1 = 0;
	private int index2 = 0;
    public Vector2D(List<List<Integer>> vec2d) {
    	matrix = vec2d;
    	for (int i = 0; i < vec2d.size(); i++) {
    		List<Integer> temp = vec2d.get(i);
    		if (temp != null && temp.size() > 0) {
    			index1 = i;
    			break;
    		}
    	}
    }

    public int next() {
    	return matrix.get(index1).get(index2++);
    }

    public boolean hasNext() {
    	if (index1 == matrix.size()) {
    		return false;
    	}
    	if (index2 == matrix.get(index1).size()) {
    		while(index1 < matrix.size() - 1) {
    			List<Integer> temp = matrix.get(++index1);
    			if (temp != null && temp.size() > 0) {
    				index2 = 0;
    				return true;
    			}
    		} 
    		return false;
        } else {
        	return true;
        }
    }
}