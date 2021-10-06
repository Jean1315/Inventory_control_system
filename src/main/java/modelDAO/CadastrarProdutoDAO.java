/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;
    //responsavel por inserir no banco de dados
public class CadastrarProdutoDAO {
    
    public void create(Produto p){
    
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt =  con.prepareStatement("INSERT INTO produto (serial_produto,descricao_produto,preco_produto,id_cor,id_marca) VALUES (?,?,?,?,?);");
            
            stmt.setInt(1,p.getSerial_produto());
            stmt.setString(2,p.getDescricao_produto());
            stmt.setDouble(3,p.getPreco_produto());
            stmt.setInt(4,p.getId_cor());
            stmt.setInt(5,p.getId_marca());
            
            stmt.execute();
            
                    
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{            
            //ConnectionFactory.closeConnection(con, stmt);
        
        }
    
    }
    
}
