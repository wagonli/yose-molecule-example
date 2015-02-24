package yose;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class StartWorldTest {

    int PORT = 9999;
    WebServer server = WebServer.create(PORT);

    HttpRequest request = new HttpRequest(PORT);
    HttpResponse response;

    Yose yose = new Yose(new Gson());

    @Before
    public void startGame() throws Exception {
        yose.start(server);
    }

    @After
    public void stopGame() throws Exception {
        server.stop();
    }

    @Test
    public void passesHelloChallenge() throws IOException {
        response = request.get("/");

        assertThat(response).isOK()
                            .hasBodyText(containsString("Hello Yose"));
    }

    @Test
    public void passesPingChallenge() throws IOException {
        response = request.get("/ping");

        assertThat(response).isOK()
                            .hasContentType("application/json")
                            .hasBodyText("{\"alive\":true}");
    }
}