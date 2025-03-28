package AbstractAdapter;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

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
                String[] lineas = mensaje.trim().split("\n");
                if (lineas.length < 2) {
                    throw new IllegalArgumentException("Formato del mensaje incorrecto");
                }
                
                String[] nombres = lineas[0].split(" \\+ ");
                if (nombres.length < 2) {
                    throw new IllegalArgumentException("Nombres no detectados correctamente");
                }
                
                int porcentaje = Integer.parseInt(lineas[1].replaceAll("[^0-9]", ""));
                
                JFrame frame = new JFrame("💖 Calculadora del Amor 💖");
                frame.setSize(450, 300);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);

                String mensajeHTML = "<html><div style='text-align: center; font-size: 16px;'>" +
                        "<b>" + nombres[0].trim() + " + " + nombres[1].trim() + "</b> ❤️<br>" +
                        "<b>" + porcentaje + "% de compatibilidad 💕</b><br><br>" +
                        (porcentaje > 70 ? "¡Deberían estar juntos por siempre! 💍" :
                                porcentaje > 40 ? "Tienen una buena conexión, sigan conociéndose" :
                                        "Mmm... no hay mucha chispa, pero quién sabe") +
                        "</div></html>";

                JLabel etiqueta = new JLabel(mensajeHTML);
                etiqueta.setForeground(Color.WHITE);
                etiqueta.setHorizontalAlignment(SwingConstants.CENTER);

                JPanel panel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Graphics2D g2d = (Graphics2D) g;
                        Color colorInicio = new Color(255, 105, 180);
                        Color colorFinal = new Color(255, 182, 193);
                        GradientPaint gp = new GradientPaint(0, 0, colorInicio, getWidth(), getHeight(), colorFinal);
                        g2d.setPaint(gp);
                        g2d.fillRect(0, 0, getWidth(), getHeight());
                    }
                };
                panel.setLayout(new BorderLayout());
                panel.add(etiqueta, BorderLayout.CENTER);

                URL urlImagen = getClass().getClassLoader().getResource("resources/corazon.png");
                if (urlImagen != null) {
                    ImageIcon iconoCorazon = new ImageIcon(urlImagen);
                    JLabel icono = new JLabel(iconoCorazon);
                    icono.setHorizontalAlignment(SwingConstants.CENTER);
                    panel.add(icono, BorderLayout.NORTH);
                }

                frame.add(panel);
                frame.setVisible(true);
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
