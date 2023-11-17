/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;

import backenddmm20232.controllers.ControllerPessoaFisica;
import backenddmm20232.models.beans.PessoaFisica;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class ManterPessoaFisica {
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

        String nome = JOptionPane.showInputDialog("NOME");
        String cpf = JOptionPane.showInputDialog("CPF");
        String rg = JOptionPane.showInputDialog("RG");
        PessoaFisica pesEnt = new PessoaFisica(nome, cpf, rg);
        ControllerPessoaFisica contPes = new ControllerPessoaFisica();
        PessoaFisica pesSaida = contPes.inserir(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String cpf = JOptionPane.showInputDialog("CPF");
        String rg = JOptionPane.showInputDialog("RG");
        PessoaFisica pesEnt = new PessoaFisica(id,nome, cpf, rg);
        ControllerPessoaFisica contPes = new ControllerPessoaFisica();
        PessoaFisica pesSaida = contPes.alterar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaFisica pesEnt = new PessoaFisica(id);
        ControllerPessoaFisica contPes = new ControllerPessoaFisica();
        PessoaFisica pesSaida = contPes.buscar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaFisica pesEnt = new PessoaFisica(id);
        ControllerPessoaFisica contPes = new ControllerPessoaFisica();
        PessoaFisica pesSaida = contPes.excluir(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        PessoaFisica pesEnt = new PessoaFisica(nome);
        ControllerPessoaFisica contPes = new ControllerPessoaFisica();
        List<PessoaFisica> listaPessoaF = contPes.listar(pesEnt);
        for (PessoaFisica pesSaida : listaPessoaF) {
            JOptionPane.showMessageDialog(null,pesSaida.toString());
        }
    }



    
}
