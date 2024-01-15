/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.MusicaGeneroMusical;
import backenddmm20232.util.ConexaoDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor
 */
public class DaoMusicaGeneroMusical {
    
    private final Connection c;
    
    public DaoMusicaGeneroMusical() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public MusicaGeneroMusical inserir(MusicaGeneroMusical musiGen) throws SQLException{
        String sql = "insert into musica_generoMusical" + " (idMusi, idGen, titulo, genero)" + " values (?,?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        // seta os valores
        stmt.setInt(1,musiGen.getIdMusi());
        stmt.setInt(2,musiGen.getIdGen());
        stmt.setString(3,musiGen.getTitulo());
        stmt.setString(4,musiGen.getGenero());
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            musiGen.setId(id);
        }
        stmt.close();
        return musiGen;
    }

    public MusicaGeneroMusical alterar(MusicaGeneroMusical musiGen) throws SQLException{
        String sql = "UPDATE musica_generoMusical SET idMusi = ?, idGen = ?, titulo = ?, genero = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,musiGen.getIdMusi());
        stmt.setInt(2,musiGen.getIdGen());
        stmt.setString(3,musiGen.getTitulo());
        stmt.setString(4,musiGen.getGenero());
        stmt.setInt(5,musiGen.getId());
        
        // executa
        stmt.execute();
        stmt.close();
        return musiGen;
    }

    public MusicaGeneroMusical buscar(MusicaGeneroMusical musiGen) throws SQLException{
        String sql = "select * from musica_generoMusical WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,musiGen.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            MusicaGeneroMusical musiGenSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                musiGenSaida = new MusicaGeneroMusical(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus 
                        }
            
            stmt.close();
        return musiGenSaida;

    }

    public MusicaGeneroMusical excluir(MusicaGeneroMusical musiGen) throws SQLException{
        String sql = "delete from musica_generoMusical WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,musiGen.getId());
        // executa
        stmt.execute();
        stmt.close();
        return musiGen;

    }

    public List<MusicaGeneroMusical> listar(MusicaGeneroMusical mgEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<MusicaGeneroMusical> pess = new ArrayList<>();
        
        String sql = "select * from musica_generoMusical where genero like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + mgEnt.getGenero()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            MusicaGeneroMusical p = new MusicaGeneroMusical(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            pess.add(p);
        }
        
        rs.close();
        stmt.close();
        return pess;
    
}
}
