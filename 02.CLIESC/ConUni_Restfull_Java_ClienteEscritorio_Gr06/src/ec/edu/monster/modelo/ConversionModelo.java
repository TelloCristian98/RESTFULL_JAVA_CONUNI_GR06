package ec.edu.monster.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversionModelo {

    private static String BASE_URL = "http://localhost:8080/RESTFULL_JAVA_GR06/api/";

    public static void setBaseUrl(String url) {
        BASE_URL = url;
    }

    public boolean login(String usuario, String clave) throws Exception {
        String endpoint = BASE_URL + "login";
        String jsonInputString = String.format("{\"usuario\": \"%s\", \"contrasena\": \"%s\"}", usuario, clave);
        System.out.println("Enviando JSON: " + jsonInputString);
        String response = sendPostRequest(endpoint, jsonInputString);
        System.out.println("Respuesta del servidor: " + response);
        return response.contains("Login exitoso");
    }

    public double centimetrosAPulgadas(double cm) throws Exception {
        String endpoint = BASE_URL + "conversion/cmToInches";
        String jsonInputString = "{\"valor\": " + cm + "}";
        System.out.println("Enviando JSON: " + jsonInputString);
        String response = sendPostRequest(endpoint, jsonInputString);
        System.out.println("Respuesta del servidor: " + response);
        if (response.isEmpty() || !response.contains("resultado")) {
            throw new Exception("Respuesta inválida del servidor: " + response);
        }
        // Extraer el número usando regex
        Pattern pattern = Pattern.compile("\"resultado\":\\s*([-+]?[0-9]*\\.?[0-9]+)");
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(1));
        } else {
            throw new Exception("No se pudo extraer el resultado numérico de: " + response);
        }
    }

    public double pulgadasACentimetros(double pulgadas) throws Exception {
        String endpoint = BASE_URL + "conversion/inchesToCm";
        String jsonInputString = "{\"valor\": " + pulgadas + "}";
        System.out.println("Enviando JSON: " + jsonInputString);
        String response = sendPostRequest(endpoint, jsonInputString);
        System.out.println("Respuesta del servidor: " + response);
        if (response.isEmpty() || !response.contains("resultado")) {
            throw new Exception("Respuesta inválida del servidor: " + response);
        }
        // Extraer el número usando regex
        Pattern pattern = Pattern.compile("\"resultado\":\\s*([-+]?[0-9]*\\.?[0-9]+)");
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(1));
        } else {
            throw new Exception("No se pudo extraer el resultado numérico de: " + response);
        }
    }

    private String sendPostRequest(String endpoint, String jsonInputString) throws Exception {
        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Content-Length", String.valueOf(jsonInputString.getBytes("UTF-8").length));
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("UTF-8");
            os.write(input, 0, input.length);
            os.flush();
        }

        int responseCode = conn.getResponseCode();
        System.out.println("Código de respuesta: " + responseCode);
        if (responseCode != 200) {
            StringBuilder errorResponse = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getErrorStream(), "UTF-8"))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    errorResponse.append(responseLine.trim());
                }
            }
            throw new RuntimeException("HTTP Error: " + responseCode + " - " + endpoint + " - Error: " + errorResponse.toString());
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }

        conn.disconnect();
        return response.toString();
    }
}