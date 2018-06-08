package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int length = 0;
		int left = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			int count = 0;
			if(map.containsKey(c)){
				count = map.get(c);
			}
			map.put(c, count+1);
			
			if(map.size() > k){
				length = Math.max(length, i - left + 1);
				while(map.size() >= k){
					char leftChar = s.charAt(left);
					if(map.get(leftChar) == 1){
						map.remove(leftChar);
					}
					else{
						map.put(leftChar, map.get(leftChar)-1);
					}
				}
			}
		}

		return Math.max(length, s.length() - left + 1);
	}
}
