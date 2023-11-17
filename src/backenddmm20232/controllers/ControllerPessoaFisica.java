/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.models.beans.PessoaFisica;
import backenddmm20232.models.daos.DaoPessoaFisica;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ControllerPessoaFisica {
    
     DaoPessoaFisica daoPf;

    public PessoaFisica inserir(PessoaFisica pesEnt) throws SQLException, ClassNotFoundException {
        daoPf = new DaoPessoaFisica();
        return daoPf.inserir(pesEnt);
    }

    public PessoaFisica alterar(PessoaFisica pesEnt) throws SQLException, ClassNotFoundException {
        daoPf = new DaoPessoaFisica();
        return daoPf.alterar(pesEnt);
    }

    public PessoaFisica buscar(PessoaFisica pesEnt) throws SQLException, ClassNotFoundException {
        daoPf = new DaoPessoaFisica();
        return daoPf.buscar(pesEnt);
    }

    public PessoaFisica excluir(PessoaFisica pesEnt) throws SQLException, ClassNotFoundException {
        daoPf = new DaoPessoaFisica();
        return daoPf.excluir(pesEnt);
    }

    public List<PessoaFisica> listar(PessoaFisica pesEnt) throws SQLException, ClassNotFoundException {
        daoPf = new DaoPessoaFisica();
        return daoPf.listar(pesEnt);
    }
    
}
