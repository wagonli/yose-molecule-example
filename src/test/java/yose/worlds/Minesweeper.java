package yose.worlds;

import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yose.YoseDriver;

import java.io.IOException;

import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;

public class Minesweeper {

    YoseDriver yose = new YoseDriver(9999);

    HttpRequest request = new HttpRequest(9999);
    HttpResponse response;

    @Before
    public void startGame() throws Exception {
        yose.start();
    }

    @After
    public void stopGame() throws Exception {
        yose.stop();
    }

    @Test
    public void seesMinesweeperBoard() throws IOException {
        yose.minesweeper()
                .hasTitle("Minesweeper")
                .hasBoard(8, 8);
    }

    @Test
    public void doesNotSeeAnyMineInitially() throws IOException {
        yose.minesweeper()
                .seesNoMine(3, 6);
    }

    @Test
    public void losesWhenRevealingTrappedCell() throws IOException {
        yose.minesweeper()
                .revealCell(3, 6)
                .seesMine(3, 6);
    }

    @Test
    public void doesNotLoseWhenRevealingSafeCell() throws IOException {
        yose.minesweeper()
                .revealCell(2, 5)
                .seesNoMine(2, 5)
                .seesNoMine(3, 6);
    }

}
