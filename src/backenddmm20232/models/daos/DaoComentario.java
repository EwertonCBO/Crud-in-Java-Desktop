/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.Comentario;
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
public class DaoComentario {

private final Connection c;
    
    public DaoComentario() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Comentario excluir(Comentario comentEnt) throws SQLException{
        String sql = "delete from Comentarios WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,comentEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return comentEnt;
    }
    
    public Comentario buscar(Comentario comentEnt) throws SQLException{
        String sql = "select * from Comentarios WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,comentEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Comentario comentSaida = null;
            while (rs.next()) {      
            // criando o objeto Comentario
                comentSaida = new Comentario(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6));
                    
            // adiciona o mus à lista de coments
            }
            stmt.close();
        return comentSaida;
   }

    public Comentario inserir(Comentario comentEnt) throws SQLException{
        String sql = "insert into comentarios" + " ( id_autor, id_post, avaliacao, descricao, data)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt (1,comentEnt.getIdAutor());
        stmt.setInt (2,comentEnt.getIdPost());
        stmt.setInt (3,comentEnt.getAvaliacao());
        stmt.setString(4,comentEnt.getDescricao());
        stmt.setString(5,comentEnt.getData());
       
        

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            comentEnt.setId(id);
        }
        stmt.close();
        return comentEnt;
    }

    public Comentario alterar(Comentario comentEnt) throws SQLException{
        String sql = "UPDATE comentarios SET id_autor = ?, id_post = ?, avaliacao = ?, descricao = ?, data = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt (1,comentEnt.getIdAutor());
        stmt.setInt (2,comentEnt.getIdPost());
        stmt.setInt (3,comentEnt.getAvaliacao());
        stmt.setString(4,comentEnt.getDescricao());
        stmt.setString(5,comentEnt.getData());
        stmt.setInt(6,comentEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return comentEnt;
    }

   public List<Comentario> listar(Comentario comentEnt) throws SQLException{
        // coments: array armazena a lista de registros

        List<Comentario> coments = new ArrayList<>();
        
        String sql = "select * from comentarios where data like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + comentEnt.getData() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Comentario
            Comentario coment;
            coment = new Comentario(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6));
            
            // adiciona o mus à lista de coments
            coments.add(coment);
        }
        
        rs.close();
        stmt.close();
        return coments;
   
   }

    
}
