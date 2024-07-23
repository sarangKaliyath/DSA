/* 

Problem Description:

    Given an integer A, you need to find the count of it's factors.

    Factor of a number is the number which divides it perfectly leaving no remainder.

Example:

    1, 2, 3, 6 are factors of 6

Problem Constraints:

    1 <= A <= 109

Example Input

    Input 1: 5

    Input 2: 10

Example Explanation

    Explanation 1: Factors of 5 are 1 and 5.

    Explanation 2: Factors of 10 are 1, 2, 5 and 10.

*/

const A = 100;

// O(N);
const bruteForce = () => {
    let count = 0;

    for(let i = 1; i <= A; i++){
        if(A%i === 0) count++;
    }

    console.log(count);
}

// O(N/2);
const betterApproach = () => {

    // here count starts from 1, since the number A itself is excluded in the iteration;
    let count = 1; 

    for(let i = 1; i <= A/2; i++){
        if(A%i === 0) count++;
    }

    console.log(count)
}

// O(√N)
const optimizedApproach = () => {
    let count = 0;

    for(let i = 1; i * i <= A; i++){
        // i*i <= A is same as i <= squareRoot of A;
        
        if(A%i === 0){

            if(i == A/i) {
                /* 
                    i.e in case of 1A = 00 the factors are

                    i   A/i     N

                    1   100     100/1

                    2   50      100/2

                    4   25      100/4
                    
                    5   20      100/5
                    ---------------------------------------

                    10  10      100/10 ---> i == A/i

                    --------------------------------------- Past this point the sequence is reversed.

                    20  5       100/20

                    25  4       100/25

                    50  2       100/50

                    100 1       100/100

                */
                count++;
            }
            else {
                count+= 2;
            }

        }
        
    }

    console.log(count);
}


bruteForce();
betterApproach();
optimizedApproach();