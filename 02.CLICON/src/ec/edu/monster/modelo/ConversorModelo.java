/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorModelo {
    private static final String BASE_URL = "http://localhost:8080/WS_ConversionUnidades_REST/webresources/conversion";

    public boolean login(String usuario, String clave) {
        try {
            URL url = new URL(BASE_URL + "/login/" + usuario + "/" + clave);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                Scanner responseScanner = new Scanner(conn.getInputStream());
                boolean resultado = Boolean.parseBoolean(responseScanner.nextLine());
                responseScanner.close();
                return resultado;
            }
        } catch (Exception e) {
            System.out.println("Error al intentar iniciar sesión: " + e.getMessage());
        }
        return false;
    }

    public double convertirPulgadasACentimetros(double pulgadas) {
        try {
            URL url = new URL(BASE_URL + "/pulgadas-a-cm/" + pulgadas);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                Scanner responseScanner = new Scanner(conn.getInputStream());
                double resultado = Double.parseDouble(responseScanner.nextLine());
                responseScanner.close();
                return resultado;
            }
        } catch (Exception e) {
            System.out.println("Error al convertir pulgadas a centímetros: " + e.getMessage());
        }
        return 0.0;
    }

    public double convertirCentimetrosAPulgadas(double cm) {
        try {
            URL url = new URL(BASE_URL + "/cm-a-pulgadas/" + cm);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                Scanner responseScanner = new Scanner(conn.getInputStream());
                double resultado = Double.parseDouble(responseScanner.nextLine());
                responseScanner.close();
                return resultado;
            }
        } catch (Exception e) {
            System.out.println("Error al convertir centímetros a pulgadas: " + e.getMessage());
        }
        return 0.0;
    }
}

