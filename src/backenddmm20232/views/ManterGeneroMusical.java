/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;

import backenddmm20232.controllers.ControllerGeneroMusical;
import backenddmm20232.models.beans.GeneroMusical;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterGeneroMusical {
    
    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

   

    private static void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        GeneroMusical genEnt = new GeneroMusical (nome); 
        ControllerGeneroMusical contGen = new ControllerGeneroMusical();
        GeneroMusical genSaida = contGen.inserir(genEnt);
        JOptionPane.showMessageDialog(null,genSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("Nome");
        GeneroMusical genEnt = new GeneroMusical(id, nome);
        ControllerGeneroMusical contGen = new ControllerGeneroMusical();
        GeneroMusical genSaida = contGen.alterar(genEnt);
        JOptionPane.showMessageDialog(null,genSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        GeneroMusical genEnt = new GeneroMusical(id);
        ControllerGeneroMusical contGen = new ControllerGeneroMusical();
        GeneroMusical genSaida = contGen.buscar(genEnt);
        JOptionPane.showMessageDialog(null,genSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        GeneroMusical genEnt = new GeneroMusical(id);
        ControllerGeneroMusical contGen = new ControllerGeneroMusical();
        GeneroMusical genSaida = contGen.excluir(genEnt);
        JOptionPane.showMessageDialog(null,genSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("nome");
        GeneroMusical genEnt = new GeneroMusical(nome);
        ControllerGeneroMusical contGen = new ControllerGeneroMusical();
        List<GeneroMusical> listaGeneroMusical = contGen.listar(genEnt);
        for (GeneroMusical genSaida : listaGeneroMusical) {
            JOptionPane.showMessageDialog(null,genSaida.toString());
        }
    }


}

