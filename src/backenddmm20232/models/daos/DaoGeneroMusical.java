/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.GeneroMusical;
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
 * @author User
 */
public class DaoGeneroMusical {

private final Connection c;
    
    public DaoGeneroMusical() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public GeneroMusical excluir(GeneroMusical genEnt) throws SQLException{
        String sql = "delete from generos_musicais WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,genEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return genEnt;
    }
    
    public GeneroMusical buscar(GeneroMusical genEnt) throws SQLException{
        String sql = "select * from generos_musicais WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,genEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            GeneroMusical playSaida = null;
            while (rs.next()) {      
            // criando o objeto GeneroMusical
                playSaida = new GeneroMusical(
                    rs.getInt(1),
                    rs.getString(2));
                   
            // adiciona o mus à lista de gen
            }
            stmt.close();
        return playSaida;
   }

    public GeneroMusical inserir(GeneroMusical genEnt) throws SQLException{
        String sql = "insert into generos_musicais" + " (nome)" + " values (?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,genEnt.getNome());
     
         // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            genEnt.setId(id);
        }
        stmt.close();
        return genEnt;
    }

    public GeneroMusical alterar(GeneroMusical genEnt) throws SQLException{
        String sql = "UPDATE generos_musicais SET nome = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,genEnt.getNome());
        stmt.setInt(2,genEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return genEnt;
    }

   public List<GeneroMusical> listar(GeneroMusical genEnt) throws SQLException{
        // gen: array armazena a lista de registros

        List<GeneroMusical> gen = new ArrayList<>();
        
        String sql = "select * from generos_musicais where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + genEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto GeneroMusical
            GeneroMusical play;
            play = new GeneroMusical(
                    rs.getInt(1),
                    rs.getString(2) );
            // adiciona o gen à lista de Genero
            gen.add(play);
        }
        
        rs.close();
        stmt.close();
        return gen;
   
   }

    
}
