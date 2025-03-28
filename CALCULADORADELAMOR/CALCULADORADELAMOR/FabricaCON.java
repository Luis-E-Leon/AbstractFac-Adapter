
public class FabricaCON implements AbstractFactory {
    @Override
    public Entrada crearEntrada() {
        return new EntradaCON();
    }

    @Override
    public Salida crearSalida() {
        return new SalidaCON();
    }
}