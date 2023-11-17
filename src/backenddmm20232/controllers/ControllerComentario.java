/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.models.beans.Comentario;
import backenddmm20232.models.daos.DaoComentario;
import java.sql.SQLException;
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

    public Comentario buscar(Comentario ComentEnt) throws SQLException, ClassNotFoundException {
        daoComent = new DaoComentario();
        return daoComent.buscar(ComentEnt);
    }

    public Comentario excluir(Comentario ComentEnt) throws SQLException, ClassNotFoundException {
        daoComent = new DaoComentario();
        return daoComent.excluir(ComentEnt);
    }

    public List<Comentario> listar(Comentario ComentEnt) throws SQLException, ClassNotFoundException {
        daoComent = new DaoComentario();
        return daoComent.listar(ComentEnt);
    }
    
}
