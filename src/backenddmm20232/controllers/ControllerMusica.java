/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.models.beans.Musica;
import backenddmm20232.models.daos.DaoMusica;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ControllerMusica {
    
    DaoMusica daoMus;

  

    public Musica inserir(Musica usuEnt) throws SQLException, ClassNotFoundException {
        daoMus = new DaoMusica();
        return daoMus.inserir(usuEnt);
    }

    public Musica alterar(Musica usuEnt) throws SQLException, ClassNotFoundException {
        daoMus = new DaoMusica();
        return daoMus.alterar(usuEnt);
    }

    public Musica buscar(Musica usuEnt) throws SQLException, ClassNotFoundException {
        daoMus = new DaoMusica();
        return daoMus.buscar(usuEnt);
    }

    public Musica excluir(Musica usuEnt) throws SQLException, ClassNotFoundException {
        daoMus = new DaoMusica();
        return daoMus.excluir(usuEnt);
    }

    public List<Musica> listar(Musica usuEnt) throws SQLException, ClassNotFoundException {
        daoMus = new DaoMusica();
        return daoMus.listar(usuEnt);
    }
    
}
