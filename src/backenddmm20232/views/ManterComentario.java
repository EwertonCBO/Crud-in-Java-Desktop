/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;

import backenddmm20232.controllers.ControllerComentario;
import backenddmm20232.models.beans.Comentario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterComentario {
    
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
        
        
        int idAutor = Integer.parseInt(JOptionPane.showInputDialog("idAutor"));
        int idPost = Integer.parseInt(JOptionPane.showInputDialog("idPost"));
        int avaliacao = Integer.parseInt(JOptionPane.showInputDialog("avaliacao"));
        String descricao = JOptionPane.showInputDialog("descricao");
        String data = JOptionPane.showInputDialog("data");
        Comentario comentEnt = new Comentario (idAutor,idPost,avaliacao,descricao,data); 
        ControllerComentario contComent = new ControllerComentario();
        Comentario ComentSaida = contComent.inserir(comentEnt);
        JOptionPane.showMessageDialog(null,ComentSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idAutor = Integer.parseInt(JOptionPane.showInputDialog("idAutor"));
        int idPost = Integer.parseInt(JOptionPane.showInputDialog("idPost"));
        int avaliacao = Integer.parseInt(JOptionPane.showInputDialog("avaliacao"));
        String descricao = JOptionPane.showInputDialog("descricao");
        String data = JOptionPane.showInputDialog("data");
        Comentario ComentEnt = new Comentario(id, idAutor, idPost, avaliacao, descricao, data);
        ControllerComentario contComent = new ControllerComentario();
        Comentario ComentSaida = contComent.alterar(ComentEnt);
        JOptionPane.showMessageDialog(null,ComentSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Comentario ComentEnt = new Comentario(id);
        ControllerComentario contComent = new ControllerComentario();
        Comentario ComentSaida = contComent.buscar(ComentEnt);
        JOptionPane.showMessageDialog(null,ComentSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Comentario ComentEnt = new Comentario(id);
        ControllerComentario contComent = new ControllerComentario();
        Comentario ComentSaida = contComent.excluir(ComentEnt);
        JOptionPane.showMessageDialog(null,ComentSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String data = JOptionPane.showInputDialog("data");
        Comentario ComentEnt = new Comentario(data);
        ControllerComentario contComent = new ControllerComentario();
        List<Comentario> listaComentario = contComent.listar(ComentEnt);
        for (Comentario ComentSaida : listaComentario) {
            JOptionPane.showMessageDialog(null,ComentSaida.toString());
        }
    }


}

