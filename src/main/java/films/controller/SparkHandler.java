package films.controller;

import java.util.HashMap;
import java.util.Map;

public class SparkHandler {

    static Map<String, StringService> servicios = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("spark");
    }


    public static void get(String parm, StringService stringService){
        servicios.put(parm, stringService);
    }

    public static StringService buscar(String nombre){
        return servicios.get(nombre);
    }
}
