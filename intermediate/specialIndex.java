import java.util.ArrayList;
import java.util.Arrays;

/*
    Problem Description
        Given an array, arr[] of size N,
        the task is to find the count of array indices such that removing,
        an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

     Problem Constraints
        1 <= N <= 105
        -105 <= A[i] <= 105
        Sum of all elements of A <= 109

    Input Format
        First argument contains an array A of integers of size N

    Output Format
        Return the count of array indices such that removing,
        an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

    Example Input
        Input 1: A = [2, 1, 6, 4]
        Input 2: A = [1, 1, 1]

    Example Output
        Output 1: 1
        Output 2: 3

    Example Explanation
        Explanation 1:
            Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
            Therefore, the required output is 1.

        Explanation 2:
            Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
            Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
            Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
            Therefore, the required output is 3.

 */
public class specialIndex {

    public static void main (String args []){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 1, 2, 3));
        int n = A.size();

        ArrayList<Integer> pfEven = new ArrayList<>(n);
        ArrayList<Integer> pfOdd = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            if(i == 0){
                pfEven.add(A.get(0));
                pfOdd.add(0);
            }
            else {
                pfEven.add(null);
                pfOdd.add(null);
            }
        }

        for(int i = 1; i < n; i++){

            if( i % 2 == 0){
                pfEven.set(i, pfEven.get(i - 1) + A.get(i));
                pfOdd.set(i, pfOdd.get(i - 1));
            }
            else {
                pfEven.set(i, pfEven.get(i - 1));
                pfOdd.set(i, pfOdd.get(i - 1) + A.get(i));
            }

        }

        int count = 0;

        for(int i = 0; i < n; i++){

            int evenSum = 0;
            int oddSum = 0;

            if(i == 0){
                evenSum += pfOdd.get(n - 1) - pfOdd.get(i);
                oddSum += pfEven.get(n - 1)  - pfEven.get(i);
            }
            else {

                evenSum += pfEven.get(i - 1) + (pfOdd.get(n - 1) - pfOdd.get(i));
                oddSum += pfOdd.get(i - 1) + (pfEven.get(n - 1)  - pfEven.get(i));

            }

            if(evenSum == oddSum) count++;

        }

        System.out.println("count : " + count);

    }

}
