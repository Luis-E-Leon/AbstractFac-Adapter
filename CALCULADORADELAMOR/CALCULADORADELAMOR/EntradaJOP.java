import javax.swing.JOptionPane;
// EntradaJOP.java (Entrada por JOptionPane)
public class EntradaJOP extends Entrada {
    @Override
    public String pedirEntrada(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }
}
