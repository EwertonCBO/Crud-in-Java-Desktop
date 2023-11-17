/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.nivelamento;

/**
 *
 * @author Aluno
 */
public class Veiculo {
    
    private int id;
    private String placa;
    private String cor;
    private int potencia;

    public Veiculo(int id, String placa, String cor, int potencia) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.potencia = potencia;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", placa=" + placa + ", cor=" + cor + ", potencia=" + potencia + '}';
    }
    
    
    
    
}
