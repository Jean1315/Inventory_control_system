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
public class Produto {
    private int serial_produto;
    private String descricao_produto;
    private double preco_produto ;
    private int id_cor;
    private int id_marca;
    private int saldo;

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSerial_produto() {
        return serial_produto;
    }

    public void setSerial_produto(int serial_produto) {
        this.serial_produto = serial_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }

    public int getId_cor() {
        return id_cor;
    }

    public void setId_cor(int id_cor) {
        this.id_cor = id_cor;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }   
    
    @Override
    public String toString() {
    return this.getDescricao_produto(); 
    }
}
