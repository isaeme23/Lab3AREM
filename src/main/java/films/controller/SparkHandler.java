package films.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que almacena lso servicios creados a partir de funciones lambda
 * @author Isabella Manrique
 * @version 5/09/2023/A
 */
public class SparkHandler {

    // Variable de la clase usada para almacenar los servicios
    private static final Map<String, StringService> servicios = new HashMap<>();

    /**
     * Metodo usado para buscar servicios creados
     * @param nombre Nombre del servicio a buscar
     * @return Interfaz funcional del servicio
     */
    public static StringService buscar(String nombre) {
        return servicios.get(nombre);
    } // Cierre del metodo

    /**
     * Metodo usado para crrear servicios a partir de funciones lambda
     * @param str Nombre del servicio a crear
     * @param service Interfaz funcional del servicio
     */
    public static void get(String str, StringService service){
        servicios.put(str, service);
    } // Cierre del metodo
} // Cierre de la clase
