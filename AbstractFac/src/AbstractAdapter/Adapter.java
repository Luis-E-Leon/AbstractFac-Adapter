package AbstractAdapter;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Adapter implements Cliente{

	@Override
	public void ejecutar() {
        JFrame parentFrame = new JFrame();
        parentFrame.setAlwaysOnTop(true);
        
        int opcion = obtenerOpcion(parentFrame);
        AbstractFactory fabrica = (opcion == 1) ? new FabricaCON() : new FabricaJOP();
        Entrada entrada = fabrica.crearEntrada();
        Salida salida = fabrica.crearSalida();
        
        String nombre1 = obtenerNombreOCodigo(entrada, salida, "💌 Ingresa el primer nombre o código:", parentFrame);
        String nombre2 = obtenerNombreOCodigo(entrada, salida, "💌 Ingresa el segundo nombre o código:", parentFrame);
        
        if (nombre1 != null && nombre2 != null) {
            String resultado = CalculadoraAmor.calcularCompatibilidad(nombre1, nombre2);
            salida.mostrarSalida(resultado);
        }
        
        parentFrame.dispose();
    }
    
    private int obtenerOpcion(JFrame parentFrame) {
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
    
    private String obtenerNombreOCodigo(Entrada entrada, Salida salida, String mensaje, JFrame parentFrame) {
        final String[] input = {null};
        
        JDialog optionDialog = new JDialog(parentFrame, "Selecciona una opción", true);
        optionDialog.setSize(400, 150);
        optionDialog.setLayout(new FlowLayout());
        optionDialog.setLocationRelativeTo(null);
        
        JButton btnNombre = new JButton("Ingresar Nombre");
        JButton btnCodigo = new JButton("Ingresar Código");
        
        btnNombre.addActionListener(e -> {
            input[0] = entrada.pedirEntrada(mensaje);
            optionDialog.dispose();
        });
        
        btnCodigo.addActionListener(e -> {
            String codigoStr = entrada.pedirEntrada("🔢 Ingresa el código numérico:");
            if (codigoStr != null && codigoStr.matches("\\d+")) {
                try {
                    int codigo = Integer.parseInt(codigoStr);
                    input[0] = EnteroAStringAdapter.convertir(codigo);
                    salida.mostrarSalida("🔄 Código convertido a nombre: " + input[0]);
                } catch (NumberFormatException ex) {
                    salida.mostrarSalida("⚠️ Error: Ingresa un número válido.");
                    input[0] = null;
                }
            } else {
                salida.mostrarSalida("⚠️ Error: Ingresa un código numérico válido.");
                input[0] = null;
            }
            optionDialog.dispose();
        });
        
        optionDialog.add(new JLabel("¿Deseas ingresar un nombre o un código?"));
        optionDialog.add(btnNombre);
        optionDialog.add(btnCodigo);
        optionDialog.setVisible(true);
        
        return input[0] != null && !input[0].trim().isEmpty() ? input[0] : obtenerNombreOCodigo(entrada, salida, mensaje, parentFrame);
    }
    
    
}

	
