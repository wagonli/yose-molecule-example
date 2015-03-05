package yose.controler;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import org.junit.Before;
import org.junit.Test;
import yose.PrimeFactors;

import static com.vtence.molecule.testing.ResponseAssert.assertThat;

/**
 * Created by formation on 04/03/15.
 */
public class PrimeFactorsControllerTest {

    private PrimeFactors primeFactor;
    private Response response = new Response() ;
    private Request request = new Request();

    @Before
    public void init() {
        Gson gson = new Gson();
        primeFactor = new PrimeFactors(gson);
    }

    @Test
    public void alwaysRespondWithJson() throws Exception {
        request.addParameter("number","4");
        primeFactor.decomposition(request, response);
        assertThat(response).hasContentType("application/json");
    }

    @Test
    public void badRequestResponseWhenNoParameterNumber() throws Exception {
        primeFactor.decomposition(request, response);
        assertThat(response).hasStatusCode(400);
    }

    @Test
    public void checkParameterNumberIsANumber() throws Exception {
        request.addParameter("number","bad");
        primeFactor.decomposition(request, response);
        assertThat(response).hasBodyText("{\"number\":\"bad\",\"error\":\"not a number\"}");
    }

    @Test
    public void checkParameterNumberIsHigherThanLimit() throws Exception {
        request.addParameter("number","1000001");
        primeFactor.decomposition(request, response);
        assertThat(response).hasBodyText("{\"number\":\"1000001\",\"error\":\"too big number (\\u003e1e6)\"}");
    }
}
