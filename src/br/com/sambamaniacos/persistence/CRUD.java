package br.com.sambamaniacos.persistence;

import br.com.sambamaniacos.bean.Pessoas;
import br.com.sambamaniacos.view.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CRUD {
    
    private Pessoas modelo = new Pessoas();
    private PreparedStatement stmt = null;
    private String sql = null;
    private ResultSet rs = null;
    public static boolean returnException = false;
    
    public void persistir(Pessoas modelo, Conexao conn) { //Create
        sql = "insert into pessoas values(?,?,?,?,?,?,?,?,?,?,?,?,?,'pendente',?)";
        
        try {
            stmt = conn.getConn().prepareStatement(sql);
            
            stmt.setString(1, modelo.getCodigo());
            stmt.setString(2, modelo.getNome());
            stmt.setString(3, modelo.getApelido());
            stmt.setString(4, modelo.getEndereco());
            stmt.setString(5, modelo.getCidade());
            stmt.setString(6, modelo.getTelefone1());
            stmt.setString(7, modelo.getTelefone2());
            stmt.setString(8, modelo.getTelefone3());
            stmt.setString(9, modelo.getNascimento());
            stmt.setString(10, modelo.getSexo());
            stmt.setString(11, modelo.getNacionalidade());
            stmt.setString(12, modelo.getEmail());
            stmt.setBytes(13, modelo.getImagem());
            stmt.setString(14, modelo.getCpf());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            returnException = true;
        }
        finally{
            try {
                if(stmt != null) 
                    stmt.close();
            } catch (SQLException ex) {
                System.out.println("Não foi possivel fechar a conexão");
                ex.printStackTrace();
            }
        }
    }
    
    public void update (Pessoas modelo, Conexao conn) {

        sql = "update pessoas set nome = ?, apelido = ?, endereco = ?, cidade = ?, telefone1 = ?,"
                + " telefone2 = ?, telefone3 = ?, nascimento = ?, sexo = ?, nacionalidade = ?, email = ?,"
                + " imagem = ?, cpf = ?  where codigo = ?";
        
        try {
            stmt = conn.getConn().prepareStatement(sql);
            
            stmt.setString(1, modelo.getNome());
            stmt.setString(2, modelo.getApelido());
            stmt.setString(3, modelo.getEndereco());
            stmt.setString(4, modelo.getCidade());
            stmt.setString(5, modelo.getTelefone1());
            stmt.setString(6, modelo.getTelefone2());
            stmt.setString(7, modelo.getTelefone3());
            stmt.setString(8, modelo.getNascimento());
            stmt.setString(9, modelo.getSexo());
            stmt.setString(10, modelo.getNacionalidade());
            stmt.setString(11, modelo.getEmail());
            stmt.setBytes(12, modelo.getImagem());
            stmt.setString(13, modelo.getCpf());
            stmt.setString(14, modelo.getCodigo());
            
            stmt.executeUpdate();
        }   
        catch (SQLException ex) {
            returnException = true;
            ex.printStackTrace();
        }
            
    }
    
    public void updatesSituacao(Pessoas modelo, Conexao conn){
        sql = "update pessoas set situacao = ? where codigo = ?";
        
        try {
            stmt = conn.getConn().prepareStatement(sql);
            
            stmt.setString(1, modelo.getSituação());
            stmt.setString(2, modelo.getCodigo());
            
            stmt.executeUpdate();
        }
        catch (SQLException ex) {
                ex.printStackTrace();
        }
    }
    
    public void remover (Pessoas modelo, Conexao conn) { //Delete
        String sql = "delete from pessoas where codigo = ?";
        
        try {
            stmt = conn.getConn().prepareStatement(sql);
            
            stmt.setString(1, modelo.getCodigo());
            
            stmt.executeUpdate();
            
        }
        catch(SQLException ex) {
            
            ex.printStackTrace();
            
        }
    }

    public void gerarResultSet(String sql, Conexao conn, Principal.Action action) { //Read
     
        try {
            if (action == Principal.Action.NORMAL) {
                stmt = conn.getConn().prepareStatement(sql);
                setRs(stmt.executeQuery());
            }
            else
                if (action == Principal.Action.B_CODIGO) {
                    stmt = conn.getConn().prepareStatement(sql);
                    stmt.setString(1, Principal.getCmplocalizarpc().getText() + '%');
                    setRs(stmt.executeQuery());
                }
                else
                    if(action == Principal.Action.B_NOME) {
                        stmt = conn.getConn().prepareStatement(sql);
                        stmt.setString(1, Principal.getCmplocalizarpn().getText() + '%');
                        setRs(stmt.executeQuery());
                    }
                    else
                        if(action == Principal.Action.B_CPF) {
                            stmt = conn.getConn().prepareStatement(sql);
                            stmt.setString(1, Principal.getCmplocalizarpCpf().getText() + '%');
                            setRs(stmt.executeQuery());
                        }
            
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Pessoas buscarAll(){ //buscar todos no banco de dados
        Pessoas modelo = new Pessoas();

        try {
            
            modelo.setCodigo(getRs().getString("codigo"));
            modelo.setNome(getRs().getString("nome"));
            modelo.setApelido(getRs().getString("apelido"));
            modelo.setCpf(getRs().getString("cpf"));
            modelo.setTelefone2(getRs().getString("telefone2"));
            modelo.setCidade(getRs().getString("cidade"));
            modelo.setSituação(getRs().getString("situacao"));
            
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return modelo;
    }
    
    public Pessoas buscarOne(Object valor, Conexao conn) { //Buscar uma pessoa só no banco de dados
        Pessoas modelo = new Pessoas();
        
        sql = "Select codigo, nome, apelido, endereco, cidade, telefone1, telefone2,"
                + " telefone3, nascimento, sexo, nacionalidade, email, imagem, cpf from pessoas where codigo = ?";
        
        
        try {
            
            stmt = conn.getConn().prepareStatement(sql);
            stmt.setString(1, (String) valor);
            setRs(stmt.executeQuery());
            
            if(getRs().next()) {
                modelo.setCodigo(getRs().getString("codigo"));
                modelo.setNome(getRs().getString("nome"));
                modelo.setApelido(getRs().getString("apelido"));
                modelo.setEndereco(getRs().getString("endereco"));
                modelo.setTelefone1(getRs().getString("telefone1"));
                modelo.setTelefone2(getRs().getString("telefone2"));
                modelo.setTelefone3(getRs().getString("telefone3"));
                modelo.setNascimento(getRs().getString("nascimento"));
                modelo.setSexo(getRs().getString("sexo"));
                modelo.setNacionalidade(getRs().getString("nacionalidade"));
                modelo.setEmail(getRs().getString("email"));
                modelo.setCidade(getRs().getString("cidade"));
                modelo.setImagem(getRs().getBytes("imagem"));
                modelo.setCpf(getRs().getString("cpf"));
            }
            
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        return modelo;
    }
    
    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}
