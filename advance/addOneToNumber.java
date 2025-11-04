import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class addOneToNumber {
    public int[] plusOne(int[] A) {
        
        int n = A.length;
        ArrayList<Integer> res = new ArrayList<>();

        int nonZeroElementIndex = 0;

        while(nonZeroElementIndex < n && A[nonZeroElementIndex] == 0) nonZeroElementIndex++;

        if(nonZeroElementIndex == n) return new int []{1};
    
        int sum = A[n - 1] + 1;
    
        if(sum <= 9) { 
            A[n - 1] = sum;
            return java.util.Arrays.copyOfRange(A, nonZeroElementIndex, n);
        }
        
        res.add(sum % 10);
        int carry = sum / 10;
        int i = n - 2;
        sum = 0;
            
        while(carry > 0 && i >= nonZeroElementIndex){
            sum = A[i--] + carry;
            res.add(sum % 10);
            carry = sum / 10;
        }
        
        while(i >= nonZeroElementIndex){
            res.add(A[i]);
            i--;
        }
            
        if(carry > 0) {
            res.add(carry);
        }
        
        while(!res.isEmpty() && res.get(res.size() - 1) == 0){
            res.remove(res.size() - 1);
        }

        Collections.reverse(res);
        
        int [] ans = new int [res.size()];

        for(int j = 0; j < res.size(); j++){
            ans[j] = res.get(j);
        }

        return ans;
    }
    
    public static void main (String args []){

        ArrayList<Integer> A =  new ArrayList<>(Arrays.asList(1,1,1,3,2,1,1,2,5,9,6,5));

        int n = A.size();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            sb.append(A.get(i));
        }

//        BigInteger val = new BigInteger(sb.toString()).add(BigInteger.ONE);
        BigInteger val = new BigInteger(sb.toString()).add(BigInteger.valueOf(1));

        String str = String.valueOf(val);

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < str.length(); i++){

            int numb = Character.getNumericValue(str.charAt(i));

            res.add(numb);
        }

        System.out.println(res);

    }
}
