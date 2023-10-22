package javasessions;

import java.util.HashMap;
import java.util.Map;

public class UnCommonWords {

	public static String getUncommonWords(String s1, String s2) {
		String s3 = s1 + " " + s2;
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] words = s3.split("\\s+");
		for (String w : words) {
			map.put(w, map.getOrDefault(w, 0) + 1);
		}
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> m : map.entrySet()) {
			if (m.getValue() == 1) {
				sb.append(m.getKey()+" ");
			}
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		String s1 = "This Apple is sweet";
		String s2 = "This Apple is sour";
		System.out.println(getUncommonWords(s1, s2));

	}

}
