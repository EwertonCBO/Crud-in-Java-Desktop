/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;


import backenddmm20232.models.beans.Usuario;
import backenddmm20232.models.beans.Comentario;
import backenddmm20232.models.daos.DaoComentario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ControllerComentario {
    
    DaoComentario daoComent;

  

    public Comentario inserir(Comentario ComentEnt) throws SQLException, ClassNotFoundException {
        daoComent = new DaoComentario();
        return daoComent.inserir(ComentEnt);
    }

    public Comentario alterar(Comentario ComentEnt) throws SQLException, ClassNotFoundException {
        daoComent = new DaoComentario();
        return daoComent.alterar(ComentEnt);
    }

    public Comentario buscar(Comentario coment) throws SQLException, ClassNotFoundException {
        daoComent = new DaoComentario();
        Comentario comentSaida = daoComent.buscar(coment);
        
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuEnt = new Usuario(comentSaida.getIdAutor());
        comentSaida.setUsu(contUsu.buscar(usuEnt));
        
        return comentSaida;
    }

    public Comentario excluir(Comentario ComentEnt) throws SQLException, ClassNotFoundException {
        daoComent = new DaoComentario();
        return daoComent.excluir(ComentEnt);
    }

    public List<Comentario> listar(Comentario ComentEnt) throws SQLException, ClassNotFoundException {
        daoComent = new DaoComentario();
        List<Comentario> listaComentarioAux = daoComent.listar(ComentEnt);
        List<Comentario> listaComentarioSaida = new ArrayList<>();
        
        for (Comentario comentSaida : listaComentarioAux) {
            listaComentarioSaida.add(buscar(comentSaida));
        }
        
        return listaComentarioSaida;
    }
    
}
