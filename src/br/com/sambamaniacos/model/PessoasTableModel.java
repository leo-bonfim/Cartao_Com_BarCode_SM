/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sambamaniacos.model;

import br.com.sambamaniacos.bean.Pessoas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Leonardo
 */
public class PessoasTableModel extends AbstractTableModel{
    
    private static List<Pessoas> dados = new ArrayList<Pessoas>();
    private String colunas[] = {"Código", "Nome", "Apelido", "CPF", "Telefone (Cel)", "Cidade", "Situação"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return getDados().size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0: 
                return getDados().get(rowIndex).getCodigo();
            case 1:
                return getDados().get(rowIndex).getNome();
            case 2:
                return getDados().get(rowIndex).getApelido();
            case 3:
                return getDados().get(rowIndex).getCpf();
            case 4:
                return getDados().get(rowIndex).getTelefone2();
            case 5:
                return getDados().get(rowIndex).getCidade();
            case 6:
                return getDados().get(rowIndex).getSituação();
                
            default:
                return null;
        }
  
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0: 
                getDados().get(rowIndex).setCodigo((String) aValue);
                break;
            case 1:
                getDados().get(rowIndex).setNome((String) aValue);
                break;
            case 2:
                getDados().get(rowIndex).setApelido((String) aValue);
                break;
            case 3:
                getDados().get(rowIndex).setCpf((String) aValue);
                break;
            case 4:
                getDados().get(rowIndex).setTelefone2((String) aValue);
                break;
            case 5:
                getDados().get(rowIndex).setCidade((String) aValue);
                break;
            case 6:
                getDados().get(rowIndex).setSituação((String) aValue);
                break;
        }
        
        this.fireTableRowsUpdated(rowIndex, rowIndex);
        
    }
    
    public void atualizarRow() {
        this.fireTableRowsInserted(0, 0);
    }
    
    public void addRow(Pessoas p){      
        this.getDados().add(p);
        this.fireTableDataChanged();
    }
    
    public void removeRows() {
        this.dados.clear();
        this.fireTableDataChanged();
    }
    
    public void removeRow(int rowIndex) {
        this.dados.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public List<Pessoas> getDados() {
        return dados;
    }

    public void setDados(List<Pessoas> dados) {
        this.dados = dados;
    }
    
}
