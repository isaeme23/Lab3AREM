package films.persistence;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Esta clace almacena las consultas recientes de la API para usarse como cache de la aplicacion
 * @author Isabella Manrique
 * @version 23/08/2023/A
 */

public class AREMflixPersistence{

    // Variables de la clase
    private ConcurrentHashMap<String, String> moviesCache;
    private static AREMflixPersistence instance = null;

    /**
     * Constructor de la clase AREMflixPersistence
     */
    public AREMflixPersistence(){
        moviesCache = new ConcurrentHashMap<String, String>();
    } // Cierre del metodo

    /**
     * Metodo que nos ayuda a implementar el patron Singleton para que no existan mas de una instancia de la clase
     * AREMFlixPersistence
     * @return Instancia de la clase
     */
    public static AREMflixPersistence getInstance(){
        if (instance == null){
            instance = new AREMflixPersistence();
        }
        return instance;
    } // Cierre del metodo

    /**
     * Este metodo recibe el nombre de una pelicula y si esta existe en el cache devuelve su informacion
     * @param movie Nombre de la pelicula
     * @return Informacion de la pelicula
     */
    public boolean movieStoredCache(String movie){
        return moviesCache.contains(movie);
    } // Cierre del metodo

    /**
     * Este metodo verifica si la pelicula se encuentra en el cache
     * @param movie Nombre de la pelicula a consultar
     * @return Booleano que indica si ya se ha consultado antes
     */
    public String getMovie(String movie){
        return moviesCache.get(movie);
    } // Cierre del metodo

    /**
     * Este metodo agrega una pelicula y su informacion al cache
     * @param movie Nombre de la pelicula
     * @param info Informacion de la pelicula
     */

    public void addMovie(String movie, String info){
        moviesCache.put(movie, info);
    } // Cierre del metodo
} // Cierre de la clase
