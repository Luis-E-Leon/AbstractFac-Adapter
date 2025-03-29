package AbstractAdapter;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Adapter implements Cliente {

    @Override
    public void ejecutar() {
        JFrame parentFrame = new JFrame();
        parentFrame.setAlwaysOnTop(true);

        int opcion = obtenerOpcion(parentFrame);
        AbstractFactory fabrica = (opcion == 1) ? new FabricaCON() : new FabricaJOP();
        Entrada entrada = fabrica.crearEntrada();
        Salida salida = fabrica.crearSalida();

        int tipoCompatibilidad = obtenerTipoCompatibilidad(parentFrame);
        String dato1, dato2;

        if (tipoCompatibilidad == 1) {
            dato1 = obtenerNombreOCodigo(entrada, salida, "💌 Ingresa el primer nombre o código:", parentFrame);
            dato2 = obtenerNombreOCodigo(entrada, salida, "💌 Ingresa el segundo nombre o código:", parentFrame);
        } else {
            dato1 = obtenerCodigoComoString(entrada, salida, "🔢 Ingresa el primer código:", parentFrame);
            dato2 = obtenerCodigoComoString(entrada, salida, "🔢 Ingresa el segundo código:", parentFrame);
        }

        if (dato1 != null && dato2 != null) {
            String resultado = CalculadoraAmor.calcularCompatibilidad(dato1, dato2);
            salida.mostrarSalida(resultado);
        }

        parentFrame.dispose();
    }

    private int obtenerOpcion(JFrame parentFrame) {
        Object[] opciones = {"Consola (1)", "Interfaz Gráfica (2)"};
        return JOptionPane.showOptionDialog(parentFrame,
            "Seleccione el tipo de entrada y salida:",
            "💖 TINDER UD 💖",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[1]) + 1;
    }

    private int obtenerTipoCompatibilidad(JFrame parentFrame) {
        Object[] opciones = {"Por Nombres (1)", "Por Código (2)"};
        return JOptionPane.showOptionDialog(parentFrame,
            "Seleccione el tipo de compatibilidad:",
            "💖 TINDER UD 💖",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]) + 1;
    }

    private String obtenerNombreOCodigo(Entrada entrada, Salida salida, String mensaje, JFrame parentFrame) {
        String input = entrada.pedirEntrada(mensaje);
        return (input != null && !input.trim().isEmpty()) ? input : obtenerNombreOCodigo(entrada, salida, mensaje, parentFrame);
    }

    private String obtenerCodigoComoString(Entrada entrada, Salida salida, String mensaje, JFrame parentFrame) {
        String codigoStr = null;
        while (codigoStr == null) {
            try {
                String input = entrada.pedirEntrada(mensaje);
                if (input.matches("\\d+")) {  // Solo acepta números
                    codigoStr = input;
                } else {
                    salida.mostrarSalida("⚠️ Error: Ingresa solo números.");
                }
            } catch (Exception e) {
                salida.mostrarSalida("⚠️ Error inesperado.");
            }
        }
        return codigoStr;
    }

    public static class EnteroAStringAdapter {
        public static String convertir(long numero) {
            return String.valueOf(numero);
        }
    }
}
