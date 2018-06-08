package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UniqueSubstring {

	public static void main(String[] args) {
		char[] uniqueChars = { 'c' };
		System.out.println(new UniqueSubstring().getUniqueSmallestSubstring(uniqueChars, "xyyzyzyx"));
	}

	private String getUniqueSmallestSubstring(char[] uniqueChars, String s) {

		List<Character> uniqueLists = new ArrayList<Character>();
		for(char c : uniqueChars){
			uniqueLists.add(c);
		}
		String result = "";
		// character counter for s
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int minLen = s.length() + 1;

		int count = 0; // the total of mapped characters

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (uniqueLists.contains(c)) {
				if (!map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
					count++;
				}
			}

			if (count == uniqueLists.size()) {
				char sc = s.charAt(left);
				while (!map.containsKey(sc) || map.get(sc) > 1) {
					if (map.containsKey(sc) && map.get(sc) > 1)
						map.put(sc, map.get(sc) - 1);
					left++;
					sc = s.charAt(left);
				}

				if (i - left + 1 < minLen) {
					result = s.substring(left, i + 1);
					minLen = i - left + 1;
				}
			}
		}

		return result;
	}
}
