package films.controller;

import java.util.HashMap;
import java.util.Map;

public class SparkHandler {

    private static final Map<String, StringService> servicios = new HashMap<>();

    public static StringService buscar(String nombre) {
        return servicios.get(nombre);
    }

    public static void get(String str, StringService service){
        servicios.put(str, service);
    }
}
