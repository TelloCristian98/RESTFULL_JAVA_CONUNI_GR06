/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ws;

import ec.edu.monster.controlador.ConversorControlador;
import ec.edu.monster.modelo.ConversorModelo;
import ec.edu.monster.vista.ConversorVista;

/**
 *
 * @author Juanr
 */
public class WS_ConversionUnidades_RESTFULL_ConsolaCliente {

    public static void main(String[] args) {
        ConversorModelo modelo = new ConversorModelo();
        ConversorVista vista = new ConversorVista();
        ConversorControlador controlador = new ConversorControlador(modelo, vista);

        controlador.iniciarAplicacion();
    }
}
