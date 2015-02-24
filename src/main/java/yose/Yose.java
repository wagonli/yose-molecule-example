package yose;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vtence.molecule.WebServer;
import com.vtence.molecule.routing.DynamicRoutes;

import java.io.IOException;

import static com.vtence.molecule.http.MimeTypes.JSON;

public class Yose {

    private final Gson gson;

    public Yose(Gson gson) {
        this.gson = gson;
    }

    public void start(WebServer server) throws IOException {
        server.start(new DynamicRoutes() {{

            get("/ping").to((request, response) -> response.contentType(JSON).body(gson.toJson(new Pong())));

            get("/").to((request, response) -> response.body("Hello Yose"));

        }});
    }

    public static class Pong {
        public final boolean alive = true;
    }

    private static final int PORT = 0;

    private static int port(String[] args) {
        return args.length > 0 ? Integer.parseInt(args[PORT]) : 8080;
    }

    public static void main(String[] args) throws IOException {
        WebServer server = WebServer.create(port(args));
        Yose yose = new Yose(new GsonBuilder().setPrettyPrinting().create());
        yose.start(server);
        System.out.println("Access at: " + server.uri() + "/ping");
    }
}