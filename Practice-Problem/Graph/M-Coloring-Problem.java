//Method 1, brute force

/*
	Time complexity: O(M ^ V + M * V * V)
	Space complexity: O(V)

	Where V is the number of vertices in the graph
	and M is maximum number of colors allowed
*/

public class Solution {

	// Function to check if the coloring is valid
	private static boolean isCorrect(int[][] mat, int[] color) {
		
		// Iterate through each cell
		for (int i = 0; i < mat.length; ++i) {
			for (int j = i + 1; j < mat.length; ++j) {
				
				// Check if (i, j) is not valid
				if (mat[i][j] == 1 && color[i] == color[j]) {
					return false;
				}
			}
		}

		// Return true as all cells are valid
		return true;
	}

	// Function to check if entire graph is colored correctly
	private static boolean graphCol(int[][] mat, int m, int cur, int[] color) {
		
		// If current row is the last row
		if (cur == mat.length) {
			if (isCorrect(mat, color)) {
				return true;
			}
			return false;
		}

		// Generate all possible combinations recursively
		for (int j = 1; j <= m; ++j) {
			color[cur] = j;

	        // If we found a valid coloring, return true
			if (graphCol(mat, m, cur + 1, color)) {
				return true;
			}

			color[cur] = 0;
		}

    	// No valid coloring found
		return false;
	}

	// Main function to color the graph
	public static String graphColoring(int[][] mat, int m) {
		int v = mat.length;
		
		// Initialize color list
		int[] color = new int[v];
		if (graphCol(mat, m, 0, color)) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}

//Method 2, backtracking

/*
	Time complexity: O(M ^ V + M * V * V), O(N^M)
	Space complexity: O(V)

	Where V is the number of vertices in the graph
	and M is maximum number of colors allowed
*/

public class Solution {

	// Function to check if the coloring is valid
	private static boolean isCorrect(int[][] mat, int cur, int[] color, int col) {
		
		// Iterate through each cell
		for (int i = 0; i < mat.length; ++i) {
			
			// Check if (i, j) is not valid
			if (mat[cur][i] == 1 && color[i] == col) {
				return false;
			}
		}

		// Return true as all cells are valid
		return true;
	}
	
	// Function to check if entire graph is colored correctly
	private static boolean graphCol(int[][] mat, int m, int cur, int[] color) {
		
		// If current row is the last row
		if (cur == mat.length) {
			return true;
		}

		// Generate all possible combinations recursively
		for (int j = 1; j <= m; ++j) {
			if (isCorrect(mat, cur, color, j)) {
				color[cur] = j;
				
				// If we found a valid coloring, return true
				if (graphCol(mat, m, cur + 1, color)) {
					return true;
				}
				color[cur] = 0;
			}
		}

		// No valid coloring found
		return false;
	}

	// Main function to color the graph
	public static String graphColoring(int[][] mat, int m) {
		int v = mat.length;
		
		// Initialize color list
		int[] color = new int[v];
		if (graphCol(mat, m, 0, color)) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}
