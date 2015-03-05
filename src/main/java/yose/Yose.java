package yose;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.lib.FileBody;
import com.vtence.molecule.middlewares.FileServer;
import com.vtence.molecule.middlewares.StaticAssets;
import com.vtence.molecule.routing.DynamicRoutes;
import com.vtence.molecule.routing.RouteBuilder;
import com.vtence.molecule.routing.RouteSet;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.PathMatcher;

public class Yose {

    private final WebServer server;

    public Yose(int port) {
        this.server = WebServer.create(port);
    }

    public void start() throws IOException {
        final Gson gson = new Gson();
    
        server.add(new StaticAssets(new FileServer(new File("src/main/static")), "/js", "/css", "/html"));
        server.start(new DynamicRoutes() {{
            get("/").to(new StaticHtmlPageController(new File("src/main/static/html/HomePage.html"))::setupHtmlPage);
            get("/minesweeper").to(new StaticHtmlPageController(new File("src/main/static/html/MinesweeperPage.html"))::setupHtmlPage);
            get("/ping").to(new Ping(gson)::pong);
            get("/primeFactors").to(new PrimeFactors(gson)::decomposition);
            get("/astroport").to(new Astroport()::astroportNameChallenge);
        }});
    }

    public URI uri() {
        return server.uri();
    }

    public void stop() throws IOException {
        server.stop();
    }

    public static Yose launch(String... args) throws IOException {
        Yose yose = new Yose(port(args));
        yose.start();
        return yose;
    }

    private static int port(String[] args) {
        return args.length > 0 ? Integer.parseInt(args[PORT]) : 8080;
    }

    private static final int PORT = 0;

    public static void main(String[] args) throws IOException {
        System.out.print("To play the game visit " + Yose.launch(args).uri());
    }

}