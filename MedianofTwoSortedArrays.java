public class MedianofTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = { { 1 }, { 1 }, { 5 }, { 3, 4 }, { 2 }, { 3 }, { 1 }, {},
				{ 1 } };
		int[][] b = { { 2,3 }, { 2, 3, 4 }, { 1, 2, 3, 4, 6, 7 }, { 1, 2 },
				{ 1 }, { 1, 2 }, { 2, 3, 4, 5, 6 }, { 1 }, { 1, 2, 3 } };
		for (int i = 0; i < a.length; i++) {
			System.out.println(findMedianSortedArrays2(a[i], b[i]));
		}
	}

	public static double findMedianSortedArrays(int A[], int B[]) {
		int alen = A.length;
		int blen = B.length;
		if (alen < blen)
			return findMedianSortedArrays(B, A);
		int start = 0;
		int end = alen - 1;
		int ai = (start + end) / 2;
		int bi = (alen + blen + 1) / 2 - (ai + 1) - 1;

		while (start <= end) {
			ai = (start + end) / 2;
			bi = (alen + blen + 1) / 2 - (ai + 1) - 1;
			if (bi == -1 && blen > 0 && A[ai] > B[0]) {
				end = ai - 1;
			} else if (ai > (alen + blen + 1) / 2 - 1) {
				end = ai - 1;
			} else if (bi > blen - 1) {
				start = ai + 1;
			} else if (ai + 1 < alen && bi >= 0 && bi < blen
					&& A[ai + 1] < B[bi]) {
				start = ai + 1;
			} else if (bi >= 0 && bi + 1 < blen && A[ai] > B[bi + 1]) {
				end = ai - 1;
			} else {
				break;
			}
		}

		int num = alen + blen;
		int a1 = A[ai];
		int b1 = (bi >= 0 && bi < blen) ? B[bi] : Integer.MIN_VALUE;
		int b2 = (bi + 1 >= 0 && bi + 1 < blen) ? B[bi + 1] : Integer.MAX_VALUE;
		int a2 = (ai + 1 >= 0 && ai + 1 < alen) ? A[ai + 1] : Integer.MAX_VALUE;

		if (num % 2 == 1) {
			return Math.max(a1, b1);
		} else {
			return (Math.max(a1, b1) + Math.min(a2, b2)) / 2.0;
		}
	}

	public static double findMedianSortedArrays2(int A[], int B[]) {
		int alen = A.length;
		int blen = B.length;
		if (alen > blen)
			return findMedianSortedArrays(B, A);
		int start = 0;
		int end = alen;
		int ai = (start + end) / 2;
		int bi = (alen + blen + 1) / 2 - ai;

		while (start <= end) {
			ai = (start + end) / 2;
			bi = (alen + blen + 1) / 2 - ai;
			if (ai < alen && bi > 0 && A[ai] < B[bi - 1]) {
				start = ai + 1;
			} else if (ai > 0 && A[ai - 1] > B[bi]) {
				end = ai - 1;
			} else {
				break;
			}
		}

		int num1 = 0;
		if (ai == 0) {
			num1 = B[bi - 1];
		} else if (bi == 0) {
			num1 = A[ai - 1];
		} else {
			num1 = Math.max(A[ai - 1], B[bi - 1]);
		}
		if ((alen + blen) % 2 == 1)
			return num1;
		int num2 = 0;
		if (ai >= alen) {
			num2 = B[bi];
		} else if (bi >= blen) {
			num2 = A[ai];
		} else {
			num2 = Math.min(A[ai], B[bi]);
		}
		return (num1 + num2) / 2.0;
	}
}
