/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;

import backenddmm20232.controllers.ControllerPlaylist;
import backenddmm20232.models.beans.Playlist;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterPlaylist {
    
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
        
        
        int num_faixa = Integer.parseInt(JOptionPane.showInputDialog("número faixa"));
        String criador = JOptionPane.showInputDialog("criador");
        String nome = JOptionPane.showInputDialog("nome");
        String genero = JOptionPane.showInputDialog("genero");
        Playlist playEnt = new Playlist (num_faixa, nome, genero, criador); 
        ControllerPlaylist contPlay = new ControllerPlaylist();
        Playlist playSaida = contPlay.inserir(playEnt);
        JOptionPane.showMessageDialog(null,playSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int num_faixa = Integer.parseInt(JOptionPane.showInputDialog("número faixa"));
        String criador = JOptionPane.showInputDialog("criador");
        String nome = JOptionPane.showInputDialog("nome");
        String genero = JOptionPane.showInputDialog("genero");
        Playlist playEnt = new Playlist(id, num_faixa, nome, genero, criador);
        ControllerPlaylist contPlay = new ControllerPlaylist();
        Playlist playSaida = contPlay.alterar(playEnt);
        JOptionPane.showMessageDialog(null,playSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Playlist playEnt = new Playlist(id);
        ControllerPlaylist contPlay = new ControllerPlaylist();
        Playlist playSaida = contPlay.buscar(playEnt);
        JOptionPane.showMessageDialog(null,playSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Playlist playEnt = new Playlist(id);
        ControllerPlaylist contPlay = new ControllerPlaylist();
        Playlist playSaida = contPlay.excluir(playEnt);
        JOptionPane.showMessageDialog(null,playSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String titulo = JOptionPane.showInputDialog("título da  playlist");
        Playlist playEnt = new Playlist(titulo);
        ControllerPlaylist contPlay = new ControllerPlaylist();
        List<Playlist> listaPlaylist = contPlay.listar(playEnt);
        for (Playlist playSaida : listaPlaylist) {
            JOptionPane.showMessageDialog(null,playSaida.toString());
        }
    }


}

