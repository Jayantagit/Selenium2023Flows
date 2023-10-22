package javasessions;

public class ConsistentString {

	public static void main(String[] args) {
		String allowed = "ab";
		String[] words = { "aa", "aba", "bba", "aad", "abn" };
		System.out.println("No of conistent String :=" + consistenStringCount(allowed, words));

	}

	private static int consistenStringCount(String allowed, String[] words) {
		int counter = 0;
		for (String w : words) {
			boolean flag = true;
			for (char c : allowed.toCharArray()) {
				if (w.indexOf(c) == -1) {
					flag = false;
					break;
				}
			}
			if (flag) {
				counter++;
			}

		}
		return counter;
	}

}
