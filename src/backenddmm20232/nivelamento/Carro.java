/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.nivelamento;

/**
 *
 * @author Aluno
 */
public class Carro extends Veiculo {
    
    private int eixos;

    public Carro(int eixos, int id, String placa, String cor, int potencia) {
        super(id, placa, cor, potencia);
        this.eixos = eixos;
    }
        

    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }

      @Override
    public String toString() {
        
        String msg = super.toString();
        
        msg += " Carro{" + "eixos=" + eixos + '}';
        
        return msg;
    }
    
    
}
