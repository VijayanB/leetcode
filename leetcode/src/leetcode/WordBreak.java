package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {

		Set<String> dict = new HashSet<String>(wordDict);
		boolean aux[] = new boolean[s.length() + 1];
		aux[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			if (aux[i] == false && dict.contains(s.substring(0, i))) {
				aux[i] = true;
				if (i == s.length())
					return true;
			}
			if (aux[i] == true) {
				for (int j = i + 1; j <= s.length(); j++) {
					if (aux[j] == false && dict.contains(s.substring(i, j))) {
						aux[j] = true;
						if (j == s.length())
							return true;
					}
				}
			}
		}
		return false;
	}

}
