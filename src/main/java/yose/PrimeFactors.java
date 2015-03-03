package yose;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

import java.lang.reflect.Array;

import static com.vtence.molecule.http.MimeTypes.JSON;

public class PrimeFactors {

    private final Gson gson;

    public PrimeFactors(Gson gson) {
        this.gson = gson;
    }

    public void powerOfTwoChallenge(Request request, Response response) throws Exception {
       response.contentType(JSON).body(gson.toJson(new Decomposition()));

    }
    public static class Decomposition {
        public Integer number = 0;
        public Integer[] decomposition;
    }
}
