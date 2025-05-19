/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.pruebas;
import ec.edu.monster.controlador.ConversorControlador;
import ec.edu.monster.modelo.ConversorModelo;
import ec.edu.monster.vista.ConversorVista;

public class PruebasManualConversor {

    public static void main(String[] args) {
        probarModelo();
        //probarControlador();
    }

    private static void probarModelo() {
        System.out.println("=== PRUEBAS DEL MODELO ===");
        ConversorModelo modelo = new ConversorModelo();

        boolean loginExitoso = modelo.login("monster", "monster9");
        System.out.println("Login exitoso (debería ser true): " + loginExitoso);

        boolean loginFallido = modelo.login("usuario", "claveIncorrecta");
        System.out.println("Login fallido (debería ser false): " + loginFallido);

        double pulgadas = 10.0;
        double cmEsperados = 25.4;
        double cmResultado = modelo.convertirPulgadasACentimetros(pulgadas);
        System.out.println("10 pulgadas a cm (debería ser 25.4): " + cmResultado);

        double centimetros = 25.4;
        double pulgadasEsperadas = 10.0;
        double pulgadasResultado = modelo.convertirCentimetrosAPulgadas(centimetros);
        System.out.println("25.4 cm a pulgadas (debería ser 10.0): " + pulgadasResultado);
    }

    private static void probarControlador() {
        System.out.println("\n=== PRUEBAS DEL CONTROLADOR ===");
        ConversorModelo modelo = new ConversorModelo();
        ConversorVista vista = new ConversorVista();

        ConversorControlador controlador = new ConversorControlador(modelo, vista);

        System.out.println("Por favor, sigue las instrucciones en consola para probar el controlador:");
        controlador.iniciarAplicacion();
    }
}
