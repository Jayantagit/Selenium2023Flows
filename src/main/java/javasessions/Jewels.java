package javasessions;

import java.util.HashMap;
import java.util.Map;

public class Jewels {

	public static void main(String[] args) {
		String jewel = "Aa";
		String stones = "AaBbAvvA";
		System.out.println("Jewl count is:" + countJewel(jewel, stones));

	}

	private static int countJewel(String jewel, String stones) {
		Map<Character, Integer> stoneMap = new HashMap<>();
		for (char c : stones.toCharArray()) {
			stoneMap.put(c, stoneMap.getOrDefault(c, 0) + 1);
		}
		int count = 0;
		for (char j : jewel.toCharArray()) {
			count += stoneMap.getOrDefault(j, 0) ;
		}
		return count;
	}

}
