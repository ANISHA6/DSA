//Method1 using recursion or DFS

/*
	Time complexity: O(M * N)
	Space Complexity: O(M * N)
	
	Where M and N are the number of rows and columns in the image, respectively.
*/

public class Solution
{

    public static void floodFillHelper(int[][] image, int i, int j, int oldColor, int newColor)
    {

        // Check if the current coordinates are valid or not.
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length)
        {
            // Invalid coordinates. So, return.
            return;
        }

        if (image[i][j] != oldColor)
        {
            // Current pixel has a different colour than starting pixel.
            return;
        }

        if (image[i][j] == newColor)
        {
            // Current pixel has already been visited.
            return;
        }

        // Replace the colour of current pixel.
        image[i][j] = newColor;

        // Recur for adjacent pixels.
        floodFillHelper(image, i, j + 1, oldColor, newColor);
        floodFillHelper(image, i, j - 1, oldColor, newColor);
        floodFillHelper(image, i + 1, j, oldColor, newColor);
        floodFillHelper(image, i - 1, j, oldColor, newColor);
    }

    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {

        int oldColor = image[x][y];

        floodFillHelper(image, x, y, oldColor, newColor);

        return image;

    }
}



//Method 2, using BFS
/*
	Time complexity: O(M * N)
	Space Complexity: O(M * N)
	
	Where M and N are the number of rows and columns in the image, respectively.
*/

import java.util.Queue;
import java.util.LinkedList;
import javafx.util.Pair;


public class Solution
{

    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {

        int oldColor = image[x][y];

        // Number of rows.
        int m = image.length;

        // Number of columns.
        int n = image[0].length;

        // Queue to hold the coordinates of the pixels.
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        Pair<Integer, Integer> temp = new Pair<Integer, Integer> (x, y);

        q.add(temp);

        while (!q.isEmpty())
        {

            Pair<Integer, Integer> currentPixel = q.remove();

            // i and j represent the row and column of the current pixel.
            int i = currentPixel.getKey();
            int j = currentPixel.getValue();
;
            // Check if the current coordinates are valid.
            if (i >= 0 && i < m && j >= 0 && j < n)
            {
                // Now, check if the current pixel has been colored or not.
                if (image[i][j] == oldColor && image[i][j] != newColor)
                {
                    // So, replace the old colour.
                    image[i][j] = newColor;

                    // Push the adjacent pixels into the queue.
                    Pair<Integer, Integer> up = new Pair<Integer, Integer> (i, j + 1);
                    Pair<Integer, Integer> down = new Pair<Integer, Integer> (i, j - 1);
                    Pair<Integer, Integer> right = new Pair<Integer, Integer> (i + 1, j);
                    Pair<Integer, Integer> left = new Pair<Integer, Integer> (i - 1, j);

                    q.add(up);
                    q.add(down);
                    q.add(right);
                    q.add(left);
                }
            }
        }

        return image;

    }
}
