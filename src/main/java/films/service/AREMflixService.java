package films.service;

import films.persistence.AREMflixPersistence;

import java.util.ArrayList;

/**
 * Clase servicio de la API
 * @author Isabella Manrique
 * @version 20/08/2023/A
 */
public class AREMflixService {

    // Variables de la clase
    private AREMflixPersistence ap;

    /**
     * Metodo que se encarga de buscar una pelicula en la memoria cache (persistencia)
     * @param movie Nombre de la pelicula
     * @return Nombre de la pelicula e Informacion en un arreglo
     */
    public ArrayList<String> getMovie(String movie){
        return ap.getMovie(movie);
    } // Cierre del metodo

    /**
     * Metodo que se encarga de enviar una pelicula a la memoria cache (persistencia)
     * @param movie Nombre de la pelicula
     * @param info Informacion de la pelicula
     */
    public void addMovie(String movie, String info){
        ap.addMovie(movie, info);
    } // Cierre del metodo
} // Cierre de la clase