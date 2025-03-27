/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractAdapter;

import java.util.Scanner;

/**
 *
 * @author Estudiantes
 */
public class EntradaCon implements Entrada{

    @Override
    public void PedirEntrada() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print(" Ingrese  ");
    }
    
}
