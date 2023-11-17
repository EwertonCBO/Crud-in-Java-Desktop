/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.Playlist;
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
public class DaoPlaylist {

private final Connection c;
    
    public DaoPlaylist() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Playlist excluir(Playlist playEnt) throws SQLException{
        String sql = "delete from playlists WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,playEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return playEnt;
    }
    
    public Playlist buscar(Playlist playEnt) throws SQLException{
        String sql = "select * from playlists WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,playEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Playlist playSaida = null;
            while (rs.next()) {      
            // criando o objeto Playlist
                playSaida = new Playlist(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
                    
            // adiciona o mus à lista de muss
            }
            stmt.close();
        return playSaida;
   }

    public Playlist inserir(Playlist playEnt) throws SQLException{
        String sql = "insert into Playlists" + " (num_faixa, nome ,genero, criador )" + " values (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt (1,playEnt.getNumero_faixas());
        stmt.setString(2,playEnt.getNome());
        stmt.setString(3,playEnt.getGenero());
        stmt.setString(4,playEnt.getCriador());
        

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            playEnt.setId(id);
        }
        stmt.close();
        return playEnt;
    }

    public Playlist alterar(Playlist playEnt) throws SQLException{
        String sql = "UPDATE playlists SET num_faixa = ?, nome = ?, genero = ?, criador = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt (1,playEnt.getNumero_faixas());
        stmt.setString(2,playEnt.getNome());
        stmt.setString(3,playEnt.getGenero());
        stmt.setString(4,playEnt.getCriador());
        stmt.setInt(5,playEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return playEnt;
    }

   public List<Playlist> listar(Playlist playEnt) throws SQLException{
        // muss: array armazena a lista de registros

        List<Playlist> muss = new ArrayList<>();
        
        String sql = "select * from playlists where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + playEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Playlist
            Playlist play;
            play = new Playlist(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5) 
            );
            // adiciona o mus à lista de muss
            muss.add(play);
        }
        
        rs.close();
        stmt.close();
        return muss;
   
   }

    
}
