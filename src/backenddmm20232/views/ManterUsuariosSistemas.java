/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;

import backenddmm20232.controllers.ControllerUsuariosSistemas;
import backenddmm20232.models.beans.UsuariosSistemas;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class ManterUsuariosSistemas {
    
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
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ID_USUARIO"));
        int idSis = Integer.parseInt(JOptionPane.showInputDialog("ID_SISTEMA"));
        String tipo = JOptionPane.showInputDialog("TIPO");
        String status = JOptionPane.showInputDialog("STATUS");
        String obs = JOptionPane.showInputDialog("OBS");
        UsuariosSistemas usuSisEnt = new UsuariosSistemas(idUsu, idSis, tipo, status, obs);
        ControllerUsuariosSistemas contSisPes = new ControllerUsuariosSistemas();
        UsuariosSistemas usuSisSaida = contSisPes.inserir(usuSisEnt);
        JOptionPane.showMessageDialog(null,usuSisSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ID_USUARIO"));
        int idSis = Integer.parseInt(JOptionPane.showInputDialog("ID_SISTEMA"));
        String tipo = JOptionPane.showInputDialog("TIPO");
        String status = JOptionPane.showInputDialog("STATUS");
        String obs = JOptionPane.showInputDialog("OBS");
        UsuariosSistemas usuSisEnt = new UsuariosSistemas(id,idUsu, idSis, tipo, status, obs);
        ControllerUsuariosSistemas contSisPes = new ControllerUsuariosSistemas();
        UsuariosSistemas usuSisSaida = contSisPes.alterar(usuSisEnt);
        JOptionPane.showMessageDialog(null,usuSisSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuariosSistemas usuSisEnt = new UsuariosSistemas(id);
        ControllerUsuariosSistemas contSisPes = new ControllerUsuariosSistemas();
        UsuariosSistemas usuSisSaida = contSisPes.buscar(usuSisEnt);
        JOptionPane.showMessageDialog(null,usuSisSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuariosSistemas usuSisEnt = new UsuariosSistemas(id);
        ControllerUsuariosSistemas contSisPes = new ControllerUsuariosSistemas();
        UsuariosSistemas usuSisSaida = contSisPes.excluir(usuSisEnt);
        JOptionPane.showMessageDialog(null,usuSisSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        UsuariosSistemas usuSisEnt = new UsuariosSistemas(obs);
        ControllerUsuariosSistemas contSisPes = new ControllerUsuariosSistemas();
        List<UsuariosSistemas> listaUsuariosSistemas = contSisPes.listar(usuSisEnt);
        for (UsuariosSistemas usuSisSaida : listaUsuariosSistemas) {
            JOptionPane.showMessageDialog(null,usuSisSaida.toString());
            JOptionPane.showMessageDialog(null,usuSisSaida.getUsu().toString());
            JOptionPane.showMessageDialog(null,usuSisSaida.getSis().toString());
        }
    }
}
