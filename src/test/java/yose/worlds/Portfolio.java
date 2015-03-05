package yose.worlds;

import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YoseDriver;
import yose.pages.GitHubPage;

import java.io.IOException;

import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;

public class Portfolio {

    YoseDriver user = new YoseDriver(9999);

    @Before
    public void startGame() throws Exception {
        user.start();
    }

    @After
    public void stopGame() throws Exception {
        user.stop();
    }
    
    @Test
    public void contactMePageChallenge() throws IOException {
        user.home().visitsPersonalProfile().seesJobTitle("Development Engineer at France Telecom");
    }

    @Test
    public void pingLinkChallenge() {
        user.home().visitsPingLink().seesAliveJson();
    }
}
