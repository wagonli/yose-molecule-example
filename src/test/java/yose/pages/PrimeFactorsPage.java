package yose.pages;

import com.objogate.wl.web.AsyncWebDriver;
import com.objogate.wl.web.ElementAction;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

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
    
    public PrimeFactorsPage seesDecomposeButton(String text)
    {
        browser.element(By.cssSelector("button#go")).assertText(containsString(text));
        return this;
    }

    public PrimeFactorsPage enterNumber(int i) {
        browser.element(By.cssSelector("input#number")).type(String.valueOf(i));
        return this;
    }

    public PrimeFactorsPage seesResult(String result) {
        browser.element(By.cssSelector("#result")).assertText(containsString(result));
        return this;
    }
}
