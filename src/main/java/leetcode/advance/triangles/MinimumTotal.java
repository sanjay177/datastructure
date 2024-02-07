package leetcode.advance.triangles;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 120 - Minimum Path sum from top to bottom
 */
public class MinimumTotal {
    /**
     * Using bottom Up approach to calculate minimum sum
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows-1).size();
        List<List<Integer>> newTriangle = new ArrayList<>();
        int[][] dp = new int[rows+1][cols+1];
        for(int ir = rows-1; ir>=0; ir--){
            List<Integer> rowTriangle = triangle.get(ir);
            for(int ic=0; ic<=ir; ic++) {
                // Instead of Using Math.min if we will use Math.max it will give maximum sum path on triangle
                dp[ir][ic] = Math.min(rowTriangle.get(ic)+dp[ir+1][ic], rowTriangle.get(ic)+dp[ir+1][ic+1] );
            }
        }
        return dp[0][0];
    }
}
