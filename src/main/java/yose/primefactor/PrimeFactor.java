package yose.primefactor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by formation on 03/03/15.
 */
public class PrimeFactor {


    public static Integer[] primeFactorList(int number) {


        List<Integer> result = new ArrayList<>();
        int candidate=2;

        while (number != 1) {
            for (; number % candidate == 0; number = number / candidate) {
                result.add(candidate);
            }
            candidate++;
        }

        return result.toArray(new Integer[result.size()]);
    }


}
