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
import model.MovimentacaoEntradaSaida;


/**
 *
 * @author Aluno
 */
public class SaidaDAO {
    
       public void create(MovimentacaoEntradaSaida s){
    
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt =  con.prepareStatement("INSERT INTO movimentacao (operacao, id_produto,quantidade,data) VALUES (?,(SELECT id FROM produto WHERE descricao_produto= ?),?,?);");
            
            
            stmt.setString(1,"saida");
            stmt.setString(2,s.getId_produto());
            stmt.setInt(3,s.getQuantidade());
            stmt.setString(4,(s.getData()));
            
           // String dia = jTextData.getText().substring(0,2);


            stmt.execute();

            
                    
        } catch (SQLException ex) {
            Logger.getLogger(SaidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{            
            //ConnectionFactory.closeConnection(con, stmt);
        
        }
    
    }
}
