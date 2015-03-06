package yose.factor;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.emptyArray;
import static org.junit.Assert.assertThat;
import static yose.primefactor.PrimeFactor.primeFactorList;

/**
 * Created by formation on 03/03/15.
 */
public class TestNumberFactor {

    @Test
    public void primeFactorsOf2() throws IOException {
        assertThat(primeFactorList(2), arrayContaining(2));

    }

    @Test
    public void primeFactorsOf4() throws IOException {
        assertThat(primeFactorList(4), arrayContaining(2, 2));

    }


    @Test
    public void primeFactorsOf8() throws IOException {
        assertThat(primeFactorList(8), arrayContaining(2, 2, 2));

    }

    @Test
    public void primeFactorsOf1024() throws IOException {
        assertThat(primeFactorList(1024), arrayContaining(2, 2, 2, 2, 2, 2, 2, 2, 2, 2));
    }

    @Test
    public void primeFactorsOfLowerThanTwo() {
        assertThat(primeFactorList(1), emptyArray());
    }

    @Test
    public void primeFactorsOf3() {
        assertThat(primeFactorList(3),  arrayContaining(3));
    }
    @Test
    public void primeFactorsListOf6() {
        assertThat(primeFactorList(6),  arrayContaining(2,3));
    }
    @Test
    public void primeFactorsListOf9() {
        assertThat(primeFactorList(9),  arrayContaining(3,3));
    }
    @Test
    public void primeFactorsListOf18() {
        assertThat(primeFactorList(18),  arrayContaining(2,3,3));
    }
    @Test
    public void primeFactorsListOf210() {
        assertThat(primeFactorList(210),  arrayContaining(2,3,5,7));
    }
    @Test(timeout = 1000)
    public void emptyListForNegativeNumber() {
        assertThat(primeFactorList(-10), emptyArray());
    }

}
