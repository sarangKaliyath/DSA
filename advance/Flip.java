import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN.
In a single operation, you can choose two indices, L and R,
such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR.
By flipping, we mean changing character 0 to 1 and vice-versa.
Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
If you don't want to perform the operation, return an empty array.
Else, return an array consisting of two elements denoting L and R.
If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

Problem Constraints
1 <= size of string <= 100000

Input Format
First and only argument is a string A.

Output Format
Return an array of integers denoting the answer.

Example Input
Input 1: A = "010"
Input 2: A = "111"

Example Output
Output 1: [1, 1]
Output 2: []

Example Explanation

Explanation 1:

A = "010"

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | "110"
[1 2]          | "100"
[1 3]          | "101"
[2 2]          | "000"
[2 3]          | "001"

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].

Explanation 2:

No operation can give us more than three 1s in final string. So, we return empty array [].
 */
public class Flip {

    public static void main (String args []){

        String A = "11100001";

        int n = A.length();

        bruteForce (A, n);

        kadanesAlgorithm(A, n);
    }

    public static void bruteForce (String A, int n){

        int maxVal = 0;
        int l = -1;
        int r = -1;

        for(int i = 0; i < n; i++){

            StringBuilder sb = new StringBuilder();

            for(int j = i; j < n; j++){

                sb.append(A.charAt(j));

                int val = 0;

                for(int k = i; k <= j; k++){
                    if(A.charAt(k) == '0') val+= 1;
                    else val -= 1;
                }

                if(val > maxVal){
                    maxVal = val;
                    l = i + 1;
                    r = j + 1;
                }

            }

        }

        if(l == -1 && r == -1){
            System.out.println("[ ]");
        }
        else {
            System.out.println("[" + l + ", " + r + "]");
        }

        // Time O(N^3);
        // Space O(N);
    }

    public  static void kadanesAlgorithm (String A, int n){

        int maxVal = 0;
        int val = 0;
        int l = 0;
        int r = 0;

        int finalLeft = 0;
        int finalRight = 0;

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++){

            if(A.charAt(i) == '1') val -= 1;
            else val += 1;

            if(val > maxVal){
                maxVal = val;
                finalLeft = l + 1;
                finalRight = r + 1;
            }

            if(val < 0){
                val = 0;
                l = i + 1;
                r = i + 1;
            }
            else r++;

        }

        if(maxVal != 0){
            res.add(finalLeft);
            res.add(finalRight);
        }

        System.out.println(res);

        // Time O(N);
        // Space O(1);
    }
}
