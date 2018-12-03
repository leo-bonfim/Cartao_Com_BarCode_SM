package br.com.sambamaniacos.view;
import br.com.sambamaniacos.bean.Pessoas;
import br.com.sambamaniacos.model.PessoasTableModel;
import br.com.sambamaniacos.persistence.CRUD;
import br.com.sambamaniacos.persistence.Conexao;
import br.com.sambamaniacos.Exceptions.RowDontSelectedException;
import br.com.sambamaniacos.util.ManipularImagem;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import org.opencv.core.Core;

public class Exibir extends javax.swing.JFrame {
        
    private final PreparedStatement stmt = null;
    private Conexao conn = null;
    
    private BufferedImage buff = null;
    private static boolean visibilidade;
    
    private Calendar dataAtual; 
    
    private Integer ano;
    private Integer mes;
    private Integer diaDoMes;
    private Integer hora;
    private Integer minutos;
    private Integer segundos;
    
    private String codigo;
    
    public Exibir(Conexao conn) throws ClassNotFoundException, SQLException  {
        initComponents();
        this.conn = conn;
        CRUD dao = new CRUD();
        
        visibilidade = true;
        
        if(Principal.getjTable1().getSelectedRow() != -1) {
            cmpCodigo.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getCodigo());
            cmpNome.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getNome());
            cmpApelido.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getApelido());
            cmpEmail.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getEmail());
            cmpNacionalidade.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getNacionalidade());
            ftfNascimento.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getNascimento());
            if(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getSexo().equals("M"))
                btnSexo.setText("Masculino");
            else
                btnSexo.setText("Feminino");
            cmpEndereco.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getEndereco());
            cmpCidade.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getCidade());
            ftfTelefone1.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getTelefone1());
            ftfTelefone2.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getTelefone2());
            ftfTelefone3.setText(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getTelefone3());
            
            ManipularImagem.exibiImagemLabel(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getImagem(), jLabel15);
            
            /*
            //Para a imagem
            InputStream input = new ByteArrayInputStream(dao.buscarOne(Principal.getTablemodel().getValueAt(Principal.getjTable1().getSelectedRow(), 0), conn).getImagem());
            try {
                buff = ImageIO.read(input);
                
                ImageIcon icon = new ImageIcon(buff);
                icon.setImage(icon.getImage().getScaledInstance(130, 150, 900));
                
                jLabel15.setIcon(icon);
            } catch (IOException ex) {
                ex.printStackTrace();
            }*/
        }
        else {
            visibilidade = false;
            throw new RowDontSelectedException();
        }
    }

    private void fecharJanela(Conexao conn) {
        visibilidade = false;
        try {
            conn.getConn().close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        this.dispose();
    }
    
    private String gerarCodigo() {
        dataAtual = Calendar.getInstance();
        
        ano = dataAtual.get(Calendar.YEAR);
        mes = dataAtual.get(Calendar.MONTH)+1;
        diaDoMes = dataAtual.get(Calendar.DAY_OF_MONTH);
        hora = dataAtual.get(Calendar.HOUR_OF_DAY);
        minutos = dataAtual.get(Calendar.MINUTE);
        segundos = dataAtual.get(Calendar.SECOND);
        
        return ano.toString()+mes.toString()+diaDoMes.toString()+hora.toString()+minutos.toString()+segundos.toString();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmpCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmpNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmpApelido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmpNacionalidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmpCidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmpEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmpEndereco = new javax.swing.JTextField();
        try {
            MaskFormatter m1 = new MaskFormatter("####-##-##");
            ftfNascimento = new javax.swing.JFormattedTextField(m1);
            ftfTelefone1 = new javax.swing.JFormattedTextField(new MaskFormatter("(##) ########"));
            ftfTelefone2 = new javax.swing.JFormattedTextField(new MaskFormatter("(##) #########"));
            ftfTelefone3 = new javax.swing.JFormattedTextField(new MaskFormatter("(##) #########"));
            jLabel14 = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();
            jLabel19 = new javax.swing.JLabel();
            btnSexo = new javax.swing.JTextField();
            jPanel2 = new javax.swing.JPanel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    formWindowClosed(evt);
                }
            });

            jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("Código");

            cmpCodigo.setEditable(false);
            cmpCodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            cmpCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            cmpCodigo.setText(codigo);
            cmpCodigo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmpCodigoActionPerformed(evt);
                }
            });

            jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel3.setText("Nome completo");

            cmpNome.setEditable(false);
            cmpNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            cmpNome.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmpNomeActionPerformed(evt);
                }
            });

            jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel4.setText("Apelido / Nome");

            cmpApelido.setEditable(false);
            cmpApelido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

            jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel5.setText("Sexo");

            jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel6.setText("Nascimento");

            jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel7.setText("Nacionalidade");

            cmpNacionalidade.setEditable(false);
            cmpNacionalidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            cmpNacionalidade.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmpNacionalidadeActionPerformed(evt);
                }
            });

            jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel8.setText("Cidade");

            cmpCidade.setEditable(false);
            cmpCidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);

            jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel9.setText("Telefones para contato");

            jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            jLabel11.setText("cel");

            jLabel12.setText("cel");

            jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel10.setText("Email");

            cmpEmail.setEditable(false);
            cmpEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);

            jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel13.setText("Endereço");

            cmpEndereco.setEditable(false);
            cmpEndereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);

            m1.setPlaceholderCharacter('_');
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        ftfNascimento.setEditable(false);
        ftfNascimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftfNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfNascimentoActionPerformed(evt);
            }
        });

        ftfTelefone1.setEditable(false);

        ftfTelefone2.setEditable(false);

        ftfTelefone3.setEditable(false);

        jLabel14.setText("telefone");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sambamaniacos/imagem/Messengers_0250_budy_msn-iloveimg-resized.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Foto");

        btnSexo.setEditable(false);
        btnSexo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(cmpEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmpEndereco)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmpCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSexo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftfNascimento)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(cmpNacionalidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmpCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                    .addComponent(cmpNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmpApelido)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftfTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftfTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftfTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmpCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmpNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmpApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmpNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmpCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(ftfTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(ftfTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel19))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmpEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmpCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpCodigoActionPerformed
        
    }//GEN-LAST:event_cmpCodigoActionPerformed

    private void cmpNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpNomeActionPerformed
        
    }//GEN-LAST:event_cmpNomeActionPerformed

    private void ftfNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfNascimentoActionPerformed

    private void cmpNacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpNacionalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpNacionalidadeActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.visibilidade = false;
    }//GEN-LAST:event_formWindowClosed

    public static void setJLabel15(Icon icon) {
        jLabel15.setIcon(icon);
    }
    
    public static boolean isVisibilidade() {
        return visibilidade;
    }

    public static void setVisibilidade(boolean aVisibilidade) {
        visibilidade = aVisibilidade;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField btnSexo;
    private javax.swing.JTextField cmpApelido;
    private javax.swing.JTextField cmpCidade;
    private javax.swing.JTextField cmpCodigo;
    private javax.swing.JTextField cmpEmail;
    private javax.swing.JTextField cmpEndereco;
    private javax.swing.JTextField cmpNacionalidade;
    private javax.swing.JTextField cmpNome;
    private javax.swing.JFormattedTextField ftfNascimento;
    private javax.swing.JFormattedTextField ftfTelefone1;
    private javax.swing.JFormattedTextField ftfTelefone2;
    private javax.swing.JFormattedTextField ftfTelefone3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private static javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
