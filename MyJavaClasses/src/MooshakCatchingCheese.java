import java.util.ArrayList;

/**
 * Mooshak the mouse has been placed in a maze. There is a huge chunk of cheese
 * somewhere in the maze. The maze is represented as a two dimensional array of
 * integers, where 0 represents walls.1 repersents paths where Mooshak can move
 * and 9 represents the huge chunk of cheese.
 * 
 * Mooshak starts in the top left corner at 0. Write a method isPath() of class
 * MazePath to determine if Mooshak can reach the huge chunk of cheese. The
 * input to isPath() consists of a two dimensional array grid for the maze
 * matrix. the method should return 1 if there is a path from Mooshak to the
 * cheese. and 0 if not Mooshak is not allowed to leave the maze or climb on
 * walls.
 * 
 * EX: 8 by 8(8*8) matrix maze where Mooshak can get the cheese.
 * 
 * 1 0 1 1 1 0 0 1 1 0 0 0 1 1 1 1 1 0 0 0 0 0 0 0 1 0 1 0 9 0 1 1 1 1 1 0 1 0 0
 * 1 1 0 1 0 1 1 0 1 1 0 0 0 0 1 0 1 1 1 1 1 1 1 1 1
 * 
 * Test Cases:
 * 
 * Case 1: Input:[[1,1,1,][9,1,1],[0,1,0]] Expected return value :1 Explanation:
 * The piece of cheese is placed at(1,0) on the grid, Mooshak can move from
 * (0,0) to (1,0) to reach it or can move from (0,0) to (0,1) to (1,1) to (1,0)
 * 
 * Test case 2: Input: [[0,0,0],[9,1,1],[0,1,1]] Expected return value: 0
 * Explanation: Mooshak cannot move anywhere as there exists a wall right on
 * (0,0)
 */
public class MooshakCatchingCheese
{

	public static void main(String[] args)
	{

		int[][] grid1 = new int[][] { { 1, 1, 1 }, { 9, 1, 1 }, { 0, 1, 0 } };
		System.out.println("isPath(grid1) : " + isPath(grid1));

		int[][] grid2 = new int[][] { { 0, 0, 0 }, { 9, 1, 1 }, { 0, 1, 1 } };
		System.out.println("isPath(grid2) : " + isPath(grid2));

		int[][] grid3 = new int[][] { { 1, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 9, 0, 1, 1 }, { 1, 1, 1, 0, 1, 0, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };
		System.out.println("isPath(grid3) : " + isPath(grid3));

		int[][] grid4 = new int[][] { { 1, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 9, 0, 1, 1 }, { 1, 1, 1, 0, 1, 0, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };
		System.out.println("isPath(grid4) : " + isPath(grid4));

		int[][] grid5 = new int[][] { { 1, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 9, 0, 1, 1 }, { 1, 1, 1, 1, 1, 0, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };
		System.out.println("isPath(grid5) : " + isPath(grid5));
	}

	public static int isPath(int[][] grid)
	{
		return isPath(grid, grid.length, grid[0].length);
	}

	static int isPath(int[][] grid, int rows, int columns)
	{
		// (x, y) represents the starting point of Mooshak
		return solveMazeUtil(grid, 0, 0, rows, columns);
	}

	/**
	 * (x, y) represents the starting point of Mooshak
	 * 
	 * In this method, the mouse can either move in horizontal right or vertically
	 * down. But in some cases, it may need that mouse move in horizontal left and
	 * vertically up to make a way and get cheese. That part of the functionality
	 * has to be implemented.
	 */
	static int solveMazeUtil(int[][] grid, int x, int y, int rows, int columns)
	{
		if (x >= 0 && x < rows && y >= 0 && y < columns)
		{
			if (grid[x][y] == 9)
			{
				return 1;
			}
			// Check if maze[x][y] is valid - 1 represents path
			if (grid[x][y] == 1)
			{
				// Move forward in x direction
				if (solveMazeUtil(grid, x + 1, y, rows, columns) == 1)
				{
					return 1;
				}

				// If moving in x direction doesn't give solution then move down in y direction
				if (solveMazeUtil(grid, x, y + 1, rows, columns) == 1)
				{
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
