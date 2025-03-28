
package AbstractAdapter;

import java.util.Random;

public class CalculadoraAmor {
    public static String calcularCompatibilidad(String nombre1, String nombre2) {
        int compatibilidad = new Random().nextInt(101);
        return nombre1 + " + " + nombre2 + " \n" +
               compatibilidad + "% de compatibilidad \n" +
               (compatibilidad > 70 ? "¡Deberían estar juntos por siempre! " :
                compatibilidad > 40 ? "Tienen una buena conexión, sigan conociéndose " :
                                      "Mmm... no hay mucha chispa, pero quién sabe ");
    }
}
