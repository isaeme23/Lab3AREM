package films.inter;

import java.io.IOException;


/**
 *  Interfaz que servira para dar respuesta a archivo sde texto e imagenes siendo implementada
 * @author isaeme23
 * @version 26/08/2023/A
 */
public interface Mediatory {

    /**
     * Metodo de respuesta dependiendo del tipo de archivo
     * @throws IOException Excepcion de entrada/salida
     */
    void reply() throws IOException;

    /**
     * Metodo que nos indica el tipo de archivo
     * @return Extension del archivo
     */
    String typeFile();
}
