package leetcode.company.multiple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode - 200
 * O(row*col) Time Complexity - Simple Approach dfs stack based
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        //return dfsApproach(grid);
        return bfsApproach(grid);
    }
    // Queue FIFO
    int bfsApproach(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int numIsland = 0;
        for(int i = 0 ; i < nr; i++) {
            for(int j = 0; j<nc; j++) {
                if(grid[i][j] == '1'){
                    numIsland++;
                    bfs(grid, i, j);
                }
            }
        }
        return numIsland;
    }

    void bfs(char[][] grid , int r, int c){
        int[][] directions = {{0,-1}, {0, 1}, {-1, 0}, {1,0}};
        int nr = grid.length;
        int nc = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        while(!queue.isEmpty()) {
            int[] rowCols = queue.poll();
            int row = rowCols[0];
            int col = rowCols[1];
            for(int[] dir: directions){
                int cRow = row+dir[0];
                int cCol = col+dir[1];
                if(cRow>=0 && cCol >=0 && cRow < nr && cCol < nc && grid[cRow][cCol] == '1') {
                    grid[cRow][cCol] = '0';
                    queue.offer(new int[]{cRow, cCol});
                }

            }
        }
    }



    // Stack LIFO
    int dfsApproach(char[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int numsIsland =0;

        for(int i=0; i< numRows; i++ ) {
            for(int j=0; j<numCols; j++){
                if(grid[i][j] == '1') {
                    numsIsland++;
                    dfs(grid, i, j);
                }
            }
        }
        return numsIsland;

    }


    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if(r<0 || c <0 || r>=nr || c >=nc ||  grid[r][c] =='0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
    }
}
