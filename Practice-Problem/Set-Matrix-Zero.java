/*
    Time Complexity: O(N * M * (N + M)) 
    Space Complexity:O(N * M) 

    Where N & M are dimensions of the given matrix.
*/

public class Solution {

	public static void setZeros(int matrix[][]) {

		// Storing dimensions of matrix in n and m.
		int n = matrix.length;
		int m = matrix[0].length;

		// Declaring isZero boolean matrix.
		Boolean isZero[][] = new Boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				isZero[i][j] = false;
			}
		}

		// Traversing the original matrix.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// If that element of the matrix is equal to 0.
				if (matrix[i][j] == 0) {

					// Traversing its complete column and setting all the isZero values to be true.
					for (int k = 0; k < n; k++) {
						isZero[k][j] = true;
					}

					// Traversing its complete row and setting all the isZero values to be true.
					for (int k = 0; k < m; k++) {
						isZero[i][k] = true;
					}
				}
			}
		}

		// Travrsing isZero and if isZero at an index is true then we replace that
		// element with zero in original matrix.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isZero[i][j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}

//Method 2

/*
    Time Complexity: O(N * M) 
    Space Complexity: O(N + M) 

    Where N & M are dimensions of the given matrix.
*/

public class Solution {

	public static void setZeros(int matrix[][]) {

		// Storing dimensions of matrix in n and m.
		int n = matrix.length;
		int m = matrix[0].length;

		// Declaring two boolean arrays colZero and rowZero.
		Boolean colZero[] = new Boolean[m];
		Boolean rowZero[] = new Boolean[n];
		for (int i = 0; i < m; i++) {
			colZero[i] = false;
		}
		for (int i = 0; i < n; i++) {
			rowZero[i] = false;
		}

		// Traversing the original matrix and filling values for rowZero and calZero.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					colZero[j] = rowZero[i] = true;
				}
			}
		}

		// Traversing the original matrix and changing values of matrix according to
		// rowZero and colZero.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (rowZero[i] || colZero[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
//Method 3
/*
    Time Complexity: O(N * M) 
    Space Complexity:O(1) 

    Where N & M are dimensions of the given matrix.
*/

public class Solution {

    public static void setZeros(int matrix[][]) {

        // Storing dimensions of matrix in n and m.
        int n = matrix.length;
        int m = matrix[0].length;

        // Declaring two boolean variables firstColZero and firstRowZero.
        Boolean firstColZero = false, firstRowZero = false;

        // Setting firstColZero to true if any element in first column is zero.
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Setting firstRowZero to true if any element in first row is zero.
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Setting values for each row and column to be zero or not.
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // If any element of first row is zero then that complete column should be zero
        // and vice-versa.
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Setting first row to zero if firstRowZero is true.
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        // Setting first column to zero if firstColZero is true.
        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
