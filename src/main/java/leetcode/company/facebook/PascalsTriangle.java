package leetcode.company.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 118. Pascal's Triangle
 * O(rows*cols) - Time complexity
 * O(rows*cols) - Space Complexity
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        triangle.add(list1);
        List<Integer> prevRow = list1;
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // First Column
            for(int col=1; col < i; col++) {
                row.add(prevRow.get(col)+prevRow.get(col-1));
            }
            row.add(1); // Last column
            prevRow = row;
            triangle.add(row);
        }
        return triangle;
    }
}
