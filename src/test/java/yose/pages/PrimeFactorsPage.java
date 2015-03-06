package yose.pages;

import com.objogate.wl.web.AsyncWebDriver;

import static org.hamcrest.Matchers.containsString;

/**
 * Created by formation on 06/03/15.
 */
public class PrimeFactorsPage {
    private final AsyncWebDriver browser;

    public PrimeFactorsPage(AsyncWebDriver browser) {
        this.browser = browser;
    }

    public PrimeFactorsPage displaysMessage(String message) {
        browser.assertPageSource(containsString(message));
        return this;
    }
}
