package leetcode;

import java.util.LinkedList;
import java.util.List;

public class generateParenthesis {
	public List<String> generateParenthesis(int n) {
		int count = n * 2;
		char temp[] = new char[count];
		List<String> result = new LinkedList<String>();
		addParenthesis(result, n, n, temp, 0);
		return result;
	}

	private void addParenthesis(List<String> result, int lRem, int rRem, char temp[], int index) {
		if (lRem < 0 || lRem > rRem) {
			return;
		}
		if (lRem == 0 && rRem == 0) {
			result.add(new String(temp));
		} else {
			temp[index] = '(';
			addParenthesis(result, lRem - 1, rRem, temp, index + 1);
			temp[index] = ')';
			addParenthesis(result, lRem, rRem - 1, temp, index + 1);
		}
	}
}
