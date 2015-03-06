package yose.controler;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import org.junit.Before;
import org.junit.Test;
import yose.PrimeFactors;

import java.util.Arrays;

import static com.jayway.jsonassert.JsonAssert.with;
import static com.vtence.molecule.testing.ResponseAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
    public void reallyDecompose1000000() throws Exception {
        request.addParameter("number","1000000");
        primeFactor.decomposition(request, response);
        assertThat(response).hasBodyText("{\"number\":1000000,\"decomposition\":[2,2,2,2,2,2,5,5,5,5,5,5]}");
    }

    @Test
     public void checkParameterNumberIsHigherThanLimit() throws Exception {
        request.addParameter("number","1000001");
        primeFactor.decomposition(request, response);
        assertThat(response).hasBodyText("{\"number\":\"1000001\",\"error\":\"too big number (\\u003e1e6)\"}");
    }

    @Test
    public void decomposeMultipleNumbers() throws Exception {
        request.addParameter("number","3");
        request.addParameter("number","5");
        request.addParameter("number","7");
        primeFactor.decomposition(request, response);
        assertThat(response).hasBodyText("[{\"number\":3,\"decomposition\":[3]},{\"number\":5,\"decomposition\":[5]},{\"number\":7,\"decomposition\":[7]}]");
    }

    @Test
    public void canDecomposeMixedElements() throws Exception {
        request.addParameter("number","3");
        request.addParameter("number","5");
        request.addParameter("number","tagada");
        primeFactor.decomposition(request, response);
        assertThat(response).hasBodyText("[{\"number\":3,\"decomposition\":[3]},{\"number\":5,\"decomposition\":[5]},{\"number\":\"tagada\",\"error\":\"not a number\"}]");
    }

    @Test
    public void considerEmptyStringAsNotANumber() throws Exception {
        request.addParameter("number", "");
        primeFactor.decomposition(request, response);
        assertThat(response).hasBodyText("{\"number\":\"\",\"error\":\"not a number\"}");
    }
    
    @Test
    public void detectHasTooBigNumberAVeryLargeNumber() throws Exception {
        request.addParameter("number","109876500001");
        primeFactor.decomposition(request, response);
        assertThat(response).hasBodyText("{\"number\":\"109876500001\",\"error\":\"too big number (\\u003e1e6)\"}");

    }
}
