/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.pruebas;

/**
 *
 * @author Juanr
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PruebaConectividad {

    private static final String BASE_URL = "http://localhost:8080/WS_ConversionUnidades_REST/webresources/conversion"; // Cambia el puerto y contexto si es necesario.

    // Método para realizar login
    public static boolean login(String usuario, String clave) throws Exception {
        String endpoint = BASE_URL + "/login/" + usuario + "/" + clave;
        String response = sendGetRequest(endpoint);
        return Boolean.parseBoolean(response);
    }

    // Método para convertir pulgadas a centímetros
    public static double pulgadasACentimetros(double pulgadas) throws Exception {
        String endpoint = BASE_URL + "/pulgadas-a-cm/" + pulgadas;
        String response = sendGetRequest(endpoint);
        return Double.parseDouble(response);
    }

    // Método para convertir centímetros a pulgadas
    public static double centimetrosAPulgadas(double cm) throws Exception {
        String endpoint = BASE_URL + "/cm-a-pulgadas/" + cm;
        String response = sendGetRequest(endpoint);
        return Double.parseDouble(response);
    }

    // Método genérico para enviar solicitudes GET
    private static String sendGetRequest(String endpoint) throws Exception {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Error en la solicitud HTTP: Código " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();
        return response.toString();
    }

    // Método main para pruebas
    public static void main(String[] args) {
        try {
            // Probar el login
            String usuario = "monster";
            String clave = "monster9";
            boolean isAuthenticated = login(usuario, clave);
            System.out.println("Login exitoso: " + isAuthenticated);

            // Probar la conversión de pulgadas a centímetros
            double pulgadas = 1;
            double cm = pulgadasACentimetros(pulgadas);
            System.out.println(pulgadas + " pulgadas son " + cm + " centímetros.");

            // Probar la conversión de centímetros a pulgadas
            double centimetros = 2.54;
            double pulgadasResult = centimetrosAPulgadas(centimetros);
            System.out.println(centimetros + " centímetros son " + pulgadasResult + " pulgadas.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

