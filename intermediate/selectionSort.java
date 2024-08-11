import java.util.ArrayList;
import java.util.Arrays;

/*
    Selection Sort

        1. Pick the smallest element and place it in the first position.
        2. Pick the second-smallest element and place it in the second position.

        keep going till all the elements in the front are swapped with the smallest element,
        in the remaining array.
 */
public class selectionSort {

    public static void main (String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 1, -1, -2, -11, 3, 2, 4, 6, 654, 4, 3, 3, 4));

        int n = A.size();

        for(int i = 0; i < n; i++){

            int minIndex = i;

            for(int j = i + 1; j < n; j++){

                if(A.get(j) < A.get(minIndex)){
                    minIndex = j;
                }

            }

           swap(A, i, minIndex);

        }

        System.out.println("res : " + A);

        // Time O(N^2);
        // Space O(1);

    }

    public static  ArrayList<Integer> swap (ArrayList<Integer> A, int maxIndex, int minIndex){

        int temp = A.get(maxIndex);
        A.set(maxIndex, A.get(minIndex));
        A.set(minIndex, temp);

        return A;
    }
}
