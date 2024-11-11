import java.util.ArrayList;
import java.util.Arrays;

/*
    Problem Description
        Given an integer array A of size N and an integer B,
        you have to return the same array after rotating it B times towards the right.

    Problem Constraints
        1 <= N <= 10^5
        1 <= A[i] <=10^9
        1 <= B <= 10^9

    Input Format
        The first argument given is the integer array A.
        The second argument given is the integer B.

    Output Format
        Return the array A after rotating it B times to the right

    Example Input
        Input 1:
            A = [1, 2, 3, 4]
            B = 2
        Input 2:
            A = [2, 5, 6]
            B = 1

    Example Output
        Output 1: [3, 4, 1, 2]
        Output 2: [6, 2, 5]

    Example Explanation
        Explanation 1: Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
        Explanation 2: Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]
*/
public class ArrayRotation {
    public static  void main (String args[]){


        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,4,9,4,7,1));
        int B = 9;
        int n = A.size();

        System.out.println(A);
//        bruteForce(A, B, n);
//        secondApproach(A, B, n);
        optimized(A, B, n);

    }

    public static void bruteForce(ArrayList<Integer> A, int B, int n){

        for(int i = 1; i <= B; i++){

            int temp = A.get(n-1);

            for(int j = n - 1; j > 0; j--){
                A.set(j, A.get(j - 1));
            }

            A.set(0, temp);
        }

        System.out.println(A);

    }

    public  static void secondApproach (ArrayList<Integer> A, int B, int n){

        ArrayList<Integer> temp = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            temp.add(null);
        }

        for(int i = 0; i < n; i++){
            int swapIndex = (i + B) % n;
            temp.set(swapIndex, A.get(i));
        }

        System.out.println(temp);
    }

    public static void optimized(ArrayList<Integer> A, int B, int n){

        if(B > n) B = B % n;

        reverse(A, 0, n -1 );

        reverse(A, 0, B - 1);

        reverse(A, B, n - 1);

        System.out.println(A);

    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> A, int startIndex, int endIndex){

        while(startIndex < endIndex){
            int temp = A.get(startIndex);
            A.set(startIndex, A.get(endIndex));
            A.set(endIndex, temp);
            startIndex++;
            endIndex--;
        }

        return A;
    }

}
