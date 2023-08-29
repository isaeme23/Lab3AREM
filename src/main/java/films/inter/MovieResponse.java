package films.inter;

import films.controller.OMDBAPIClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MovieResponse {

    public static void getMovie(Socket client, String path) throws IOException {
        OMDBAPIClient omdbapi = OMDBAPIClient.getInstance();
        System.out.println("PASA POR GET MOVIE");
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        String movie = path.split("=")[1];
        String outputLine = "HTTP/1.1 200 OK \r\n" +
                "Content-Type: application/json \r\n" +
                "\r\n"+ omdbapi.getMovie(movie);
        out.println(outputLine);
        out.close();
        client.close();
    }
}
