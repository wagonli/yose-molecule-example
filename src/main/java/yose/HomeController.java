package yose;

import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import com.vtence.molecule.lib.FileBody;

import java.io.File;

/**
 * Created by formation on 04/03/15.
 */
public class HomeController {
    public void getHomePage(Request request, Response response) {

        response.contentType("text/html");
        response.body(new FileBody(new File("src/main/webapp/HomePage.html")));
    }
}
