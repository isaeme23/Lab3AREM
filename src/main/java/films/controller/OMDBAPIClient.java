package films.controller;

import films.persistence.AREMflixPersistence;
import films.service.AREMflixService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Clase para consultar la OMDBAPI
 * @author Isabella Manrique
 * @version 23/08/2023/A
 * @see <a href = "http://www.omdbapi.com" /> omdbapi.com </a>
 */

public class OMDBAPIClient {

    // Variables de la clase
    private static AREMflixService as = new AREMflixService();
    private static final String omdbapiurl = "http://www.omdbapi.com/?apikey=d6f2cc0d";

    /**
     * Metodo que se encargara de traer la informacion de la pelicula consultada si esta almacenada en el cache,
     * es decir que se haya consultado recientemente
     * @return Informacion de la pelicula almacenada en el cache
     */
    public static String getMovie(String movie) throws IOException {
        if (as.storedInCache(movie)){
            return as.getMovie(movie);
        }
        URL urlmovie = new URL(omdbapiurl+"&t="+movie);
        String info = requestGetMovie(urlmovie);
        as.addMovie(movie, info);
        return info;
    }

    /**
     * Metodo que se encarga de hacer la peticion de la pelicula y su informacion a el API OMDBAPI si no se encuentra
     * en el cache
     * @param url a la que se consulta
     * @return Informacion de la pelicula obtenida por la consulta al OMDBAPI
     * @throws IOException
     */

    private static String requestGetMovie(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = connection.getResponseCode();
        System.out.println("codigo: "+responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                System.out.println("Respuesta:" + inputLine);
            }
            in.close();
            return response.toString();
        } else{
            return "GET did not work";
        }
    }
}