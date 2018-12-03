package br.com.sambamaniacos.persistence;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    private PreparedStatement stmt;
    private String url = "jdbc:mysql://localhost/db";
    
    public void getConexao() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "");
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver do MySQL nao foi encontrado", "Alerta", JOptionPane.OK_OPTION);
            System.exit(0);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o banco de dados!", "Alerta", JOptionPane.OK_OPTION);
            System.exit(0);
        }
        
        //return conn;

    }
    
    public void fecharConexao() throws SQLException{
        if(conn != null)
            conn.close(); 
        
        if(stmt != null)
            stmt.close();
    }
}
