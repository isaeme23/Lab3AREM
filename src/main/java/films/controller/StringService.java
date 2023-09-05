package films.controller;

import java.io.IOException;
import java.net.Socket;

/**
 * Interfaz funcional de los servicios
 * @author Isabella Manrique
 * @version 5/09/2023/A
 */
public interface StringService {

    /**
     * Metodo de respuesta y uso de servicio
     * @param str Nombre del parametro
     * @param client Socket del cliente
     * @throws IOException
     */
    public void response(String str, Socket client) throws IOException;
}
