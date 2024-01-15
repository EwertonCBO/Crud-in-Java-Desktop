/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;

import backenddmm20232.controllers.ControllerMusicaGeneroMusical;
import backenddmm20232.models.beans.MusicaGeneroMusical;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class ManterMusicaGeneroMusical {
    
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
        int idMusi = Integer.parseInt(JOptionPane.showInputDialog("ID_MUSICA"));
        int idGen = Integer.parseInt(JOptionPane.showInputDialog("ID_GENERO"));
        String titulo = JOptionPane.showInputDialog("TITULO");
        String genero = JOptionPane.showInputDialog("GENERO");
        MusicaGeneroMusical musiGenEnt = new MusicaGeneroMusical(idMusi, idGen, titulo, genero);
        ControllerMusicaGeneroMusical contGenPes = new ControllerMusicaGeneroMusical();
        MusicaGeneroMusical musiGenSaida = contGenPes.inserir(musiGenEnt);
        JOptionPane.showMessageDialog(null,musiGenSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idMusi = Integer.parseInt(JOptionPane.showInputDialog("ID_USUARIO"));
        int idGen = Integer.parseInt(JOptionPane.showInputDialog("ID_SISTEMA"));
        String titulo = JOptionPane.showInputDialog("TITULO");
        String genero = JOptionPane.showInputDialog("GENERO");
        MusicaGeneroMusical musiGenEnt = new MusicaGeneroMusical(id,idMusi, idGen, titulo, genero);
        ControllerMusicaGeneroMusical contGenPes = new ControllerMusicaGeneroMusical();
        MusicaGeneroMusical musiGenSaida = contGenPes.alterar(musiGenEnt);
        JOptionPane.showMessageDialog(null,musiGenSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        MusicaGeneroMusical musiGenEnt = new MusicaGeneroMusical(id);
        ControllerMusicaGeneroMusical contGenPes = new ControllerMusicaGeneroMusical();
        MusicaGeneroMusical musiGenSaida = contGenPes.buscar(musiGenEnt);
        JOptionPane.showMessageDialog(null,musiGenSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        MusicaGeneroMusical musiGenEnt = new MusicaGeneroMusical(id);
        ControllerMusicaGeneroMusical contGenPes = new ControllerMusicaGeneroMusical();
        MusicaGeneroMusical musiGenSaida = contGenPes.excluir(musiGenEnt);
        JOptionPane.showMessageDialog(null,musiGenSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String gen = JOptionPane.showInputDialog("GENERO");
        MusicaGeneroMusical musiGenEnt = new MusicaGeneroMusical(gen);
        ControllerMusicaGeneroMusical contGenPes = new ControllerMusicaGeneroMusical();
        List<MusicaGeneroMusical> listaMusicaGeneroMusical = contGenPes.listar(musiGenEnt);
        for (MusicaGeneroMusical musiGenSaida : listaMusicaGeneroMusical) {
            JOptionPane.showMessageDialog(null,musiGenSaida.toString());
            JOptionPane.showMessageDialog(null,musiGenSaida.getMusi().toString());
            JOptionPane.showMessageDialog(null,musiGenSaida.getGen().toString());
        }
    }
}
