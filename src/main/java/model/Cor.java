/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aluno
 */
public class Cor {
    
    private int id;
    private String cor_descricao;    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor_descricao() {
        return cor_descricao;
    }

    public void setCor_descricao(String cor_descricao) {
        this.cor_descricao = cor_descricao;
    }
    
      @Override
    public String toString() {
        return this.getCor_descricao(); 
    }
}
