package javasessions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PeopleSort {

	public static String[] sortPeople(String[] names, int[] height) {
		Map<Integer, String> pMap = new HashMap<Integer, String>();
		for (int i = 0; i < names.length; i++) {
			pMap.put(height[i], names[i]);
		}
		String[] sortedNames = new String[names.length];
		Arrays.sort(height);
		for (int j = 0; j < height.length; j++) {
			sortedNames[j] = pMap.get(height[j]);
		}
		return sortedNames;
	}

	public static void main(String[] args) {
		String[] names = { "Jayanta", "Tom", "Peter" };
		int[] height = { 69, 71, 65 };
		System.out.println("Sorted people based on height"+Arrays.toString(sortPeople(names,height)));

	}

}
