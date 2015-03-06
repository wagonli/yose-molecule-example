package yose;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.testinfected.hamcrest.dom.DomMatchers;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertThat;

/**
 * Created by formation on 04/03/15.
 */
public class PrimeFactorsFormPageTest {
    Element primeFactorsFormDom;

    @Before
    public void getAstroportDom() throws IOException, org.xml.sax.SAXException {
        primeFactorsFormDom = HTMLDocument.toElement(FileUtils.readFileToString(new File("src/main/static/html/PrimeFactorsForm.html")));
    }

    /*

#title
    An element that will help the user knows where he is
#invitation
    An element that will describe to the user what we expect from him
input#number
    The input field where the user can enter the number to be decomposed
button#go
    The button to trigger the decomposition
     */
    
    @Test
    public void pageHasATitleElement() throws IOException {
        assertThat(primeFactorsFormDom, DomMatchers.hasUniqueSelector("form", DomMatchers.hasUniqueSelector("#title")));
    }

    @Test
    public void pageHasInvitationElement() throws IOException {
        assertThat(primeFactorsFormDom, DomMatchers.hasUniqueSelector("form", DomMatchers.hasUniqueSelector("#invitation")));
    }

    @Test
    public void pageHasNumberInput() throws IOException {
        assertThat(primeFactorsFormDom, DomMatchers.hasUniqueSelector("form", DomMatchers.hasUniqueSelector("#number", DomMatchers.hasTag("input"))));
    }

    @Test
    public void pageHasGoButton() throws IOException {
        assertThat(primeFactorsFormDom, DomMatchers.hasUniqueSelector("form", DomMatchers.hasUniqueSelector("#go", DomMatchers.hasTag("button"))));
    }
    
}
