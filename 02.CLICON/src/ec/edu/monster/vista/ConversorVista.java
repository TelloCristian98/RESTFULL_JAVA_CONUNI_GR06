/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.vista;

import java.io.Console;
import java.util.Scanner;

public class ConversorVista {
    private final Scanner scanner = new Scanner(System.in);

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public String leerClaveConAsteriscos(String mensaje) {
        System.out.print(mensaje);
        StringBuilder clave = new StringBuilder();

        Thread ocultarInput = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.print("\b*");
            }
        });

        ocultarInput.start();

        try {
            while (true) {
                char ch = (char) System.in.read();

                if (ch == '\n' || ch == '\r') {
                    break;
                }

                if (ch == '\b' && clave.length() > 0) {
                    clave.deleteCharAt(clave.length() - 1);
                } else if (ch != '\b') {
                    clave.append(ch);
                }
            }
        } catch (Exception e) {
            System.out.println("\nError al leer la clave.");
        } finally {
            ocultarInput.interrupt();
        }

        System.out.println();
        return clave.toString();
    }

    public double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().replace(",", ".");
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
