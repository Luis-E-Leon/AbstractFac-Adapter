import java.util.Scanner;


// EntradaCON.java (Entrada por consola)
public class EntradaCON extends Entrada {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String pedirEntrada(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }
}