import javax.swing.JOptionPane;
public class EntradaJOP extends Entrada {
    @Override
    public String pedirEntrada(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }
}
