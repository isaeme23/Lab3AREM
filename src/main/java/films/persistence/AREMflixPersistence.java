package films.persistence;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Esta clace almacena las consultas recientes de la API para usarse como cache de la aplicacion
 * @author Isabella Manrique
 * @version 20/08/2023/A
 */

public class AREMflixPersistence{

    // Variables de la clase
    private ConcurrentHashMap<String, String> moviesCache = new ConcurrentHashMap<String, String>();

    /**
     * Este metodo recibe el nombre de una pelicula y si esta existe en el cache devuelve su informacion
     * @param movie Nombre de la pelicula
     * @return Informacion y Nombre de la pelicula
     */
    public ArrayList<String> getMovie(String movie){
        ArrayList<String> couple = new ArrayList<String>();
        if (moviesCache.contains(movie)){
            String info = moviesCache.get(movie);
            couple.add(movie);
            couple.add(info);
        }
        return couple;
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
