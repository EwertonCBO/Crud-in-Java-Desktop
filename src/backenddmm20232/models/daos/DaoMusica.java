/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.Musica;
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
public class DaoMusica {

private final Connection c;
    
    public DaoMusica() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Musica excluir(Musica musEnt) throws SQLException{
        String sql = "delete from musicas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,musEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return musEnt;
    }
    
    public Musica buscar(Musica musEnt) throws SQLException{
        String sql = "select * from musicas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,musEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Musica musSaida = null;
            while (rs.next()) {      
            // criando o objeto Musica
                musSaida = new Musica(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o mus à lista de muss
            }
            stmt.close();
        return musSaida;
   }

    public Musica inserir(Musica musEnt) throws SQLException{
        String sql = "insert into musicas" + " (id_artista, id_genero, num_faixa, duracao, titulo)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt (1,musEnt.getId_artista());
        stmt.setInt(2,musEnt.getId_genero());
        stmt.setInt(3,musEnt.getNum_faixa());
        stmt.setString(4,musEnt.getDuracao());
        stmt.setString(5,musEnt.getTitulo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            musEnt.setId(id);
        }
        stmt.close();
        return musEnt;
    }

    public Musica alterar(Musica musEnt) throws SQLException{
        String sql = "UPDATE musicas SET id_artista = ?, id_genero = ?, num_faixa = ?, duracao = ?, titulo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt (1,musEnt.getId_artista());
        stmt.setInt(2,musEnt.getId_genero());
        stmt.setInt(3,musEnt.getNum_faixa());
        stmt.setString(4,musEnt.getDuracao());
        stmt.setString(5,musEnt.getTitulo());
        stmt.setInt(6,musEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return musEnt;
    }

   public List<Musica> listar(Musica musEnt) throws SQLException{
        // muss: array armazena a lista de registros

        List<Musica> muss = new ArrayList<>();
        
        String sql = "select * from musicas where titulo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + musEnt.getTitulo() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Musica
            Musica mus;
            mus = new Musica(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6)
            );
            // adiciona o mus à lista de muss
            muss.add(mus);
        }
        
        rs.close();
        stmt.close();
        return muss;
   
   }

    
}
