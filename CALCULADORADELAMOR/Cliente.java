import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de entrada y salida:");
        System.out.println("1. Consola");
        System.out.println("2. Ventana Bonita (JFrame)");
        int opcion = scanner.nextInt();

        AbstractFactory fabrica;
        if (opcion == 1) {
            fabrica = new FabricaCON();
        } else {
            fabrica = new FabricaJOP(); 
        }

        Entrada entrada = fabrica.crearEntrada();
        Salida salida = fabrica.crearSalida();

        String nombre1 = entrada.pedirEntrada("💌 Ingresa el primer nombre:");
        String nombre2 = entrada.pedirEntrada("💌 Ingresa el segundo nombre:");

        String resultado = CalculadoraAmor.calcularCompatibilidad(nombre1, nombre2);
     
    }
}
