package films.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase para consultar la OMDBAPI
 * @author Isabella Manrique
 * @version 22/08/2023/A
 * @see <a href = "http://www.omdbapi.com" /> omdbapi.com </a>
 */

public class OMDBAPIClient {

    /**
     * Metodo main de la clase
     * @param args Arreglo de argumentos
     * @throws IOException Excepcion de entrada/salida
     */
    public static void main(String[] args) throws IOException {
        String apiKey = "d6f2cc0d";
        String baseUrl = "http://www.omdbapi.com/";
        String movieTitle = "Avengers";  // Título de la película

        String urlString = baseUrl + "?apikey=" + apiKey + "&t=" + movieTitle;

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                System.out.println("Respuesta:"+inputLine);
            }

            in.close();

            String jsonResponse = response.toString();
            System.out.println(jsonResponse);
        } else {
            System.out.println("Error en la solicitud. Código de respuesta: " + responseCode);
        }

        connection.disconnect();
    }
}