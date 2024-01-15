/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author Professor
 */
public class MusicaGeneroMusical {
    
    private int id;
    private int idMusi;
    private int idGen;
    private String titulo;
    private String genero;
    private Musica musi;
    private GeneroMusical gen;

    public MusicaGeneroMusical(int id, int idMusi, int idGen, String titulo, String genero) {
        this.id = id;
        this.idMusi = idMusi;
        this.idGen = idGen;
        this.titulo = titulo;
        this.genero = genero;
    }

    public MusicaGeneroMusical(int idMusi, int idGen, String titulo, String genero) {
        this.idMusi = idMusi;
        this.idGen = idGen;
        this.titulo = titulo;
        this.genero = genero;
    }

    public MusicaGeneroMusical(int id) {
        this.id = id;
    }

    public MusicaGeneroMusical(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMusi() {
        return idMusi;
    }

    public void setIdMusi(int idMusi) {
        this.idMusi = idMusi;
    }

    public int getIdGen() {
        return idGen;
    }

    public void setIdGen(int idGen) {
        this.idGen = idGen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Musica getMusi() {
        return musi;
    }

    public void setMusi(Musica musi) {
        this.musi = musi;
    }

    public GeneroMusical getGen() {
        return gen;
    }

    public void setGen(GeneroMusical gen) {
        this.gen = gen;
    }

    @Override
    public String toString() {
        return "MusicaGeneroMusical{" + "id=" + id + ", idMusi=" + idMusi + ", idGen=" + idGen + ", titulo=" + titulo + ", genero=" + genero + '}';
    }

}