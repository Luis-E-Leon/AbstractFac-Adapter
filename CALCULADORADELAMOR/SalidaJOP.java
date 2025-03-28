import javax.swing.SwingUtilities;

public class SalidaJOP extends Salida {
    @Override
    public void mostrarSalida(String mensaje) {
        String[] partes = mensaje.split(" ❤️");  
        String nombres = partes[0]; 

        SwingUtilities.invokeLater(() -> {
            String[] nombresSeparados = nombres.split(" \\+ ");
            String nombre1 = nombresSeparados[0].trim();
            String nombre2 = nombresSeparados[1].trim();

            new CalculadoraAmorFrame(nombre1, nombre2).setVisible(true);
        });
    }
}
