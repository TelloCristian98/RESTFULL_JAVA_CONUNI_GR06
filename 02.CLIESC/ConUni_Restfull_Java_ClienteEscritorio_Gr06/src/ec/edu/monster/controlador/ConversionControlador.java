package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ConversionModelo;

public class ConversionControlador {

    private final ConversionModelo modelo;

    public ConversionControlador() {
        this.modelo = new ConversionModelo();
    }

    public boolean validarLogin(String usuario, String clave) {
        try {
            return modelo.login(usuario, clave);
        } catch (Exception e) {
            System.err.println("Error al validar login: " + e.getMessage());
            return false;
        }
    }

    public double convertirCmAPulgadas(double cm) {
        try {
            return modelo.centimetrosAPulgadas(cm);
        } catch (Exception e) {
            System.err.println("Error en la conversión: " + e.getMessage());
            return -1;
        }
    }

    public double convertirPulgadasACm(double pulgadas) {
        try {
            return modelo.pulgadasACentimetros(pulgadas);
        } catch (Exception e) {
            System.err.println("Error en la conversión: " + e.getMessage());
            return -1;
        }
    }
}