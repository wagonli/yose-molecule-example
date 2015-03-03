package yose.worlds;

import com.objogate.wl.web.AsyncWebDriver;
import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import yose.YoseDriver;

import java.io.IOException;

import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class StartWorld {

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
    public void firstWebPageChallenge() throws IOException {
        yose.home().displaysMessage("Hello Yose");
    }

    @Test
    public void firstWebServiceChallenge() throws IOException {
        response = request.get("/ping");

        assertThat(response).isOK()
                            .hasContentType("application/json")
                            .hasBodyText("{\"alive\":true}");
    }

    @Test
    public void shareWebPageChallenge() throws IOException {
        AsyncWebDriver browser = yose.home().openGithub();
        browser.assertPageSource(containsString("yose-molecule-example"));
        browser.element(By.id("readme")).assertText(containsString("YoseTheGame"));
    }
}
