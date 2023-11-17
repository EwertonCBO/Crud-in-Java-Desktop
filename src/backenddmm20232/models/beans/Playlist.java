/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author Aluno
 */
public class Playlist {
    private int id, numero_faixas ;
    private String nome, genero, criador ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Playlist{" + "id=" + id + ", numero_faixas=" + numero_faixas + ", nome=" + nome + ", genero=" + genero + ", criador=" + criador + '}';
    }

    public Playlist(String nome) {
        this.nome = nome;
    }

    public Playlist(int id) {
        this.id = id;
    }

    public Playlist(int numero_faixas, String nome, String genero, String criador) {
        this.numero_faixas = numero_faixas;
        this.nome = nome;
        this.genero = genero;
        this.criador = criador;
    }

    public int getNumero_faixas() {
        return numero_faixas;
    }

    public void setNumero_faixas(int numero_faixas) {
        this.numero_faixas = numero_faixas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public Playlist(int id, int numero_faixas, String nome, String genero, String criador) {
        this.id = id;
        this.numero_faixas = numero_faixas;
        this.nome = nome;
        this.genero = genero;
        this.criador = criador;
    }

 
    
    }
    
    
    
    
    
    
    
    
    

