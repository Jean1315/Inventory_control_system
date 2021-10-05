/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;

/**
 *
 * @author Aluno
 */
public class ProdutoEntradaSaidaListDAO  {
    
    private Connection con;
        
    public ProdutoEntradaSaidaListDAO (){
        this.con = new ConnectionFactory().getConnection();
    }
 
    //listar
    public List<Produto> listProdutoEntrada(){
        
        try{
            List<Produto> listProdutoEntrada = new ArrayList<>();
            
            String sql = "SELECT * FROM produto";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto obj = new Produto();
                
                obj.setDescricao_produto(rs.getString("descricao_produto"));
                
                listProdutoEntrada.add(obj);
            }
                return listProdutoEntrada;
        }catch(SQLException ex){
            Logger.getLogger(ProdutoEntradaSaidaListDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }      
    }
}