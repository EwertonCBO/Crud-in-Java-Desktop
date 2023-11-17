/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author Ewerton CBO
 */
public class GeneroMusical {
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroMusical(int id) {
        this.id = id;
    }

    public GeneroMusical(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public GeneroMusical(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "GeneroMusical{" + "id=" + id + ", nome=" + nome + '}';
    }
    
                
    
}
