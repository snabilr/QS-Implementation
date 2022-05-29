package TestQuickSort;

import java.io.*;
import java.util.ArrayList;

class QuickSortStudent {

// A utility function to swap two elements
    static void swap(ArrayList<Student> arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;

        Student temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    /*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
     */
    static int partition(ArrayList<Student> arr, int low, int high, String dir) {

        // pivot
        int pivot = arr.get(high).nim;

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (dir == "asc") {
                if (arr.get(j).nim < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }

            if (dir == "desc") {
                if (arr.get(j).nim > pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /*
	 * The main function that implements QuickSort arr[] --> Array to be sorted, low
	 * --> Starting index, high --> Ending index
     */
    static void quickSort(ArrayList<Student> arr, int low, int high, String dir) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high, dir
            );

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1, dir
            );
            quickSort(arr, pi + 1, high, dir
            );
        }
    }

// Function to print an array
    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    static ArrayList sort(ArrayList<Student> arr, String dir) {
        int n = arr.size();

        quickSort(arr, 0, n - 1, dir
        );

        return arr;
    }

// Driver Code
//    public static void main(String[] args) {
//        int[] arr = {13, 7, 6, 1, 27, 9};
//
//        int n = arr.length;
//
//        quickSort(arr, 0, n - 1);
//    }
}
