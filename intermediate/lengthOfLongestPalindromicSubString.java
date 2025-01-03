/*
Problem Description

Given a string A of size N, find and return the length of longest palindromic substring in A.
Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Problem Constraints
1 <= N <= 6000

Input Format
First and only argument is a string A.

Output Format
Return a Integer denoting the longest palindromic substring of string A.

Example Input
Input 1: A = "aaaabaaa"
Input 2: A = "abba"

Example Output
Output 1: 7
Output 2: 4

Example Explanation

Explanation 1:
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".

Explanation 2:
We can see that longest palindromic substring is of length 4 and the string is "abba".
 */
public class lengthOfLongestPalindromicSubString {

    public static void main (String args []){

        String A = "aaaabaaa";
        String [] arr = A.split("");
        int n = arr.length;

        bruteForce(arr, n);

        optimized(arr, n);

    }


    public static void bruteForce(String [] arr, int n){

        int ans = 0;

        for(int i = 0; i < n; i++){

            for(int j = i; j < n; j++){

                if(isPalindrome(arr, i, j)) {
                    ans = Math.max(ans, j - i + 1);
                }

            }

        }
        System.out.println("bruteforce : " + ans);

        // Time O(N^3);
        // Space O(1);
    }

    public static boolean isPalindrome (String [] arr, int start, int end) {

        while (start < end){

            if( !(arr[start].equals(arr[end])) ){
                return false;
            }
            start++; end--;
        }

        return true;
    }

    public  static  void optimized(String [] arr, int n){

        int ans = 0;

        for(int i = 0; i < n; i++){

            int c1 = i;
            int c2 = i;

            ans = Math.max(ans, isExpanded(arr, c1, c2));

        }

        for(int i = 0; i < n - 1; i++){
            int c1 = i;
            int c2 = i + 1;

            ans = Math.max(ans, isExpanded(arr, c1, c2));
        }

        System.out.println("optimized : " + ans);

        // Time O(N^2);
        // Space O(1)
    }

    public static int isExpanded(String [] arr, int c1, int c2){

        while(c1 >= 0 && c2 < arr.length && arr[c1].equals(arr[c2])){
            c1--; c2++;
        }

        return c2 - c1 - 1;
    }

}
