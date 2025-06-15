package com.my.company.matrix;

public class MooshakCatchingCheese {

  public int isPath(int[][] grid) {
    return isPath(grid, grid.length, grid[0].length);
  }

  private int isPath(int[][] grid, int rows, int columns) {
    // (x, y) represents the starting point of Mooshak
    return solveMazeUtil(grid, 0, 0, rows, columns);
  }

  /**
   * (x, y) represents the starting point of Mooshak
   *
   * <p>In this method, the mouse can either move in horizontal right or vertically down. But in
   * some cases, it may need that mouse move in horizontal left and vertically up to make a way and
   * get cheese. That part of the functionality has to be implemented.
   */
  private int solveMazeUtil(int[][] grid, int x, int y, int rows, int columns) {
    if (x >= 0 && x < rows && y >= 0 && y < columns) {
      if (grid[x][y] == 9) {
        return 1;
      }
      // Check if maze[x][y] is valid - 1 represents path
      if (grid[x][y] == 1) {
        // Move forward in x direction
        if (solveMazeUtil(grid, x + 1, y, rows, columns) == 1) {
          return 1;
        }

        // If moving in x direction doesn't give solution then move down in y direction
        if (solveMazeUtil(grid, x, y + 1, rows, columns) == 1) {
          return 1;
        }
        // If none of the above movements work then BACKTRACK: unmark x,y as part of
        // solution path
        return 0;
      }
      return 0;
    }
    return 0;
  }
}
