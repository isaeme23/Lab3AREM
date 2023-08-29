package films.controller;

import films.inter.Mediatory;
import films.inter.MovieResponse;
import films.inter.impl.ImageMediatory;
import films.inter.impl.TextMediatory;
import films.service.AREMflixService;

import java.net.*;
import java.io.*;
import org.json.*;

/**
 * Clase que funciona como servidor HTTP
 * @author Isabella Manrique
 * @version 22/08/2023/A
 */

public class HttpServer {

    private static Mediatory mediatory;

    /**
     * Metodo principal de la clase
     * @param args Arreglo de argumentos
     * @throws IOException Excepcion de entrada/salida
     */

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;

            boolean firstLine = true;
            String path = null;

            String name = "";

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (firstLine) {
                    firstLine = false;
                    path = inputLine.split(" ")[1];
                }
                if (!in.ready()) {
                    break;
                }
            }

            outputLine = "HTTP/1.1 200 OK \r\n";
            System.out.println("PATH: "+path);
            if (path.contains("?")){
                System.out.println("Path with Query:"+path);
                MovieResponse.getMovie(clientSocket, path);
            } else if (path.endsWith(".html") || path.endsWith(".css") || path.endsWith(".js")) {
                mediatory = new TextMediatory(path, clientSocket);
                mediatory.reply();
            } else if (path.endsWith(".jpeg") || (path.endsWith(".jpg")) || path.endsWith(".gif")){
                mediatory = new ImageMediatory(path, clientSocket);
                mediatory.reply();
            } else {
                System.out.println("Otra extension xd");
            }

            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    } // Cierre del metodo

    /**
     * Metodo usado para devolver un mensaje
     * @param path
     * @return Respuesta de la busqueda
     */

    public static String getMovie(String path) throws IOException {
        String response = "Content-Type: text/json \r\n"
                + "\r\n" + showInfo(path);
        return response;
    } // Cierre del metodo

    public static String showInfo(String path) throws IOException {
        OMDBAPIClient client = OMDBAPIClient.getInstance();
        String info = client.getMovie(path.split("=")[1]);
        JSONObject resp = new JSONObject(info);
        return "<div>"+
                "<h1>" + resp.get("Title") + "</h1>"+
                "<h2>" + resp.get("Year")+ "</h2>"+
                "<img src=\"" + resp.get("Poster") +"\">"+
                "<p>" + resp.get("Director") + "</p>"+
                "<p>" + resp.get("Rated") + "</p>"+
                "<p>" + resp.get("Genre") + "</p>"+
                "<p>" + resp.get("Plot") + "</p>"+
                "</div>\n";
    }

    /**
     * Metodo usado para mostrar en formato http el contenido de la pagina acompañado de scripts para las
     * diferentes funcionalidades del mismo
     * @return Respuesta GET/POST
     */

    public static String getResponse(){
        String response = "Content-Type: text/html \r\n"
                + "\r\n <!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>AREMFLIX</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>AREMFLIX</h1>\n" +
                "        <h2>Best source of movie information</h2>\n" +
                "        <form action=\"/movie\">\n" +
                "            <label for=\"name\">Name:</label><br>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\" value=\"Avengers\"><br><br>\n" +
                "            <input type=\"button\" value=\"Search\" onclick=\"loadGetMsg()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/movie?name=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "    </body>\n" +
                "</html>";
        return response;
    } // Cierre del metodo
} // Cierre de la clase