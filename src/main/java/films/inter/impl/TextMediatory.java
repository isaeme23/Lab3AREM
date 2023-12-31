package films.inter.impl;

import films.inter.Mediatory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Clase que implementa la interface Mediatory que respondera a las peticiones de los archivos de texto
 * @author isaeme23
 * @version 26/08/2023/A
 */

public class TextMediatory implements Mediatory {

    // Variables de la clase
    String path;
    Socket client;
    String outputLine = "HTTP/1.1 200 OK \r\n";

    /**
     * Constructor de la clase
     * @param path Direccion del archivo a mostrar
     * @param client Socket cliente que vendra del Http Server
     */
    public TextMediatory(String path, Socket client){
        this.path = path;
        this.client = client;
    } // Cierre del metodo

    /**
     * Metodo para responder con el contenido del archivo
     * @throws IOException Excepcion de entrada/salida
     */

    @Override
    public void reply() throws IOException {
        Path p = Paths.get("target/classes/public"+path);
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        Charset charset = Charset.forName("US-ASCII");
        String line;
        String response = "";
        try (BufferedReader reader = Files.newBufferedReader(p, charset)) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                response += line;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        String type = typeFile();
        if (Objects.equals(type, "js")){
            outputLine += "Content-Type: text/javascript \r\n"
                    + "\r\n";
        } else {
            outputLine += "Content-Type: text/"+type+" \r\n"
                    + "\r\n";
        }

        System.out.println("Tipo!!!!!!1: "+ type);
        outputLine += response;

        out.println(outputLine);
        out.close();
        client.close();
    } // Cierre del metodo

    /**
     * Metodo que nos indicara el tipo de archivo
     * @return Extension del archivo
     */
    @Override
    public String typeFile() {
        return path.split("\\.")[1];
    }
}