package br.com.sambamaniacos.view;

import br.com.sambamaniacos.bean.Pessoas;
import br.com.sambamaniacos.model.PessoasTableModel;
import br.com.sambamaniacos.persistence.CRUD;
import br.com.sambamaniacos.persistence.Conexao;
import br.com.sambamaniacos.Exceptions.RowDontSelectedException;
import br.com.sambamaniacos.model.GerarPDF;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.opencv.core.Core;

public class Principal extends javax.swing.JFrame {

    private Conexao conn = null;
    private static PessoasTableModel tablemodel = new PessoasTableModel();
    
    public enum Action{
        NORMAL, B_CODIGO, B_NOME, B_CPF;
    }
    
    public Principal() {
        
        initComponents();
        btnTrocaPendente.setToolTipText("Troca a situação para PENDENTE");
        cmpLocalizarpCpf.setToolTipText("Caso busque pelo CPF com o campo vazio aparecerá apenas os maníacos com CPF, os que não tem não aparecerão! Para corrigir, dê enter no campo Localizar por Nome");

        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        gerarTabela("Select codigo, nome, apelido, cpf, telefone2, cidade, situacao from pessoas order by nome", Action.NORMAL);
        
    }
    
    public void gerarTabela(String sql, Action action) {
        
        if(conn == null) {
            conn = new Conexao();
            conn.getConexao();
        }
        
        CRUD dao = new CRUD();
        Pessoas p = new Pessoas();
        
        dao.gerarResultSet(sql, conn, action);
        
        try {

            while(dao.getRs().next()) {
                
                getTablemodel().addRow(dao.buscarAll());
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        jTable1.setModel(tablemodel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmpLocalizarpc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmpLocalizarpn = new javax.swing.JTextField();
        btnPdf = new javax.swing.JButton();
        btnExibir = new javax.swing.JButton();
        btnTrocaPendente = new javax.swing.JButton();
        jcbChange = new javax.swing.JComboBox<>();
        lblLocalizarpCpf = new javax.swing.JLabel();
        cmpLocalizarpCpf = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sambamaniacos/imagem/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setToolTipText("");
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setMargin(new java.awt.Insets(4, 14, 2, 14));
        btnNovo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sambamaniacos/imagem/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setHideActionText(true);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setMargin(new java.awt.Insets(5, 14, 2, 14));
        btnEditar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sambamaniacos/imagem/delete.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeletar.setMargin(new java.awt.Insets(4, 14, 2, 14));
        btnDeletar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnDeletar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setToolTipText("");
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Localizar por código");

        cmpLocalizarpc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmpLocalizarpcFocusLost(evt);
            }
        });
        cmpLocalizarpc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmpLocalizarpcKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Localizar por nome");

        cmpLocalizarpn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmpLocalizarpnFocusLost(evt);
            }
        });
        cmpLocalizarpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpLocalizarpnActionPerformed(evt);
            }
        });
        cmpLocalizarpn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmpLocalizarpnKeyPressed(evt);
            }
        });

        btnPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sambamaniacos/imagem/Files-Pdf-icon-iloveimg-resized (1).png"))); // NOI18N
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        btnExibir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sambamaniacos/imagem/lupa_by_jla75-d2xfz2x-iloveimg-resized (2).png"))); // NOI18N
        btnExibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExibirActionPerformed(evt);
            }
        });

        btnTrocaPendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sambamaniacos/imagem/troca-iloveimg-resized.png"))); // NOI18N
        btnTrocaPendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrocaPendenteActionPerformed(evt);
            }
        });

        jcbChange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pendente", "entregue", "pdf gerado" }));

        lblLocalizarpCpf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLocalizarpCpf.setText("Localizar por CPF");

        cmpLocalizarpCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmpLocalizarpCpfFocusLost(evt);
            }
        });
        cmpLocalizarpCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmpLocalizarpCpfActionPerformed(evt);
            }
        });
        cmpLocalizarpCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmpLocalizarpCpfKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmpLocalizarpc, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmpLocalizarpn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmpLocalizarpCpf)
                            .addComponent(lblLocalizarpCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExibir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTrocaPendente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jcbChange, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lblLocalizarpCpf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmpLocalizarpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmpLocalizarpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmpLocalizarpCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExibir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jcbChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTrocaPendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Controle de Clientes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1012, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if((Editar.isVisibilidade() == false) && (Cadastro.isVisibilidade() == false) && (Exibir.isVisibilidade() == false)) {
            try {
                new Cadastro(conn).setVisible(true);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                System.out.println("Não foi possivel se conectar ao banco de dados");
            }
        }
        else
            if(Cadastro.isVisibilidade() == true)
                JOptionPane.showMessageDialog(null, "Existe uma tela de cadastro aberta!", "Alerta", JOptionPane.OK_OPTION);
            else
                if(Editar.isVisibilidade() == true)
                    JOptionPane.showMessageDialog(null, "Existe uma tela de edição aberta!", "Alerta", JOptionPane.OK_OPTION);
                else
                    if(Exibir.isVisibilidade() == true)
                        JOptionPane.showMessageDialog(null, "Existe uma tela de exibir aberta!", "Alerta", JOptionPane.OK_OPTION);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed

        if(getjTable1().getSelectedRow() != -1) {
            int confirmacao = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir?", "Exclusão",JOptionPane.YES_NO_OPTION);
            if(confirmacao == 0) {
                Pessoas modelo = new Pessoas();
                modelo.setCodigo((String)getjTable1().getValueAt(getjTable1().getSelectedRow(), 0));
                CRUD dao = new CRUD();
                dao.remover(modelo, conn);
                tablemodel.removeRow(getjTable1().getSelectedRow());
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela primeiro!", "Alerta", JOptionPane.OK_OPTION);
        
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Editar editar = null;
        if((Editar.isVisibilidade() == false) && (Cadastro.isVisibilidade() == false) && (Exibir.isVisibilidade() == false)) {
            try {
                editar = new Editar(conn);
                editar.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (RowDontSelectedException ex) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela primeiro!", "Alerta", JOptionPane.OK_OPTION);
            }
        }
        
        else
            if(Editar.isVisibilidade() == true)
                JOptionPane.showMessageDialog(null, "Existe uma tela de edição aberta!", "Alerta", JOptionPane.OK_OPTION);
            else
                if(Cadastro.isVisibilidade() == true)
                    JOptionPane.showMessageDialog(null, "Existe uma tela de cadastro aberta!", "Alerta", JOptionPane.OK_OPTION);
                else
                    if(Exibir.isVisibilidade() == true)
                        JOptionPane.showMessageDialog(null, "Existe uma tela de exibir aberta!", "Alerta", JOptionPane.OK_OPTION);    
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void cmpLocalizarpcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmpLocalizarpcKeyPressed
        
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {  
            tablemodel.removeRows();
            
            CRUD dao = new CRUD();
            
            gerarTabela("Select codigo, nome, apelido, cpf, telefone2, cidade, situacao from pessoas where codigo like ? order by nome", Action.B_CODIGO);
        }  
        
    }//GEN-LAST:event_cmpLocalizarpcKeyPressed

    private void cmpLocalizarpcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmpLocalizarpcFocusLost
        cmpLocalizarpc.setText("");
    }//GEN-LAST:event_cmpLocalizarpcFocusLost

    private void cmpLocalizarpnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmpLocalizarpnKeyPressed
        
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {  
            tablemodel.removeRows();
            
            CRUD dao = new CRUD();
            
            gerarTabela("Select codigo, nome, apelido, cpf, telefone2, cidade, situacao from pessoas where nome like ? order by nome", Action.B_NOME);
            
        }  
        
    }//GEN-LAST:event_cmpLocalizarpnKeyPressed

    private void cmpLocalizarpnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmpLocalizarpnFocusLost
        cmpLocalizarpn.setText("");
    }//GEN-LAST:event_cmpLocalizarpnFocusLost

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        CRUD dao = new CRUD();
        String situation = "pdf gerado";
        
        if(jTable1.getSelectedRow() != -1) {
            if(jTable1.getSelectedRowCount() == 1) {
                
                Pessoas modelo = new Pessoas();
                modelo = dao.buscarOne(jTable1.getValueAt(jTable1.getSelectedRow(), 0), conn);
                
                GerarPDF gpdf = new GerarPDF(modelo);
                
                //Mudando o Status da Situação para PDF GERADO
                modelo.setSituação(situation);
                
                dao.updatesSituacao(modelo, conn);

                getTablemodel().setValueAt(modelo.getSituação(), Principal.getjTable1().getSelectedRow(), 6);
                
            }
            else
                if(jTable1.getSelectedRowCount()== 2) {
                    
                    Pessoas modelo = new Pessoas();
                    Pessoas modelo2 = new Pessoas();
                    
                    modelo = dao.buscarOne(jTable1.getValueAt(jTable1.getSelectedRows()[0], 0), conn);
                    modelo2 = dao.buscarOne(jTable1.getValueAt(jTable1.getSelectedRows()[1], 0), conn);
                    
                    GerarPDF gpdf = new GerarPDF(modelo, modelo2);
                    
                    //Mudando o Status da Situação para PDF GERADO
                    modelo.setSituação(situation);
                    modelo2.setSituação(situation);
                    
                    dao.updatesSituacao(modelo, conn);
                    dao.updatesSituacao(modelo2, conn);
                    
                    getTablemodel().setValueAt(modelo.getSituação(), jTable1.getSelectedRows()[0], 6);
                    getTablemodel().setValueAt(modelo2.getSituação(), jTable1.getSelectedRows()[1], 6);
                    
                }
                else
                    if(jTable1.getSelectedRowCount()== 3) {
                        
                    Pessoas modelo = new Pessoas();
                    Pessoas modelo2 = new Pessoas();
                    Pessoas modelo3 = new Pessoas();
                    
                    modelo = dao.buscarOne(jTable1.getValueAt(jTable1.getSelectedRows()[0], 0), conn);
                    modelo2 = dao.buscarOne(jTable1.getValueAt(jTable1.getSelectedRows()[1], 0), conn);
                    modelo3 = dao.buscarOne(jTable1.getValueAt(jTable1.getSelectedRows()[2], 0), conn);
                    
                    GerarPDF gpdf = new GerarPDF(modelo, modelo2, modelo3);
                    
                    //Mudando o Status da Situação para PDF GERADO
                    modelo.setSituação(situation);
                    modelo2.setSituação(situation);
                    modelo3.setSituação(situation);
                    
                    dao.updatesSituacao(modelo, conn);
                    dao.updatesSituacao(modelo2, conn);
                    dao.updatesSituacao(modelo3, conn);
                    
                    getTablemodel().setValueAt(modelo.getSituação(), jTable1.getSelectedRows()[0], 6);
                    getTablemodel().setValueAt(modelo2.getSituação(), jTable1.getSelectedRows()[1], 6);
                    getTablemodel().setValueAt(modelo3.getSituação(), jTable1.getSelectedRows()[2], 6);
                    
                    }
                    else
                        if(jTable1.getSelectedRowCount()== 4) {
                            
                            Pessoas modelo = new Pessoas();
                            Pessoas modelo2 = new Pessoas();
                            Pessoas modelo3 = new Pessoas();
                            Pessoas modelo4 = new Pessoas();

                            modelo = dao.buscarOne(jTable1.getValueAt(jTable1.getSelectedRows()[0], 0), conn);
                            modelo2 = dao.buscarOne(jTable1.getValueAt(jTable1.getSelectedRows()[1], 0), conn);
                            modelo3 = dao.buscarOne(jTable1.getValueAt(jTable1.getSelectedRows()[2], 0), conn);
                            modelo4 = dao.buscarOne(jTable1.getValueAt(jTable1.getSelectedRows()[3], 0), conn);

                            GerarPDF gpdf = new GerarPDF(modelo, modelo2, modelo3, modelo4);
                            
                            //Mudando o Status da Situação para PDF GERADO
                            modelo.setSituação(situation);
                            modelo2.setSituação(situation);
                            modelo3.setSituação(situation);
                            modelo4.setSituação(situation);

                            dao.updatesSituacao(modelo, conn);
                            dao.updatesSituacao(modelo2, conn);
                            dao.updatesSituacao(modelo3, conn);
                            dao.updatesSituacao(modelo4, conn);

                            getTablemodel().setValueAt(modelo.getSituação(), jTable1.getSelectedRows()[0], 6);
                            getTablemodel().setValueAt(modelo2.getSituação(), jTable1.getSelectedRows()[1], 6);
                            getTablemodel().setValueAt(modelo3.getSituação(), jTable1.getSelectedRows()[2], 6);
                            getTablemodel().setValueAt(modelo4.getSituação(), jTable1.getSelectedRows()[3], 6);
                            
                        }
        }
        else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela primeiro!", "Alerta", JOptionPane.OK_OPTION);
        }
        
        System.out.println("O item selecionado é " + jTable1.getSelectedRow());
    }//GEN-LAST:event_btnPdfActionPerformed

    private void btnExibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExibirActionPerformed
        
        Exibir editar = null;
        if((Editar.isVisibilidade() == false) && (Cadastro.isVisibilidade() == false) && (Exibir.isVisibilidade() == false)) {
            try {
                editar = new Exibir(conn);
                editar.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (RowDontSelectedException ex) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela primeiro!", "Alerta", JOptionPane.OK_OPTION);
            }
        }
        
        else
            if(Editar.isVisibilidade() == true)
                JOptionPane.showMessageDialog(null, "Existe uma tela de edição aberta!", "Alerta", JOptionPane.OK_OPTION);
            else
                if(Cadastro.isVisibilidade() == true)
                    JOptionPane.showMessageDialog(null, "Existe uma tela de cadastro aberta!", "Alerta", JOptionPane.OK_OPTION);
                else
                    if(Exibir.isVisibilidade() == true)
                        JOptionPane.showMessageDialog(null, "Existe uma tela de exibir aberta!", "Alerta", JOptionPane.OK_OPTION);
        
    }//GEN-LAST:event_btnExibirActionPerformed

    private void btnTrocaPendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrocaPendenteActionPerformed
        
        CRUD dao = new CRUD();
        List<Pessoas> listaDeModelos = new ArrayList<Pessoas>();
        int i = 0;
        while(i != jTable1.getSelectedRows().length) {
            listaDeModelos.add(new Pessoas());
            listaDeModelos.get(i).setSituação((String) jcbChange.getSelectedItem());
            listaDeModelos.get(i).setCodigo((String) getTablemodel().getValueAt(jTable1.getSelectedRows()[i], 0));
            dao.updatesSituacao(listaDeModelos.get(i), conn);
            getTablemodel().setValueAt(listaDeModelos.get(i).getSituação(), jTable1.getSelectedRows()[i], 6);
            i++;
        }
        
    }//GEN-LAST:event_btnTrocaPendenteActionPerformed

    private void cmpLocalizarpCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpLocalizarpCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpLocalizarpCpfActionPerformed

    private void cmpLocalizarpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpLocalizarpnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpLocalizarpnActionPerformed

    private void cmpLocalizarpCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmpLocalizarpCpfKeyPressed
        
        
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {  
            tablemodel.removeRows();
            
            CRUD dao = new CRUD();
            
            gerarTabela("Select codigo, nome, apelido, cpf, telefone2, cidade, situacao from pessoas where cpf like ? order by nome", Action.B_CPF);
            
        }  
        
    }//GEN-LAST:event_cmpLocalizarpCpfKeyPressed

    private void cmpLocalizarpCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmpLocalizarpCpfFocusLost
        cmpLocalizarpCpf.setText("");
    }//GEN-LAST:event_cmpLocalizarpCpfFocusLost

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExibir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnTrocaPendente;
    private static javax.swing.JTextField cmpLocalizarpCpf;
    private static javax.swing.JTextField cmpLocalizarpc;
    private static javax.swing.JTextField cmpLocalizarpn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbChange;
    private javax.swing.JLabel lblLocalizarpCpf;
    // End of variables declaration//GEN-END:variables

    public static PessoasTableModel getTablemodel() {
        return tablemodel;
    }

    public static void setTablemodel(PessoasTableModel aTablemodel) {
        tablemodel = aTablemodel;
    }

    public static javax.swing.JTable getjTable1() {
        return jTable1;
    }

    public static void setjTable1(javax.swing.JTable ajTable1) {
        jTable1 = ajTable1;
    }

    public static javax.swing.JTextField getCmplocalizarpc() {
        return cmpLocalizarpc;
    }

    public static void setCmplocalizarpc(javax.swing.JTextField aCmplocalizarpc) {
        cmpLocalizarpc = aCmplocalizarpc;
    }

    public static javax.swing.JTextField getCmplocalizarpn() {
        return cmpLocalizarpn;
    }

    public static void setCmplocalizarpn(javax.swing.JTextField aCmpLocalizarpn) {
        cmpLocalizarpn = aCmpLocalizarpn;
    }
    
    public static javax.swing.JTextField getCmplocalizarpCpf() {
        return cmpLocalizarpCpf;
    }

    public static void setCmplocalizarpCpf(javax.swing.JTextField aCmpLocalizarpCpf) {
        cmpLocalizarpCpf = aCmpLocalizarpCpf;
    }
}
