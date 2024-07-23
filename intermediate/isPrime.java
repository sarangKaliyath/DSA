/*
 *  Problem Description

        Given a number A. Return 1 if A is prime and return 0 if not. 

        Note : The value of A can cross the range of Integer.

 *  Problem Constraints

        1 <= A <= 109

 *  Example Input
 
        Input 1: A = 5

        Input 2: A = 10
    
 *  Example Explanation
 
        Explanation 1: 5 is a prime number.

        Explanation 2: 10 is not a prime number.
 */

public class isPrime {

    public static void main (String args []){
    
        int N = 7;

        checkIfPrime(bruteForce(N));
        checkIfPrime(betterApproach(N));
        checkIfPrime(optimizedApproach(N));
    }

    public static int bruteForce(int N){

        int count = 0;

        for(int i = 1; i <= N; i++){
            if(N%i == 0) count++;
        }

        return count;
    }

    public static int betterApproach(int N){

        int count = 1;

        for(int i = 1; i <= N/2; i++){
            if(N%i == 0) count++;
        }
        return count;
    }

    public static int optimizedApproach(int N){
        int count = 0;

        for(int i = 1; i * i <= N; i++ ){

            if(N%i == 0){

                if(i == N/i) count++;

                else count+= 2;

            }

        }

        return count;
    }

    public static void checkIfPrime(int N){
        if(N == 2) System.out.println(1);
        else System.out.println(0);
    }

 }