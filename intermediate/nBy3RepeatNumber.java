import java.util.*;

/*
Problem Description
You're given a read-only array of N integers.
Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.
If there are multiple solutions, return any one.
Note: Read-only array means that the input array should not be modified in the process of solving the problem

Problem Constraints
1 <= N <= 7*105
1 <= A[i] <= 109

Input Format
The only argument is an integer array A.

Output Format
Return an integer.

Example Input
Input 1: [1 2 3 1 1]
Input 2: [1 2 3]

Example Output
Output 1: 1
Output 2: -1

Example Explanation
Explanation 1:
1 occurs 3 times which is more than 5/3 times.

Explanation 2:
No element occurs more than 3 / 3 = 1 times in the array.
 */
public class nBy3RepeatNumber {

    public static void main(String args[]) {

        List<Integer> A = new ArrayList<>(Arrays.asList(1000441, 1000441, 1000994));

        int n = A.size();

        usingObjects(A, n);

        int output = mooreVotingAlgorithm(A, n);

        System.out.println("output : " + output);
    }

    public static int mooreVotingAlgorithm(List<Integer> A, int n){

        int firstEl = Integer.MIN_VALUE;
        int feq1 = 0;

        int secondEl = Integer.MAX_VALUE;
        int feq2 = 0;

        for(int i = 0; i < n; i++){

            int val = A.get(i);

            if(firstEl == val) feq1++;

            else if(secondEl == val) feq2++;

            else if(feq1 == 0) {
                firstEl = val;
                feq1 = 1;
            }

            else if (feq2 == 0){
                secondEl = val;
                feq2 = 1;
            }

            else {
                feq1--;
                feq2--;
            }

        }

        feq1 = 0;
        feq2 = 0;

        for(int i = 0; i < n; i++){

            int val = A.get(i);

            if(firstEl == val) feq1++;

            else if(secondEl == val) feq2++;
        }

        if(feq1 > n/3) return firstEl;

        else if(feq2 > n/3) return secondEl;

        return -1;

        // Time O(N);
        // Space O(1);

    }

    public static void usingObjects (List<Integer> A, int n){

        // Invalid approach since we cannot use extra space;

        HashMap<Integer, Integer> obj = new HashMap<>();

        for(int i = 0; i < n; i++){
            int el = A.get(i);
            if(obj.containsKey(el)){
                obj.put(el, obj.get(el) + 1);
            }
            else {
                obj.put(el, 1);
            }
        }


        for(Map.Entry<Integer, Integer> entry : obj.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(value > n/3) {
                System.out.print("found : " + key + " -> " + value);
                break;
            }
        }

        System.out.println(-1);

        // Time O(N);
        // Space O(N);
    }

}
