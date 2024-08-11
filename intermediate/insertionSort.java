import java.util.ArrayList;
import java.util.Arrays;

/*
    Insertion Sort
        Is better than selection sort because on cases where the array is already sorted,
        the time complexity for insertion sort is O(N) as compared to O(N^2) for selection sort.
 */
public class insertionSort {

    public static void main (String args[]){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 2, 1, 2, -1, -11, -23, 5, 2, 7));

        int n = A.size();

        for(int i = 1; i < n; i++){

            int j = i;

            while (j > 0 && A.get(j) < A.get(j - 1)){

                swap(A, j, j - 1);
                j--;
            }

        }

        System.out.println("res : " + A);

        // Time O(N^2);
        // Space O(1);

    }

    public static void swap (ArrayList<Integer> A, int maxIndex, int minIndex){

        int temp = A.get(maxIndex);

        A.set(maxIndex, A.get(minIndex));

        A.set(minIndex, temp);
    }
}
