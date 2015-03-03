package yose.primefactor;

/**
 * Created by formation on 03/03/15.
 */
public class PrimeFactor {


    public static Integer[] powerOfTwoDecomposition(int power) {
        // Compute the number of twos
        long k = Math.round(Math.floor(Math.log(power) / Math.log(2)));
        Integer[] result={};
         for (int i=1; i<k; i++) {
            result[i]= 2;
        }
            return result;




    }
}
