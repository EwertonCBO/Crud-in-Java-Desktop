/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author Aluno
 */
public class PessoaFisica extends Pessoa{
    
    private String cpf;
    private String rg;

    public PessoaFisica(int id) {
        super(id);
    }

    public PessoaFisica(String nome) {
        super(nome);
    }

    
    public PessoaFisica(int id, String nome, String cpf, String rg) {
        super(id, nome);
        this.cpf = cpf;
        this.rg = rg;
    }

    public PessoaFisica(String nome, String cpf, String rg) {
        super(nome);
        this.cpf = cpf;
        this.rg = rg;
    }
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        
        String msg = super.toString();
        msg += "PessoaFisica{" + "cpf=" + cpf + ", rg=" + rg + '}';
        return msg;
    }
 }
