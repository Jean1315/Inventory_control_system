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
import model.Marca;

/**
 *
 * @author Aluno
 */
public class MarcaDAO {
    
    private Connection con;
        
    public MarcaDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
 
    //listar
    public List<Marca> listarMarca(){
        
        try{
            List<Marca> marca = new ArrayList<>();
            
            String sql = "SELECT * FROM marca_produto;";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Marca obj = new Marca();
                
                obj.setId(rs.getInt("id"));
                obj.setDescricao_marca(rs.getString("descricao_marca"));
                
                marca.add(obj);
            }
                return marca;
        }catch(SQLException ex){
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        }      
    }
}
