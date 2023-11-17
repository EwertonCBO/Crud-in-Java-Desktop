/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.nivelamento;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class Start {
    
    public static void main (String arg[]) {
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com id"));

        String placa = JOptionPane.showInputDialog("Entre com placa");
        String cor = JOptionPane.showInputDialog("Entre com cor");
        int eixos = Integer.parseInt(JOptionPane.showInputDialog("Entre com eixos"));
        int potencia = Integer.parseInt(JOptionPane.showInputDialog("Entre com potencia"));

        Carro c = new Carro(eixos, id, placa, cor, potencia);
        
        Onibus o = new Onibus(eixos, id, placa, cor, potencia);

        List<Veiculo> listaVeiculos = new ArrayList<>();
        
        listaVeiculos.add(c);
        listaVeiculos.add(o);

        for (Veiculo v : listaVeiculos) {
            JOptionPane.showMessageDialog(null,v);
            
        }
        
        
    }
    
}
