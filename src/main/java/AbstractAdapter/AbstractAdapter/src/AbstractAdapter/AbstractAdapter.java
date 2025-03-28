package AbstractAdapter;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/** 
 * Autores: 
 * 
 * 
 * **/
public class AbstractAdapter {
    public static void main(String[] args) {
        
        JFrame parentFrame = new JFrame();
        parentFrame.setAlwaysOnTop(true);
        
        int opcion = obtenerOpcion(parentFrame);
        
        AbstractFactory fabrica = (opcion == 1) ? new FabricaCON() : new FabricaJOP();
        Entrada entrada = fabrica.crearEntrada();
        Salida salida = fabrica.crearSalida();

        
        String nombre1 = obtenerNombre(entrada, salida, "💌 Ingresa el primer nombre:", parentFrame);
        String nombre2 = obtenerNombre(entrada, salida, "💌 Ingresa el segundo nombre:", parentFrame);

        if (nombre1 != null && nombre2 != null) {
            String resultado = CalculadoraAmor.calcularCompatibilidad(nombre1, nombre2);
            salida.mostrarSalida(resultado);
        }
        
        parentFrame.dispose(); 
    }

    private static int obtenerOpcion(JFrame parentFrame) {
        Object[] opciones = {"Consola (1)", "Interfaz Gráfica (2)"};
        return JOptionPane.showOptionDialog(parentFrame,
            "Seleccione el tipo de entrada y salida:",
            "💖 Calculadora del Amor 💖",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[1]) + 1;
    }

    private static String obtenerNombre(Entrada entrada, Salida salida, String mensaje, JFrame parentFrame) {
        while (true) {
            String nombre = entrada.pedirEntrada(mensaje);
            
            // Forzar el foco en la ventana
            if (parentFrame != null) {
                parentFrame.toFront();
                parentFrame.requestFocus();
            }
            
            if (nombre == null) {
                salida.mostrarSalida("Operación cancelada ❌");
                return null;
            }
            if (!nombre.trim().isEmpty()) {
                return nombre.trim();
            }
            salida.mostrarSalida("⚠️ El nombre no puede estar vacío. Inténtalo de nuevo.");
        }
    }



    private static int obtenerOpcion(Scanner scanner) {
        int opcion = 0;
        while (true) {
            try {
                System.out.println("Seleccione el tipo de entrada y salida:");
                System.out.println("1. Consola");
                System.out.println("2. Ventana Gráfica (JFrame)");
                System.out.print("👉 Opción: ");
                
                opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 1 || opcion == 2) break;
                System.out.println("⚠️ Opción inválida, intenta de nuevo.\n");

            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Ingresa un número válido (1 o 2). Intenta otra vez.\n");
                scanner.nextLine();
            }
        }
        return opcion;
    }

  
}

