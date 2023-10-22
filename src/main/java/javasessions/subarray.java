package javasessions;

public class subarray {

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));

	}

	private static int maxSubArraySum(int[] a) {
		int max_sub_Array = 0;
		int max_so_far = a[0];
		for (int i = 1; i < a.length; i++) {
			max_sub_Array += a[i];
			if (max_sub_Array > max_so_far) {
				max_so_far = max_sub_Array;
			}
			if (max_sub_Array < 0) {
				max_sub_Array = 0;
			}

		}
		return max_so_far;
	}

}
