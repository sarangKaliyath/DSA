/*
Problem Description
Given a string A, you are asked to reverse the string and return the reversed string.

Problem Constraints
1 <= |A| <= 10^5
String A consist only of lowercase characters.

Input Format
First and only argument is a string A.

Output Format
Return a string denoting the reversed string.

Example Input
Input 1: A = "scaler"
Input 2: A = "academy"

Example Output
Output 1: "relacs"
Output 2: "ymedaca"
*/
public class simpleStringReverse {

   public static void main (String args []){

       String str = "hello";

       char [] arr = str.toCharArray();
//       String [] arr = str.split("");
       int n = arr.length;

       int left = 0;
       int right = n - 1;

       while (left < right){
           char temp = arr[left];
           arr[left] = arr[right];
           arr[right]  = temp;

           left++; right--;
       }

       String res = new String(arr);

       System.out.println("res : "  + res);

   }

}
