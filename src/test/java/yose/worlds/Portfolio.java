package yose.worlds;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YoseDriver;

import java.io.IOException;

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
        user.home()
                .visitsPersonalProfile()
                .seesJobTitle("Development Engineer at France Telecom");
    }

    @Test
    public void pingLinkChallenge() {
        user.home().visitsPing().seesServerIsAlive();
    }
}
