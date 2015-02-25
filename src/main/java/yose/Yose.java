package yose;

import com.google.gson.Gson;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.routing.DynamicRoutes;

import java.io.IOException;
import java.net.URI;

import static com.vtence.molecule.http.MimeTypes.JSON;

public class Yose {

    private final WebServer server;

    public Yose(int port) {
        this.server = WebServer.create(port);
    }

    public void start() throws IOException {
        final Gson gson = new Gson();

        server.start(new DynamicRoutes() {{

            get("/ping").to((request, response) -> response.contentType(JSON).body(gson.toJson(new Pong())));

            get("/").to((request, response) -> response.body("Hello Yose"));

        }});
    }

    public URI uri() {
        return server.uri();
    }

    public void stop() throws IOException {
        server.stop();
    }

    public static class Pong {
        public final boolean alive = true;
    }

    private static final int PORT = 0;

    private static int port(String[] args) {
        return args.length > 0 ? Integer.parseInt(args[PORT]) : 8080;
    }

    public static void main(String[] args) throws IOException {
        Yose yose = new Yose(port(args));
        yose.start();
        System.out.print("To play the game visit " + yose.uri());
    }
}