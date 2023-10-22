package javasessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingSentence {

	public static void main(String[] args) {
		String s = "Jayanta4 My1  name2 is3";
		System.out.println("Sorted Sentence" + sortSentence(s));

	}

	private static String sortSentence(String s) {
		String[] val = s.split("\\s+");
		List<String> arrList = Arrays.asList(val);
		List<String> wList = new ArrayList<String>(arrList);
		for (String w : val) {
			int index = Character.getNumericValue(w.charAt(w.length() - 1))-1;
			String value = w.substring(0, w.length() - 1);
			System.out.println(index+";"+value);
			wList.set(index, value);

		}
		return String.join(" ", wList);

	}

}
