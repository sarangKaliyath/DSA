package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.
Note: Return the two numbers in ascending order.

Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 10^9

Input Format
The first argument is an array of integers of size N.

Output Format
Return an array of two integers that appear only once.

Example Input

Input 1: A = [1, 2, 3, 1, 2, 4]
Input 2: A = [1, 2]

Example Output

Output 1: [3, 4]
Output 2: [1, 2]

Example Explanation

Explanation 1: 3 and 4 appear only once.
Explanation 2: 1 and 2 appear only once.

 */
public class SingleNumberThree {
    public static void main(String args[]) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 2, 4));

        int n = A.size();

        bruteForce(A, n);

        optimized(A, n);
    }

    public static void bruteForce(ArrayList<Integer> A, int n) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int key = A.get(i);

            if (map.containsKey(A.get(i))) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }

        }

        int ansOne = 0;
        int ansTwo = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int value = entry.getValue();
            int key = entry.getKey();

            if(entry.getValue() == 1){
                if(ansOne == 0) ansOne = key;
                else ansTwo = key;
            }

        }

        if (ansOne < ansTwo) {
            System.out.println("ansOne : " + ansOne + " ansTwo : " + ansTwo);
        } else {
            System.out.println("ansTwo : " + ansTwo + " ansOne" + ansOne);
        }

    }

    public static void optimized(ArrayList<Integer> A, int n) {

        int xOrVal = 0;

        for (int i = 0; i < n; i++) {
            xOrVal ^= A.get(i);
        }

        int index = -1;

        for (int i = 0; i < 32; i++) {

            if ((xOrVal & 1 << i) > 0) {
                index = i;
                break;
            }
        }

        int uniqueOne = 0;
        int uniqueTwo = 0;

        for (int i = 0; i < n; i++) {

            if ((A.get(i) & (1 << index)) > 0) uniqueOne ^= A.get(i);

            else uniqueTwo ^= A.get(i);
        }

        if (uniqueOne < uniqueTwo) {
            System.out.println("uniqueOne : " + uniqueOne + " uniqueTwo : " + uniqueTwo);
        } else {
            System.out.println("uniqueTwo : " + uniqueTwo + " uniqueOne" + uniqueOne);
        }

        // Time O(N);
        // Space O(1);

    }
}
