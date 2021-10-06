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
public class MovimentacaoFiltrarProdutoDAO {
    
    private Connection con;

    public List<Produto> readForDesc(String desc) {

        List<Produto> filtroProduto = new ArrayList<>();

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt =  con.prepareStatement("SELECT A.id as Id, A.descricao_produto as Descricao_produto,(IFNULL((SELECT SUM(quantidade) FROM movimentacao WHERE id_produto = A.id and operacao = 'entrada'),0)-IFNULL((SELECT SUM(quantidade) FROM movimentacao WHERE id_produto = A.id and operacao = 'saida'),0)) as saldo FROM produto A WHERE descricao_produto LIKE ?;");
            
            stmt.setString(1,"%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setDescricao_produto(rs.getString("descricao_produto"));
                produto.setSaldo(rs.getInt("saldo"));
                
                filtroProduto.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovimentacaoFiltrarProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{            
            //ConnectionFactory.closeConnection(con, stmt);       
        }
        return filtroProduto;
    }
}
