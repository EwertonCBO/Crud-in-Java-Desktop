/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.models.beans.GeneroMusical;
import backenddmm20232.models.daos.DaoGeneroMusical;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ControllerGeneroMusical {
    
    DaoGeneroMusical daoGen;

  

    public GeneroMusical inserir(GeneroMusical genEnt) throws SQLException, ClassNotFoundException {
        daoGen = new DaoGeneroMusical();
        return daoGen.inserir(genEnt);
    }

    public GeneroMusical alterar(GeneroMusical genEnt) throws SQLException, ClassNotFoundException {
        daoGen = new DaoGeneroMusical();
        return daoGen.alterar(genEnt);
    }

    public GeneroMusical buscar(GeneroMusical genEnt) throws SQLException, ClassNotFoundException {
        daoGen = new DaoGeneroMusical();
        return daoGen.buscar(genEnt);
    }

    public GeneroMusical excluir(GeneroMusical genEnt) throws SQLException, ClassNotFoundException {
        daoGen = new DaoGeneroMusical();
        return daoGen.excluir(genEnt);
    }

    public List<GeneroMusical> listar(GeneroMusical genEnt) throws SQLException, ClassNotFoundException {
        daoGen = new DaoGeneroMusical();
        return daoGen.listar(genEnt);
    }
    
}
