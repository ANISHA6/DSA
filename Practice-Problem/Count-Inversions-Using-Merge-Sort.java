//Method 1

/* 
    Time Complexity : O(N ^ 2)
    Space Complexity : O(1)

    Where 'N' is the total number of elements in the array/list.
*/

public class Solution {
    public static long getInversions(long[] arr, int n) {
        // Variable to store the total inversions in the array.
        long totalInversions = 0;

        // Check for each element whether any smaller element is present on right side.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    totalInversions += 1;
                }

            }
        }
        return totalInversions;
    }
}

//Method 2

/*
    Time complexity : O(N * log(N))
    Space complexity : O(N)

    Where 'N' is the total number of elements in the array/list.
*/

public class Solution {
    // Function to merge the two subarrays.
    private static long merge(long arr[], int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        long invCount = 0;
        long temp[] = new long[(right - left + 1)];

        while ((i < mid) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                ++k;
                ++i;
            } 
            else {
                temp[k] = arr[j];
                invCount += (mid - i);
                ++k;
                ++j;
            }
        }

        while (i < mid) {
            temp[k] = arr[i];
            ++k;
            ++i;
        }

        while (j <= right) {
            temp[k] = arr[j];
            ++k;
            ++j;
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }

    // Function to split two subarrays and then merge them and count inversions.
    private static long mergeSort(long arr[], int left, int right) {
        long invCount = 0;

        if (right > left) {
            int mid = (right + left) / 2;//We  will keep dividing until left with one element

            /* 
                Divide the array into two parts
                total inversion count will be the
                sum of 'INVCOUNT' of left part +
                'INVCOUNT' of right part + 'INVCOUNT' of
                their combined part.
            */
            invCount = mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid + 1, right);

            // Merge both parts and count their combined inversions.
            invCount += merge(arr, left, mid + 1, right);
        }
        return invCount;
    }

    public static long getInversions(long arr[], int n) {
        return mergeSort(arr, 0, n - 1);
    }
}
