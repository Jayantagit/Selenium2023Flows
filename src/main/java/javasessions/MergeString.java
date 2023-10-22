package javasessions;

public class MergeString {

	public static void main(String[] args) {
		String p = "abc";
		String q = "pqrst";
		System.out.println(mergeString(p, q));

	}

	private static String mergeString(String p, String q) {
		StringBuilder sb = new StringBuilder();
		int len1 = p.length();
		int len2 = q.length();
		int minLength = Math.min(len1, len2);
		for (int i = 0; i < minLength; i++) {
			sb.append(p.charAt(i)).append(q.charAt(i));
		}
		if (len1 > minLength) {
			sb.append(p.substring(minLength));
		}
		if (len2 > minLength) {
			sb.append(q.substring(minLength));
		}

		return sb.toString();
	}

}
