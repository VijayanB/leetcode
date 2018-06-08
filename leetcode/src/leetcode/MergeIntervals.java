package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() < 2)
			return intervals;
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval left, Interval right) {
				return left.start - right.start;
			}
		});

		List<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.start > prev.end) {
				result.add(prev);
				prev = curr;
			} else {
				prev.end = Math.max(prev.end, curr.end);
			}
		}
		result.add(prev);
		return result;
	}
}
