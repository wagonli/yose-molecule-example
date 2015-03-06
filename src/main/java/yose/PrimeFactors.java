package yose;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import yose.primefactor.PrimeFactor;

import java.util.List;
import java.util.stream.Collectors;

import static com.vtence.molecule.http.MimeTypes.JSON;

public class PrimeFactors {

    private final Gson gson;

    public PrimeFactors(Gson gson) {
        this.gson = gson;
    }

    public void decomposition(Request request, Response response) throws Exception {
        List<String> numbers = request.parameters("number");
        if (numbers == null
                || numbers.size() == 0) {
            response.statusCode(400);
            return;
        }

        response.contentType(JSON).body(gson.toJson(decomposeAll(numbers)));
    }

    private Object decomposeAll(List<String> numbers) {
        if (numbers.size() == 1)
        {
            return decompose(numbers.get(0));
        }
        
        return numbers.stream().map(
                this::decompose).collect(Collectors.toList());
    }

    private Object decompose(String input) {
        if (!isInteger(input)) return new Error(input, ErrorType.NotNumber);
        Integer number = Integer.parseInt(input);
        if (number <= 100000) {
            return  new Decomposition(number);
        }
        return new Error(input, ErrorType.ToBigNumber);
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static class Decomposition {
        public Integer number = 0;
        public Integer[] decomposition;

        public Decomposition(Integer number) {
            this.number = number;
            decomposition = PrimeFactor.primeFactorList(number);
        }
    }

    public enum ErrorType {NotNumber, ToBigNumber};
    public static class Error {
        public String number;
        public String error;

        public Error(String number, ErrorType errorType) {
            this.number = number;
            switch (errorType) {
                case NotNumber:
                    error = "not a number";
                    break;
                case ToBigNumber:
                    error = "too big number (>1e6)";
                    break;
                default:
                    error = "unknown";
            }

        }
    }
}
