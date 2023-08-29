package films.inter.impl;

import films.inter.Mediatory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase que implementa la interface Mediatory que respondera a las peticiones de los archivos de tipo imagen
 * @author isaeme23
 * @version 26/08/2023/A
 */
public class ImageMediatory implements Mediatory {

    // Variables de la clase
    String path;
    Socket client;
    String outputLine = "HTTP/1.1 200 OK \r\n";

    /**
     * Constructor de la clase
     * @param path Direccion del archivo a mostrar
     * @param client Socket cliente que vendra del Http Server
     */
    public ImageMediatory(String path, Socket client){
        this.path = path;
        this.client = client;
    }

    /**
     * Metodo para responder con el contenido del archivo
     * @throws IOException Excepcion de entrada/salida
     */
    @Override
    public void reply() throws IOException {
        String type = typeFile();
        Path p = Paths.get("target/classes/public"+path);
        BufferedImage bImage = ImageIO.read(new File(p.toUri()));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, type, bos );

        OutputStream clientout = client.getOutputStream();
        String contentType = outputLine + "Content-Type: image/"+type+" \r\n" + "\r\n";
        clientout.write(contentType.getBytes());
        clientout.write(bos.toByteArray());
        clientout.close();

        client.close();
    }

    /**
     * Metodo que nos indicara el tipo de archivo
     * @return Extension del archivo
     */
    @Override
    public String typeFile() {
        if (path.contains(".")) {
            return path.split("\\.")[1];
        } else{
            return "";
        }
    }
}
