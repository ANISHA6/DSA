//Recursion approach
/*

	Time Complexity: O(N * M)
	Space Complexity: O(max(N, M)), 

    Where N is the number of rows and M is the number of columns in the matrix.

*/

import java.util.ArrayList;

public class Solution {

    public static void rotateMatrixHelper(ArrayList<ArrayList<Integer>> mat, int rowStart, int colStart, int rowEnd,
            int colEnd) {
        // Base Condition
        if (rowStart >= rowEnd || colStart >= colEnd) {
            return;
        }

        if (rowStart >= rowEnd - 1 || colStart >= colEnd - 1) {
            return;
        }

        int previous = mat.get(rowStart + 1).get(colStart);
        int current;

        // Move elements of first row from the remaining rows
        for (int i = colStart; i < colEnd; i++) {
            current = mat.get(rowStart).get(i);
            mat.get(rowStart).set(i, previous);
            previous = current;
        }

        rowStart++;

        // Move elements of last column from the remaining columns
        for (int i = rowStart; i < rowEnd; i++) {
            current = mat.get(i).get(colEnd - 1);
            mat.get(i).set(colEnd - 1, previous);
            previous = current;
        }
        colEnd--;

        // Move elements of last row from the remaining rows
        if (rowStart < rowEnd) {
            for (int i = colEnd - 1; i >= colStart; i--) {
                current = mat.get(rowEnd - 1).get(i);
                mat.get(rowEnd - 1).set(i, previous);
                previous = current;
            }
        }
        rowEnd--;

        // Move elements of first column from the remaining rows
        if (colStart < colEnd) {
            for (int i = rowEnd - 1; i >= rowStart; i--) {
                current = mat.get(i).get(colStart);
                mat.get(i).set(colStart, previous);
                previous = current;
            }
        }
        colStart++;

        // Recursively rotate inner rings
        rotateMatrixHelper(mat, rowStart, colStart, rowEnd, colEnd);

    }

    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {

        rotateMatrixHelper(mat, 0, 0, n, m);

    }
}

//Method 2 iterative approach

/*

    Time Complexity: O(N * M)
    Space Complexity: O(1)

    Where N, M are the number of rowStarts and the number of colStartumns of the matrix, 
    respectively. 

*/

import java.util.ArrayList;

public class Solution {

    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Index of starting row and column
        int rowStart = 0, colStart = 0;

        int previous, current;

        while (rowStart < n && colStart < m) {

            // If we have rotated the whole matrix
            if (rowStart == n - 1 || colStart == m - 1) {
                break;
            }
            previous = mat.get(rowStart + 1).get(colStart);

            // Move elements of first row from the remaining rows
            for (int i = colStart; i < m; i++) {

                current = mat.get(rowStart).get(i);
                mat.get(rowStart).set(i, previous);
                previous = current;
            }

            rowStart++;

            // Move elements of last column from the remaining columns
            for (int i = rowStart; i < n; i++) {

                current = mat.get(i).get(m - 1);
                mat.get(i).set(m - 1, previous);
                previous = current;
            }
            m--;

            // Move elements of last row from the remaining rows
            if (rowStart < n) {
                for (int i = m - 1; i >= colStart; i--) {
                    current = mat.get(n - 1).get(i);
                    mat.get(n - 1).set(i, previous);
                    previous = current;
                }
            }
            n--;

            // Move elements of first column from the remaining rows
            if (colStart < m) {
                for (int i = n - 1; i >= rowStart; i--) {
                    current = mat.get(i).get(colStart);
                    mat.get(i).set(colStart, previous);
                    previous = current;
                }
            }
            colStart++;

        }

    }

}


//algorithum

// The idea is to consider the matrix in the form of rings and then rotate each ring recursively. One ring will be rotated in one recursive call. 

// An image showing all the rings in a matrix is given below: 

// There are two rings in the above matrix. The outer ring is shown in the yellow colour, and the inner ring is shown in the blue colour.  It’s easy to rotate the elements in the form of rings. 

// Matrix after rotating the outer ring: 

// Matrix after rotating the inner ring: 

// As there is no more ring, this is the modified output matrix. 
 

// Algorithm: 

// Create a helper function which takes the indices of the current ring as parameters, i.e the starting row index, ending row index, starting column index, ending column index.
// Call the helper function for the outer ring.
// In the helper function,
// Check the base condition, i.e. whether the indices of the ring are valid or not.
// Rotate the current ring as:
// Move the elements of the top side.
// Move the elements of the right side.
// Move the elements of the bottom side.
// Move the elements of the left side.
// Recursively call the function for the inner ring by passing the indices of the inner ring as parameters.
// Time Complexity
// O(N * M), where N is the number of rows and M is the number of columns in the matrix. 

 

// Since we are traversing each element of the matrix just once, the time complexity of the above algorithm is O(N * M). 

// Space Complexity
// O(max(N, M)), where N is the number of rows and M is the number of columns in the matrix. 

 

// We are making max(N/2, M/2) recursive calls and thus, stack space will be used. Hence, the space complexity is O(max(N, M)). 

