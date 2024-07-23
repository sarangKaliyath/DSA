/*
    Problem Description

        You are given an integer A. You have to tell whether it is a perfect number or not.

        Perfect number is a positive integer which is equal to the sum of its proper positive divisors.

        A proper divisor of a natural number is the divisor that is strictly less than the number.



    Problem Constraints

        1 <= A <= 106


    Example Input

        Input 1: A = 4

        Input 2: A = 6



    Example Explanation

        Explanation 1: For A = 4, the sum of its proper divisors = 1 + 2 = 3, is not equal to 4.

        Explanation 2: For A = 6, the sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6. 

*/

let A = 6;


const bruteForce = () => {

    let sum = 0;

    for(let i = 1; i < A; i++){
        if(A%i === 0) sum+= i;
    }

    return sum;
}

const betterApproach = () => {

    let sum = 0;

    for(let i = 1; i <= A/2; i++){
        if(A%i === 0) sum+= i;
    }

    return sum;
}

const optimizedApproach = () => {
    
    let sum = 0;

    for(let i = 1; i*i <= A; i++){

        if(A%i === 0){

            sum+= i;

            if(i !== 1 && i !== A/i){
                sum+= A/i;
            }

        }

    }

    return sum;
}


const isPerfect = (sum) => {
    if(sum === A) console.log({result: 1, sum});
    else console.log({result: 0, sum});
}

isPerfect(bruteForce());
isPerfect(betterApproach());
isPerfect(optimizedApproach());