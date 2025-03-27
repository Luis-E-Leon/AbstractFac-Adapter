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
public class FactoryJOP implements AbstractFactory{

    @Override
    public Entrada crearEntrada() {
        return new EntradaJOP();
    }

    @Override
    public Salida crearSalida() {
        return new SalidaJOP();
    }
    
}
