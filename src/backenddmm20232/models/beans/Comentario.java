/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author Ewerton CBO
 */
public class Comentario {
    private int id, idAutor, idPost, avaliacao;
    private String descricao, data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Comentario(int id, int idAutor, int idPost, int avaliacao, String descricao, String data) {
        this.id = id;
        this.idAutor = idAutor;
        this.idPost = idPost;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.data = data;
    }
    

    public Comentario(int id) {
        this.id = id;
    }

    public Comentario(int idAutor, int idPost, int avaliacao, String descricao, String data) {
        this.idAutor = idAutor;
        this.idPost = idPost;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.data = data;
    }

    public Comentario(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", idAutor=" + idAutor + ", idPost=" + idPost + ", avaliacao=" + avaliacao + ", descricao=" + descricao + ", data=" + data + '}';
    }

   
    
    
    
}
