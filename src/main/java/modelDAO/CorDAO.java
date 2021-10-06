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
import javax.swing.JOptionPane;
import model.Cor;

/**
 *
 * @author Aluno
 */
public class CorDAO {
    
    private Connection con;
    
    public CorDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
 
    //listar
    public List<Cor> listarCor(){
        
        try{
            List<Cor> Cor = new ArrayList<>();
            
            String sql = "SELECT * FROM cor_produto;";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Cor obj = new Cor();
                
                obj.setId(rs.getInt("id"));
                obj.setCor_descricao(rs.getString("cor_descricao"));
                
                Cor.add(obj);
            }
                return Cor;
        }catch(SQLException ex){
            Logger.getLogger(CorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }      
    }
}
