package yose.controler;

import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import yose.HomeController;

import static com.vtence.molecule.testing.ResponseAssert.assertThat;

/**
 * Created by formation on 04/03/15.
 */
public class HomeControllerTest {


    private Response response = new Response();
    private HomeController homeController = new HomeController();
    private Request request= new Request();

    @Test
    public void alwaysReturnHTMLContent() {
        homeController.getHomePage(request, response);
        assertThat(response).hasContentType("text/html");
    }

    @Test
    public void hasNotEmptyBodyResponse() {
        homeController.getHomePage(request, response);
        assertThat(response).hasBodyText(Matchers.not(Matchers.isEmptyOrNullString()));
    }

}
