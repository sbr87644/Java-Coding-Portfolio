
/**
 *
 * @author Your name
 */
public class Sorts {

    /**
     * Classical insertion sort algorithm that runs in 0(N^2) unless the array
     * is sorted in which the best case is O(N). Conceptually the algorithm is
     * similar to sorting a hand of cards as the dealer deals each card. Each
     * time you pick up a card you shift all cards over that are less than that
     * card then insert the new card in the appropriate location. Hence the name
     * insertion sort.
     *
     * @param arr of integers
     */
    public static void insertSort(int[] arr) {
        //todo
    }

    /**
     * For each index, find the smallest element and perform one swap. Runs in
     * 0(N^2) for all cases but performs at most N-1 swaps.
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        //todo
    }

    /**
     * Divide and Conquer algorithm that picks a pivot and moves all elements
     * that are less than the pivot to the left side and similarly all elements
     * larger than the pivot to the right. Repeat the process on both sides. The
     * algorithm is linearithmic O(nlogn) but can degenerate if a poorly chosen
     * pivot is selected. Choose a randomized pivot to help prevent this. The 
     * algorithm is quite fast as the name suggests, takes advantage of cache hits 
     * but it is not stable(no impact on ints).
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        //todo
    }

    private static void quickSortRecursive(int[] arr, int left, int right) {
        //todo
    }

    private static int pivot(int[] arr, int left, int right) {
        //todo
      
        return -1;
    }

    /**
     * Divide and conquer algorithm that repeatedly divides the array into
     * halves then merges the halves together. The algorithm is stable and runs
     * in O(nlogn) in all cases. It's an out of place algorithm since a temporary
     * array is used in the merge method.
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        //todo
    }

    private static void mergeSortRecursive(int[] arr, int begin, int end) {
        //todo
    }

    // merge two portions that are sorted respectively by creating an auxilliary
    // array as a place holder then copy it back
    private static void merge(int[] arr, int start, int middle, int end) {
        //todo
    }
}
