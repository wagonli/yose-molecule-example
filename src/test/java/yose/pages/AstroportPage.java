package yose.pages;

import com.objogate.wl.web.AsyncElementDriver;
import com.objogate.wl.web.AsyncWebDriver;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import static org.hamcrest.Matchers.containsString;

public class AstroportPage {
    private final AsyncWebDriver browser;

    public AstroportPage(AsyncWebDriver browser) {
        this.browser = browser;
    }

    public AstroportPage displaysMessage(String message) {
        browser.assertPageSource(containsString(message));
        return this;
    }

    public void displaysGates(String color1, String color2, String color3) {
        browser.element(By.id("gate-1")).assertText(containsString(color1));
        browser.element(By.id("gate-2")).assertText(containsString(color2));
        browser.element(By.id("gate-3")).assertText(containsString(color3));
    }
    
    public void displaysShips(String shipeName1, String shipName2, String shipName3) {
        browser.element(By.id("gate-1")).element(By.id("ship-1")).assertText(containsString(shipeName1));
        browser.element(By.id("gate-2")).element(By.id("ship-2")).assertText(containsString(shipName2));
        browser.element(By.id("gate-3")).element(By.id("ship-3")).assertText(containsString(shipName3));
    }
}
