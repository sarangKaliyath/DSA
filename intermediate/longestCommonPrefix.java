import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Problem Description

Given the array of strings A, you need to find the longest string S,
which is the prefix of ALL the strings in the array.
The longest common prefix for a pair of strings S1 and S2,
is the longest string S which is the prefix of both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Problem Constraints
0 <= sum of length of all strings <= 1000000

Input Format
The only argument given is an array of strings A.

Output Format
Return the longest common prefix of all strings in A.

Example Input

Input 1:
A = ["abcdefgh", "aefghijk", "abcefgh"]

Input 2:
A = ["abab", "ab", "abcd"];

Example Output
Output 1: "a"
Output 2: "ab"

Example Explanation

Explanation 1:
Longest common prefix of all the strings is "a".

Explanation 2:
Longest common prefix of all the strings is "ab".
 */
public class longestCommonPrefix {

    public static void main (String args []){

        ArrayList<String> A = new ArrayList<>(Arrays.asList("abcd","abde","abcf"));

        int n = A.size();

        System.out.println(A);

        bruteForce(A, n);

    }

    public static void bruteForce (ArrayList<String> A, int n){

        int minLen = A.get(0).length();

        for (int i = 1; i < n; i++){
            if(A.get(i).length() < minLen) minLen = A.get(i).length();
        }

        StringBuilder res = new StringBuilder();

        if(n == 1){
            System.out.println(A.get(0));
        }
        else {

            for (int i = 0; i < minLen; i++) {

                boolean isPresent = true;

                for (int j = 1; j < n; j++) {

                    if (A.get(j).charAt(i) != A.get(j - 1).charAt(i)) {
                        isPresent = false;
                        break;
                    }

                }

                if (isPresent) res.append(A.get(0).charAt(i));

            }

            System.out.println(res);
        }

    }
}
