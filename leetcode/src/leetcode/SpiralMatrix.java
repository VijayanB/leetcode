package leetcode;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {

		int rowId = 0;
		int colId = 0;
		int rowEnd = matrix.length;
		List<Integer> spiralList = new ArrayList<Integer>();
		if (rowEnd == 0)
			return spiralList;
		int colEnd = matrix[0].length;

		while (rowEnd > 0 && colEnd > 0) {

			if (rowEnd == 1) {
				for (int i = 0; i < colEnd; i++) {
					spiralList.add(matrix[rowId][colId++]);
				}
				break;
			}
			if (colEnd == 1) {
				for (int i = 0; i < rowEnd; i++) {
					spiralList.add(matrix[rowId++][colId]);
				}
				break;
			}
			for (int i = 0; i < colEnd - 1; i++) {
				spiralList.add(matrix[rowId][colId++]);
			}
			for (int i = 0; i < rowEnd - 1; i++) {
				spiralList.add(matrix[rowId++][colId]);
			}
			for (int i = 0; i < colEnd - 1; i++) {
				spiralList.add(matrix[rowId][colId--]);
			}
			for (int i = 0; i < rowEnd - 1; i++) {
				spiralList.add(matrix[rowId--][colId]);
			}
			rowEnd = rowEnd - 2;
			colEnd = colEnd - 2;
			rowId++;
			colId++;
		}
		return spiralList;
	}
}