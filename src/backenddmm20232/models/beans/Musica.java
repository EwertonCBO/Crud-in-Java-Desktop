/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author mathe
 */
public class Musica {
    private int id ,id_artista ,id_genero,num_faixa;
        private String duracao, titulo; 

    public Musica(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public int getNum_faixa() {
        return num_faixa;
    }

    public void setNum_faixa(int num_faixa) {
        this.num_faixa = num_faixa;
    }

    public String getDuracao() {
        return duracao;
    }

    public Musica(int id) {
        this.id = id;
    }

    public Musica(int id, int id_artista, int id_genero, int num_faixa, String duracao, String titulo) {
        this.id = id;
        this.id_artista = id_artista;
        this.id_genero = id_genero;
        this.num_faixa = num_faixa;
        this.duracao = duracao;
        this.titulo = titulo;
    }

    public Musica(int id_artista, int id_genero, int num_faixa, String duracao, String titulo) {
        this.id_artista = id_artista;
        this.id_genero = id_genero;
        this.num_faixa = num_faixa;
        this.duracao = duracao;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Musica{" + "id=" + id + ", id_artista=" + id_artista + ", id_genero=" + id_genero + ", num_faixa=" + num_faixa + ", duracao=" + duracao + ", titulo=" + titulo + '}';
    }

    

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
