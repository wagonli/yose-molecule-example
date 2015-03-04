package yose.controler;

import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import yose.StaticHtmlPageController;

import java.io.File;

import static com.vtence.molecule.testing.ResponseAssert.assertThat;

/**
 * Created by formation on 04/03/15.
 */
public class StaticHtmlPageControllerTest {


    private Response response = new Response();
    private StaticHtmlPageController staticHtmlPageController = new StaticHtmlPageController(new File("src/main/webapp/HomePage.html"));
    private Request request= new Request();

    @Test
    public void alwaysReturnHTMLContent() {
        staticHtmlPageController.setupHtmlPage(request, response);
        assertThat(response).hasContentType("text/html");
    }

    @Test
    public void hasNotEmptyBodyResponse() {
        staticHtmlPageController.setupHtmlPage(request, response);
        assertThat(response).hasBodyText(Matchers.not(Matchers.isEmptyOrNullString()));
    }

}
