/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.PessoaFisica;
import backenddmm20232.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class DaoPessoaFisica {

private final Connection c;
    
    public DaoPessoaFisica() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public PessoaFisica excluir(PessoaFisica pesEnt) throws SQLException{
        String sql = "delete from pessoasfisicas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pesEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        return pesEnt;
    }
    
    public PessoaFisica buscar(PessoaFisica pesEnt) throws SQLException{
        String sql = "select * from pessoasfisicas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pesEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PessoaFisica pesSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                pesSaida = new PessoaFisica(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return pesSaida;
   }

    public PessoaFisica inserir(PessoaFisica pesEnt) throws SQLException{
        String sql = "insert into pessoasfisicas" + " (nome, rg, cpf)" + " values (?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
     
        // seta os valores
        stmt.setString(1,pesEnt.getNome());
        stmt.setString(2,pesEnt.getRg());
        stmt.setString(3,pesEnt.getCpf());

        // executa
        stmt.execute();
        stmt.close();
        return pesEnt;
    }

    public PessoaFisica alterar(PessoaFisica pesEnt) throws SQLException{
        String sql = "UPDATE pessoasfisicas SET nome = ?, rg = ?, cpf = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,pesEnt.getNome());
        stmt.setString(2,pesEnt.getRg());
        stmt.setString(3,pesEnt.getCpf());
        stmt.setInt(4,pesEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pesEnt;
    }

   public List<PessoaFisica> listar(PessoaFisica pesEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<PessoaFisica> pess = new ArrayList<>();
        
        String sql = "select * from pessoasfisicas where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pesEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            PessoaFisica p = new PessoaFisica(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            pess.add(p);
        }
        
        rs.close();
        stmt.close();
        return pess;
   
   }
}
