/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.models.beans.Sistema;
import backenddmm20232.models.beans.Usuario;
import backenddmm20232.models.beans.UsuariosSistemas;
import backenddmm20232.models.daos.DaoUsuariosSistemas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor
 */
public class ControllerUsuariosSistemas {
    
     DaoUsuariosSistemas daoUs;

    public UsuariosSistemas inserir(UsuariosSistemas usuSist) throws SQLException, ClassNotFoundException {
        daoUs = new DaoUsuariosSistemas();
        return daoUs.inserir(usuSist);
    }

    public UsuariosSistemas alterar(UsuariosSistemas usuSist) throws SQLException, ClassNotFoundException {
        daoUs = new DaoUsuariosSistemas();
        return daoUs.alterar(usuSist);
    }

    public UsuariosSistemas excluir(UsuariosSistemas usuSist) throws SQLException, ClassNotFoundException {
        daoUs = new DaoUsuariosSistemas();
        return daoUs.excluir(usuSist);
    }

    public UsuariosSistemas buscar(UsuariosSistemas usuSist) throws SQLException, ClassNotFoundException {
        daoUs = new DaoUsuariosSistemas();
        UsuariosSistemas usSaida = daoUs.buscar(usuSist);
        
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuEnt = new Usuario(usSaida.getIdUsu());
        usSaida.setUsu(contUsu.buscar(usuEnt));
        
        ControllerSistema contSis = new ControllerSistema();
        Sistema sisEnt = new Sistema(usSaida.getIdSis());
        
        usSaida.setSis(contSis.buscar(sisEnt));
        
        return usSaida;
    }

    public List<UsuariosSistemas> listar(UsuariosSistemas usuSist) throws SQLException, ClassNotFoundException {
        daoUs = new DaoUsuariosSistemas();
        List<UsuariosSistemas> listaUsuSistemaAux = daoUs.listar(usuSist);
        List<UsuariosSistemas> listaUsuSistemaSaida = new ArrayList<>();
        
        for (UsuariosSistemas usuSisSaida : listaUsuSistemaAux) {
            listaUsuSistemaSaida.add(buscar(usuSisSaida));
        }
        
        return listaUsuSistemaSaida;
    }

    
}
