import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CalculadoraAmorFrame extends JFrame {
    public CalculadoraAmorFrame(String nombre1, String nombre2) {
        // Configuración de la ventana
        setTitle("💖 Calculadora del Amor 💖");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Generar porcentaje de compatibilidad
        int compatibilidad = new Random().nextInt(101);
        String mensaje = "<html><div style='text-align: center; font-size: 16px;'>" +
                "<b>" + nombre1 + " + " + nombre2 + "</b> ❤️<br>" +
                "<b>" + compatibilidad + "% de compatibilidad 💕</b><br><br>" +
                (compatibilidad > 70 ? "¡Deberían estar juntos por siempre! 💍" :
                        compatibilidad > 40 ? "Tienen una buena conexión, sigan conociéndose " :
                                "Mmm... no hay mucha chispa, pero quién sabe ") +
                "</div></html>";

        // Crear etiqueta con el mensaje
        JLabel etiqueta = new JLabel(mensaje);
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);

        // Panel personalizado con fondo degradado
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color colorInicio = new Color(255, 105, 180); // Rosa fuerte
                Color colorFinal = new Color(255, 182, 193); // Rosa claro
                GradientPaint gp = new GradientPaint(0, 0, colorInicio, getWidth(), getHeight(), colorFinal);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());
        panel.add(etiqueta, BorderLayout.CENTER);

        // Agregar imagen de corazón
        JLabel icono = new JLabel(new ImageIcon("corazon.png"));
        icono.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(icono, BorderLayout.NORTH);

        // Agregar el panel al frame
        add(panel);
    }

    public static void main(String[] args) {
        // Pedir nombres con JOptionPane
        String nombre1 = JOptionPane.showInputDialog("💌 Ingresa el primer nombre:");
        String nombre2 = JOptionPane.showInputDialog("💌 Ingresa el segundo nombre:");

        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            new CalculadoraAmorFrame(nombre1, nombre2).setVisible(true);
        });
    }
}
