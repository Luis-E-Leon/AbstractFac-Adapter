
public class FabricaJOP implements AbstractFactory {
    @Override
    public Entrada crearEntrada() {
        return new EntradaJOP();
    }

    @Override
    public Salida crearSalida() {
        return new SalidaJOP();
    }
}