package yose.worlds;

import com.jayway.jsonassert.JsonAssert;
import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YoseDriver;

import java.io.IOException;
import java.util.Arrays;

import static com.jayway.jsonassert.JsonAssert.with;
import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PrimeFactors {

    YoseDriver yose = new YoseDriver(9999);

    HttpRequest request = new HttpRequest(9999);
    HttpResponse response;

    @Before
    public void startGame() throws Exception {
        yose.start();
    }

    @After
    public void stopGame() throws Exception {
        yose.stop();
    }

    @Test
    public void powerOfTwoChallenge() throws IOException {
        response = request.get("/primeFactors?number=4");

        assertThat(response).isOK()
                .hasContentType("application/json");
        with(response.bodyText())
                .assertThat("number", equalTo(4))
                .assertThat("decomposition", equalTo(Arrays.asList(2,2)));
    }

    @Test
    public void getOrderedListOfPrimeNumbers() throws IOException {
        response = request.get("/primeFactors?number=65534");
        assertThat(response).isOK();
        with(response.bodyText())
                //.assertThat("number", equalTo(16))
                //.assertThat("decomposition", equalTo(Arrays.asList(2,2,2,2)));
                .assertThat("number", equalTo(65534))
                .assertThat("decomposition", equalTo(Arrays.asList(2,7,31,151)));
    }

    @Test
    public void stringGuardChallenge() throws IOException {
        response = request.get("/primeFactors?number=hello");

        assertThat(response).isOK()
                .hasContentType("application/json");
        with(response.bodyText())
                .assertThat("number", equalTo("hello"))
                .assertThat("error", equalTo("not a number"));
    }
}
