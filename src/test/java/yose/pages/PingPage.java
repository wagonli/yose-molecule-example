package yose.pages;

import com.objogate.wl.web.AsyncWebDriver;
import org.hamcrest.Matchers;


/**
 * Created by formation on 05/03/15.
 */
public class PingPage {

    private final AsyncWebDriver browser;
    public PingPage(AsyncWebDriver browser) {
        this.browser = browser;
    }

    public void seesServerIsAlive() {
        browser.assertPageSource(Matchers.containsString("{\"alive\":true}"));
    }
}
