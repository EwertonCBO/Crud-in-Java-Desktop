/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;

import backenddmm20232.controllers.ControllerMusica;
import backenddmm20232.models.beans.Musica;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterMusica {
    
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
        int id_artista = Integer.parseInt(JOptionPane.showInputDialog("ID artista"));
        int id_genero = Integer.parseInt(JOptionPane.showInputDialog("ID genero"));
        int num_faixa = Integer.parseInt(JOptionPane.showInputDialog("número faixa"));
        String duracao = JOptionPane.showInputDialog("duração");
        String titulo = JOptionPane.showInputDialog("título");
        Musica musEnt = new Musica (id_artista, id_genero, num_faixa, duracao, titulo ); 
        ControllerMusica contMus = new ControllerMusica();
        Musica musSaida = contMus.inserir(musEnt);
        JOptionPane.showMessageDialog(null,musSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int id_artista = Integer.parseInt(JOptionPane.showInputDialog("ID artista"));
        int id_genero = Integer.parseInt(JOptionPane.showInputDialog("ID genero"));
        int num_faixa = Integer.parseInt(JOptionPane.showInputDialog("número faixa"));
        String duracao = JOptionPane.showInputDialog("duração");
        String titulo = JOptionPane.showInputDialog("título");
        Musica musEnt = new Musica(id, id_artista, id_genero, num_faixa, duracao, titulo);
        ControllerMusica contMus = new ControllerMusica();
        Musica musSaida = contMus.alterar(musEnt);
        JOptionPane.showMessageDialog(null,musSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Musica musEnt = new Musica(id);
        ControllerMusica contMus = new ControllerMusica();
        Musica musSaida = contMus.buscar(musEnt);
        JOptionPane.showMessageDialog(null,musSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Musica musEnt = new Musica(id);
        ControllerMusica contMus = new ControllerMusica();
        Musica musSaida = contMus.excluir(musEnt);
        JOptionPane.showMessageDialog(null,musSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String titulo = JOptionPane.showInputDialog("título da música");
        Musica musEnt = new Musica(titulo);
        ControllerMusica contMus = new ControllerMusica();
        List<Musica> listaMusica = contMus.listar(musEnt);
        for (Musica musSaida : listaMusica) {
            JOptionPane.showMessageDialog(null,musSaida.toString());
        }
    }


}

