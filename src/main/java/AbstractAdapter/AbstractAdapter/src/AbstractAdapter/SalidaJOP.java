
package AbstractAdapter;

import javax.swing.*;

public class SalidaJOP extends Salida {
    @Override
    public void mostrarSalida(String mensaje) {
        SwingUtilities.invokeLater(() -> {
            
            if (mensaje.startsWith("⚠️") || mensaje.contains("❌")) {
                JOptionPane.showMessageDialog(
                    null, 
                    mensaje, 
                    "💖 Calculadora del Amor 💖", 
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

         
            try {
                String[] lineas = mensaje.split("\n");
                String[] nombres = lineas[0].split(" \\+ ");
                int porcentaje = Integer.parseInt(lineas[1].replaceAll("[^0-9]", ""));
                
                new CalculadoraAmorFrame(
                    nombres[0].trim(), 
                    nombres[1].trim(), 
                    porcentaje
                );
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    null, 
                    "Error al procesar resultados: " + e.getMessage(), 
                    "❌ Error", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }
}