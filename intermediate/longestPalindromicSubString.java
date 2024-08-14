/*
Problem Description

Given a string A of size N, find and return the longest palindromic substring in A.
Substring of string A is A[i...j] where 0 <= i <= j < len(A).

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
Incase of conflict, return the substring which occurs first ( with the least starting index).

Problem Constraints
1 <= N <= 6000

Input Format
First and only argument is a string A.

Output Format
Return a string denoting the longest palindromic substring of string A.

Example Input
Input 1: A = "aaaabaaa"
Input 2: A = "abba

Example Output
Output 1: "aaabaaa"
Output 2: "abba"

Example Explanation
Explanation 1:
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".

Explanation 2:
We can see that longest palindromic substring is of length 4 and the string is "abba".
 */
public class longestPalindromicSubString {

    public static void main (String args []){

        String A = "abb";
        String [] arr = A.split("");
        int n = arr.length;

        optimized(arr, n);

        // Time O(N^2);
        // Space O(N);

    }

    public static void optimized (String [] arr, int n){
        int maxLen =  0;
        StringBuilder subString = new StringBuilder();

        for(int i = 0; i < n; i++){
            int c1 = i;
            int c2 = i;

            int [] res = isExpanded(arr, n, c1, c2);

            int len = res[0];
            int left = res[1];
            int right = res[2];

            if(len > maxLen){

                maxLen = len;

                subString.setLength(0);

                for(int j = left; j <= right; j++){
                    subString.append(arr[j]);
                }
            }

        }

        for(int i = 0; i < n - 1; i++){

            int c1 = i;
            int c2 = i + 1;

            int [] tempArr = isExpanded(arr, n, c1, c2);

            int len = tempArr[0];
            int left = tempArr[1];
            int right = tempArr[2];

            if(len > maxLen){
                maxLen = len;
                subString.setLength(0);
                for(int j = left; j <= right; j++){
                    subString.append(arr[j]);
                }
            }

        }

        System.out.println("res : " + subString);

    }

    public static int [] isExpanded(String [] arr, int n, int left, int right){

        while (left >= 0 && right < n && arr[left].equals(arr[right])){
                left--; right++;
        }
        int len = right - left - 1;

        return new int[]{len, left + 1, right - 1};
    }
}
