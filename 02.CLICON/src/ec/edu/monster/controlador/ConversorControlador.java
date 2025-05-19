/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ConversorModelo;
import ec.edu.monster.vista.ConversorVista;

public class ConversorControlador {
    private final ConversorModelo modelo;
    private final ConversorVista vista;

    public ConversorControlador(ConversorModelo modelo, ConversorVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarAplicacion() {
        boolean loggedIn = false;

        while (!loggedIn) {
            String usuario = vista.leerTexto("Ingrese usuario: ");
            String clave = vista.leerClaveConAsteriscos("Ingrese clave: ");
            loggedIn = modelo.login(usuario, clave);

            if (!loggedIn) {
                vista.mostrarMensaje("Credenciales incorrectas. Intente de nuevo.");
            }
        }

        vista.mostrarMensaje("Inicio de sesión exitoso. Bienvenido al conversor de unidades.");
        mostrarMenu();
    }

    private void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            vista.mostrarMensaje("\nMenú:");
            vista.mostrarMensaje("1. Convertir pulgadas a centímetros");
            vista.mostrarMensaje("2. Convertir centímetros a pulgadas");
            vista.mostrarMensaje("3. Salir");

            int opcion = (int) vista.leerDecimal("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    double pulgadas = vista.leerDecimal("Ingrese el valor en pulgadas: ");
                    double resultadoCm = modelo.convertirPulgadasACentimetros(pulgadas);
                    vista.mostrarMensaje(pulgadas + " pulgadas equivalen a " + resultadoCm + " centímetros.");
                    break;
                case 2:
                    double cm = vista.leerDecimal("Ingrese el valor en centímetros: ");
                    double resultadoPulgadas = modelo.convertirCentimetrosAPulgadas(cm);
                    vista.mostrarMensaje(cm + " centímetros equivalen a " + resultadoPulgadas + " pulgadas.");
                    break;
                case 3:
                    vista.mostrarMensaje("Saliendo del sistema. ¡Adiós!");
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

