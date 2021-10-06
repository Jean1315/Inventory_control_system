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
public class SaldoMovimentacaoDAO {
    
    private Connection con;

    public List<Produto> read() {

        List<Produto> saldo = new ArrayList<>();

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("SELECT A.id as id, A.descricao_produto as Descricao_produto,(IFNULL((SELECT SUM(quantidade) FROM movimentacao WHERE id_produto = A.id and operacao = 'entrada'),0) - IFNULL((SELECT SUM(quantidade) FROM movimentacao WHERE id_produto = A.id and operacao = 'saida'),0))as saldo FROM produto A;");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Produto saldoProduto = new Produto();

                saldoProduto.setDescricao_produto(rs.getString("descricao_produto"));
                saldoProduto.setSaldo(rs.getInt("saldo"));
                
                saldo.add(saldoProduto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaldoMovimentacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{            
            //ConnectionFactory.closeConnection(con, stmt);       
        }
        return saldo;
    }
    

/*
    public class buscarSaldo {
        
    public List<Produto> read(String desc) {

        List<Produto> saldo = new ArrayList<>();

        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("SELECT A.id as Id, A.descricao_produto as Descricao_produto,((SELECT SUM(quantidade) FROM movimentacao WHERE id_produto = A.id and operacao = 'entrada')-(SELECT SUM(quantidade) FROM movimentacao WHERE id_produto = A.id and operacao = 'saida')) as saldo FROM produto A WHERE descricao_produto LIKE ?;");
            stmt.setString(1,"%"+desc+"%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Produto saldoProduto = new Produto();
                saldoProduto.setDescricao_produto(rs.getString("descricao_produto"));
                saldoProduto.setSaldo(rs.getInt("saldo"));
                
                saldo.add(saldoProduto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaldoMovimentacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{            
            //ConnectionFactory.closeConnection(con, stmt);       
        }
        return saldo;
    }    }*/
}
