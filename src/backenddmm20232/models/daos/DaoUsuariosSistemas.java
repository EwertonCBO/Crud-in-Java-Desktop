/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.UsuariosSistemas;
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
public class DaoUsuariosSistemas {
    
    private final Connection c;
    
    public DaoUsuariosSistemas() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public UsuariosSistemas inserir(UsuariosSistemas usuSist) throws SQLException{
        String sql = "insert into usuariossistemas" + " (idUsu, idSis, tipo, status, obs)" + " values (?,?,?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        // seta os valores
        stmt.setInt(1,usuSist.getIdUsu());
        stmt.setInt(2,usuSist.getIdSis());
        stmt.setString(3,usuSist.getTipo());
        stmt.setString(4,usuSist.getStatus());
        stmt.setString(5,usuSist.getObs());
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usuSist.setId(id);
        }
        stmt.close();
        return usuSist;
    }

    public UsuariosSistemas alterar(UsuariosSistemas usuSist) throws SQLException{
        String sql = "UPDATE usuariossistemas SET idUsu = ?, idSis = ?, tipo = ?, status = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuSist.getIdUsu());
        stmt.setInt(2,usuSist.getIdSis());
        stmt.setString(3,usuSist.getTipo());
        stmt.setString(4,usuSist.getStatus());
        stmt.setString(5,usuSist.getObs());
        stmt.setInt(6,usuSist.getId());
        // executa
        stmt.execute();
        stmt.close();
        return usuSist;
    }

    public UsuariosSistemas buscar(UsuariosSistemas usuSist) throws SQLException{
        String sql = "select * from usuariossistemas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usuSist.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            UsuariosSistemas usuSisSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usuSisSaida = new UsuariosSistemas(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usuSisSaida;

    }

    public UsuariosSistemas excluir(UsuariosSistemas usuSist) throws SQLException{
        String sql = "delete from usuariossistemas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuSist.getId());
        // executa
        stmt.execute();
        stmt.close();
        return usuSist;

    }

    public List<UsuariosSistemas> listar(UsuariosSistemas usuSist) throws SQLException{
        // usus: array armazena a lista de registros

        List<UsuariosSistemas> ususists = new ArrayList<>();
        
        String sql = "select * from usuariossistemas where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usuSist.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            UsuariosSistemas us = new UsuariosSistemas(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            // adiciona o usu à lista de usus
            ususists.add(us);
        }
        
        rs.close();
        stmt.close();
        return ususists;

    }
    
}
