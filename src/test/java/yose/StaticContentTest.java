package yose;

import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;

/**
 * Created by formation on 04/03/15.
 */
public class StaticContentTest {
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
    public void canServeCss() throws IOException {
        response = request.get("/css/staticContent.css");
        assertThat(response)
                .isOK()
                .hasContentType("text/css");
    }

    @Test
    public void canServeJs() throws IOException {
        response = request.get("/js/staticContent.js");
        assertThat(response)
                .isOK()
                .hasContentType("application/javascript");
    }
}
