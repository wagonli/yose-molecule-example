package yose;

import java.io.File;

/**
 * Created by formation on 06/03/15.
 */
public class StaticPages {

    private static File getPage(String page) {
        return new File("src/main/static/html/" +
                page +
                ".html");
    }
    
    public static File minesweeper() {
        return getPage("MinesweeperPage");
    }

    static File homepage() {
        return getPage("HomePage");
    }

    static File primeFactorsForm() {
        return getPage("PrimeFactorsForm");
    }
}
