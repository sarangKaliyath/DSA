import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class addOneToNumber {

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
