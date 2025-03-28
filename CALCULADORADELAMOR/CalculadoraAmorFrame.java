import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CalculadoraAmorFrame extends JFrame {
    public CalculadoraAmorFrame(String nombre1, String nombre2) {
        setTitle("💖 Calculadora del Amor 💖");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        int compatibilidad = new Random().nextInt(101);
        String mensaje = "<html><div style='text-align: center; font-size: 16px;'>" +
                "<b>" + nombre1 + " + " + nombre2 + "</b> ❤️<br>" +
                "<b>" + compatibilidad + "% de compatibilidad 💕</b><br><br>" +
                (compatibilidad > 70 ? "¡Deberían estar juntos por siempre! 💍" :
                        compatibilidad > 40 ? "Tienen una buena conexión, sigan conociéndose " :
                                "Mmm... no hay mucha chispa, pero quién sabe ") +
                "</div></html>";


        JLabel etiqueta = new JLabel(mensaje);
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

        JLabel icono = new JLabel(new ImageIcon("corazon.png"));
        icono.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(icono, BorderLayout.NORTH);

        add(panel);
    }
}
