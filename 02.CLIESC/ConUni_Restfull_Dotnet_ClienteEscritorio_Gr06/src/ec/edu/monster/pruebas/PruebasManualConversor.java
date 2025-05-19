package ec.edu.monster.pruebas;

import ec.edu.monster.controlador.ConversionControlador;
import ec.edu.monster.vista.LoginVista;

public class PruebasManualConversor {

    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE ConversionControlador ===");

        ConversionControlador controlador = new ConversionControlador();

        // Prueba de login
        String usuarioCorrecto = "monster";
        String claveCorrecta = "monster";
        boolean loginExitoso = controlador.validarLogin(usuarioCorrecto, claveCorrecta);
        System.out.println("Login exitoso (debería ser true): " + loginExitoso);

        String usuarioIncorrecto = "usuario";
        String claveIncorrecta = "clave";
        boolean loginFallido = controlador.validarLogin(usuarioIncorrecto, claveIncorrecta);
        System.out.println("Login fallido (debería ser false): " + loginFallido);

        // Prueba de conversiones
        double cm = 25.4;
        double pulgadasEsperadas = 10.0;
        double resultadoPulgadas = controlador.convertirCmAPulgadas(cm);
        System.out.println("25.4 cm a pulgadas (debería ser 10.0): " + resultadoPulgadas);

        double pulgadas = 10.0;
        double cmEsperados = 25.4;
        double resultadoCm = controlador.convertirPulgadasACm(pulgadas);
        System.out.println("10 pulgadas a cm (debería ser 25.4): " + resultadoCm);

        // Iniciar la interfaz gráfica después de las pruebas
        java.awt.EventQueue.invokeLater(() -> {
            new LoginVista().setVisible(true);
        });
    }
}