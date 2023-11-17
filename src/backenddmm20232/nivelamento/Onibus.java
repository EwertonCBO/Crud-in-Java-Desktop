/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.nivelamento;

/**
 *
 * @author Aluno
 */
public class Onibus extends Veiculo {
    
    private int eixo;

    public Onibus(int eixo, int id, String placa, String cor, int potencia) {
        super(id, placa, cor, potencia);
        this.eixo = eixo;
    }

    public int getEixo() {
        return eixo;
    }

    public void setEixo(int eixo) {
        this.eixo = eixo;
    }

    @Override
    public String toString() {
        
        String msg = super.toString();
        
        msg += " Carro{" + "eixo=" + eixo + '}';
        
        return msg;
    }
    
    
    
            
    
}
