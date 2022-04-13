//Method 1
/*
    Time Complexity : O(N*M*max(N, M))
    Space Complexity : O(1)

    where 'N' is the number of rows and
    'M' is the number of columns in the grid.
*/

import java.util.ArrayList;

public class Solution
{
    public static void setMatrixOnes(ArrayList<ArrayList<Integer>> MAT, int n, int m)
    {
        // Iterate through every row and column
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (MAT.get(i).get(j) == 1)
                {
                    // Set column elements -1
                    for (int k = 0; k < n; k++)
                    {
                        if (MAT.get(k).get(j) == 0)
                        {
                            MAT.get(k).set(j, -1);
                        }
                    }

                    // Set row elements -1
                    for (int k = 0; k < m; k++)
                    {
                        if (MAT.get(i).get(k) == 0)
                        {
                            MAT.get(i).set(k, -1);
                        }
                    }
                }
            }
        }

        // Set all values to 1 from -1
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (MAT.get(i).get(j) == -1)
                {
                    MAT.get(i).set(j, 1);
                }
            }
        }
    }
}


//Method 2
/*
    Time Complexity: O(N*M)
    Space Complexity: O(N+M)

    where 'N' is the number of rows and
    'M' is the number of columns of grid.
*/

import java.util.Arrays;
import java.util.ArrayList;

public class Solution
{
    public static void setMatrixOnes(ArrayList<ArrayList<Integer>> MAT, int n, int m)
    {
        boolean[] rows = new boolean[n];
        boolean[] columns = new boolean[m];

        Arrays.fill(rows, false);
        Arrays.fill(columns, false);

        // Iterate through every cell
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                // If current cell is 1
                if (MAT.get(i).get(j) == 1)
                {
                    // Mark current row and column as true.
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        // If either row or column number of cell is marked true, set value to 1
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (rows[i] == true || columns[j] == true)
                {
                    MAT.get(i).set(j, 1);
                }
            }
        }
    }
}

//Method 3
/*
    Time Complexity: O(N * M)
    Space Complexity: O(1)

    where 'N' is the number of rows and
    'M' is the number of columns of grid.
*/

import java.util.ArrayList;

public class Solution
{
    public static void setMatrixOnes(ArrayList<ArrayList<Integer>> MAT, int n, int m)
    {
        int firstRow = 0;
        int firstColumn = 0;

        for (int i = 0; i < n; i++)
        {
            // If value at first column of 'i-th' row is 1
            if (MAT.get(i).get(0) == 1)
            {
                firstColumn = 1;
            }

            // Check all the columns
            for (int j = 0; j < m; j++)
            {
                if (i == 0 && MAT.get(i).get(j) == 1)
                {
                    firstRow = 1;
                }

                /*
                If any cell MAT[i][j] has value 1, set first column of 'i-th' row
                and first row of 'j-th' column as 1.
                */
                if (MAT.get(i).get(j) == 1)
                {
                    MAT.get(i).set(0, 1);
                    MAT.get(0).set(j, 1);
                }
            }
        }

        /*
        Set value of cells to 1, if either first column of 'i-th' row
        and first row of 'j-th' column is 1.
        */
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < m; j++)
            {
                if (MAT.get(i).get(0) == 1 || MAT.get(0).get(j) == 1)
                {
                    MAT.get(i).set(j, 1);
                }
            }
        }

        // Set value of first row.
        if (firstRow == 1)
        {
            for (int j = 0; j < m; j++)
            {
                MAT.get(0).set(j, 1);
            }
        }

        // Set value of first column
        if (firstColumn == 1)
        {
            for (int i = 0; i < n; i++)
            {
                MAT.get(i).set(0, 1);
            }
        }
    }
}

