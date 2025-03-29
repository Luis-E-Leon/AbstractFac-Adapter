package AbstractAdapter;

import javax.swing.JOptionPane;
public class EntradaJOP extends Entrada {
     @Override
    public String pedirEntrada(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje, "💖 Calculadora del Amor 💖", JOptionPane.QUESTION_MESSAGE);
    }

	
}
