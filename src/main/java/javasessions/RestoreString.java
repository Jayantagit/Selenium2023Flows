package javasessions;

public class RestoreString {

	public static void main(String[] args) {
		String s = "codeleet";
		int[] index = { 4, 5, 6, 7, 0, 2, 1, 3 };
		System.out.println("Restore string is:" + restoreString(s, index));

	}

	private static String restoreString(String s, int[] index) {
		char words[] = new char[s.length()];
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			words[index[i]] = chars[i];
		}
		return new String(words);
	}

}
