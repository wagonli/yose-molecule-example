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
public class AstroportTest {
    Element astroportDom;
    //enter here your github user account name
    final String astroportName = "New New York";

    @Before
    public void getAstroportDom() throws IOException, org.xml.sax.SAXException {
        astroportDom = HTMLDocument.toElement(FileUtils.readFileToString(new File("src/main/static/html/Astroport.html")));
    }

    @Test
    public void astroportNameIsNewNewYork() throws IOException {
        assertThat(astroportDom, DomMatchers.hasUniqueSelector("#astroport-name", DomMatchers.hasText(astroportName)));
    }

    @Test
    public void astroportHas3Gates() throws IOException {
        assertThat(astroportDom, DomMatchers.hasUniqueSelector("#gate-1"));
        assertThat(astroportDom, DomMatchers.hasUniqueSelector("#gate-2"));
        assertThat(astroportDom, DomMatchers.hasUniqueSelector("#gate-3"));
    }

    @Test
    public void astroportHas3GatesContainingDockingStation() throws IOException {
        assertThat(astroportDom, DomMatchers.hasUniqueSelector("#gate-1", DomMatchers.hasUniqueSelector("#ship-1")));
        assertThat(astroportDom, DomMatchers.hasUniqueSelector("#gate-2", DomMatchers.hasUniqueSelector("#ship-2")));
        assertThat(astroportDom, DomMatchers.hasUniqueSelector("#gate-3", DomMatchers.hasUniqueSelector("#ship-3")));
    }
}
