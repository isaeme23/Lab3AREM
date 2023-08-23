package films.service;

import films.persistence.AREMflixPersistence;

import java.util.ArrayList;

/**
 * Clase servicio de la API
 * @author Isabella Manrique
 * @version 23/08/2023/A
 */
public class AREMflixService {

    // Variables de la clase
    private static AREMflixPersistence ap;
    private static AREMflixService instance = null;

    /**
     * Constructor de la clase AREMflixService
     */
    public AREMflixService(AREMflixPersistence ap){
        AREMflixService.ap = ap;
    }

    public static AREMflixService getInstance(){
        if (instance == null){
            instance = new AREMflixService(AREMflixPersistence.getInstance());
        }
        return instance;
    }

    /**
     * Metodo que se encarga de buscar una pelicula en la memoria cache (persistencia)
     * @param movie Nombre de la pelicula
     * @return Nombre de la pelicula e Informacion en un arreglo
     */
    public String getMovie(String movie){
        return ap.getMovie(movie);
    } // Cierre del metodo

    /**
     * Metodo que verifica si la pelicula a consultar se encuentra en el cache
     * @param movie Nombre de la pelicula
     * @return Booleano que indica si se encuentra en el cache
     */
    public boolean storedInCache(String movie){
        return ap.movieStoredCache(movie);
    }

    /**
     * Metodo que se encarga de enviar una pelicula a la memoria cache (persistencia)
     * @param movie Nombre de la pelicula
     * @param info Informacion de la pelicula
     */
    public void addMovie(String movie, String info){
        ap.addMovie(movie, info);
    } // Cierre del metodo
} // Cierre de la clase