// Find the total area covered by two rectilinear rectangles in a 2D plane.

// Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

// Rectangle Area
// Assume that the total area is never beyond the maximum possible value of int.

class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area_A = (D - B) * (C - A);
		int area_B = (H - F) * (G - E);

		int A1 = Math.max(A, E);
		int B1 = Math.max(B, F);
		int C1 = Math.min(C, G);
		int D1 = Math.min(D, H);

		int width = C1 > A1 ? C1 - A1 : 0;
		int height = D1 - B1 ? D1 - B1 : 0;
		return area_A + area_B - width * height;
    }
}