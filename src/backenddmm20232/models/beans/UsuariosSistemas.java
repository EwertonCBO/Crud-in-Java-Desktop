/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author Professor
 */
public class UsuariosSistemas {
    
    private int id;
    private int idUsu;
    private int idSis;
    private String tipo;
    private String status;
    private String obs;
    private Usuario usu;
    private Sistema sis;

    public UsuariosSistemas(int id) {
        this.id = id;
    }

    public UsuariosSistemas(String obs) {
        this.obs = obs;
    }

    public UsuariosSistemas(int idUsu, int idSis, String tipo, String status, String obs) {
        this.idUsu = idUsu;
        this.idSis = idSis;
        this.tipo = tipo;
        this.status = status;
        this.obs = obs;
    }

    public UsuariosSistemas(int id, int idUsu, int idSis, String tipo, String status, String obs) {
        this.id = id;
        this.idUsu = idUsu;
        this.idSis = idSis;
        this.tipo = tipo;
        this.status = status;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public int getIdSis() {
        return idSis;
    }

    public void setIdSis(int idSis) {
        this.idSis = idSis;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Sistema getSis() {
        return sis;
    }

    public void setSis(Sistema sis) {
        this.sis = sis;
    }

    @Override
    public String toString() {
        return "UsuariosSistemas{" + "id=" + id + ", idUsu=" + idUsu + ", idSis=" + idSis + ", tipo=" + tipo + ", status=" + status + ", obs=" + obs + '}';
    }
    
    
    
    
}
