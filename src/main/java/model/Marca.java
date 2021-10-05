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

public class Marca {
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao_marca() {
        return descricao_marca;
    }

    public void setDescricao_marca(String descricao_marca) {
        this.descricao_marca = descricao_marca;
    }
    private String descricao_marca;

    @Override
    public String toString() {
        return this.getDescricao_marca(); 
    }
    
    
            
}
