/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractAdapter;

import AbstractAdapter.AbstractFactory;

/**
 *
 * @author Estudiantes
 */
public class FactoryCon implements AbstractFactory {

    @Override
    public Entrada crearEntrada() {
        return new EntradaCon();
    }

    @Override
    public Salida crearSalida() {
        return new SalidaCon();
    }
    
}
