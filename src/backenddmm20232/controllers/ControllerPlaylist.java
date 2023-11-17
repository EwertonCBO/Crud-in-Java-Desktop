/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.models.beans.Playlist;
import backenddmm20232.models.daos.DaoPlaylist;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ControllerPlaylist {
    
    DaoPlaylist daoPlay;

  

    public Playlist inserir(Playlist playEnt) throws SQLException, ClassNotFoundException {
        daoPlay = new DaoPlaylist();
        return daoPlay.inserir(playEnt);
    }

    public Playlist alterar(Playlist playEnt) throws SQLException, ClassNotFoundException {
        daoPlay = new DaoPlaylist();
        return daoPlay.alterar(playEnt);
    }

    public Playlist buscar(Playlist playEnt) throws SQLException, ClassNotFoundException {
        daoPlay = new DaoPlaylist();
        return daoPlay.buscar(playEnt);
    }

    public Playlist excluir(Playlist playEnt) throws SQLException, ClassNotFoundException {
        daoPlay = new DaoPlaylist();
        return daoPlay.excluir(playEnt);
    }

    public List<Playlist> listar(Playlist playEnt) throws SQLException, ClassNotFoundException {
        daoPlay = new DaoPlaylist();
        return daoPlay.listar(playEnt);
    }
    
}
