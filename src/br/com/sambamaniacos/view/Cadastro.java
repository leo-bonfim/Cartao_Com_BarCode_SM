package br.com.sambamaniacos.view;
import br.com.sambamaniacos.bean.Pessoas;
import br.com.sambamaniacos.persistence.CRUD;
import br.com.sambamaniacos.persistence.Conexao;
import br.com.sambamaniacos.util.ManipularImagem;
import com.mysql.jdbc.MysqlIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class Cadastro extends javax.swing.JFrame {
        
    private final PreparedStatement stmt = null;
    private Conexao conn = null;
    
    private static boolean visibilidade; 
    
    private Calendar dataAtual; 
    
    private String ano;
    private String mes;
    private String diaDoMes;
    private String hora;
    private String minutos;
    private BufferedImage imagem;
    
    private String codigo;
    
    public Cadastro(Conexao conn) throws ClassNotFoundException, SQLException  {
        visibilidade = true;
        
        codigo = gerarCodigo();
        
        this.conn = conn;
        
        initComponents();
        
    }

    private String gerarCodigo() {
        dataAtual = Calendar.getInstance();
        
        //Ano
        ano = Integer.toString(dataAtual.get(Calendar.YEAR));
        //
        //Mês
        switch(dataAtual.get(Calendar.MONTH)+1) {
            case 1:
                mes = "01";
                break;
            case 2:
                mes = "02";
                break;
            case 3:
                mes = "03";
                break;
            case 4:
                mes = "04";
                break;
            case 5:
                mes = "05";
                break;
            case 6:
                mes = "06";
                break;
            case 7:
                mes = "07";
                break;
            case 8:
                mes = "08";
                break;
            case 9:
                mes = "09";
                break;
            default:
                mes = Integer.toString(dataAtual.get(Calendar.MONTH)+1);
                break;
        }
        //
        //Dia do Mês
        switch(dataAtual.get(Calendar.DAY_OF_MONTH)) {
            case 1:
                diaDoMes = "01";
                break;
            case 2:
                diaDoMes = "02";
                break;
            case 3:
                diaDoMes = "03";
                break;
            case 4:
                diaDoMes = "04";
                break;
            case 5:
                diaDoMes = "05";
                break;
            case 6:
                diaDoMes = "06";
                break;
            case 7:
                diaDoMes = "07";
                break;
            case 8:
                diaDoMes = "08";
                break;
            case 9:
                diaDoMes = "09";
                break;
            default:
                diaDoMes = Integer.toString(dataAtual.get(Calendar.DAY_OF_MONTH));
                break;
        }
        //    
        //Hora
        switch(dataAtual.get(Calendar.HOUR_OF_DAY)) {
            case 1:
                hora = "01";
                break;
            case 2:
                hora = "02";
                break;
            case 3:
                hora = "03";
                break;
            case 4:
                hora = "04";
                break;
            case 5:
                hora = "05";
                break;
            case 6:
                hora = "06";
                break;
            case 7:
                hora = "07";
                break;
            case 8:
                hora = "08";
                break;
            case 9:
                hora = "09";
                break;
            default:
                hora = Integer.toString(dataAtual.get(Calendar.HOUR_OF_DAY));
                break;
        }
        //
        //Minutos
        switch(dataAtual.get(Calendar.MINUTE)) {
            case 0:
                minutos = "00";
                break;
            case 1:
                minutos = "01";
                break;
            case 2:
                minutos = "02";
                break;
            case 3:
                minutos = "03";
                break;
            case 4:
                minutos = "04";
                break;
            case 5:
                minutos = "05";
                break;
            case 6:
                minutos = "06";
                break;
            case 7:
                minutos = "07";
                break;
            case 8:
                minutos = "08";
                break;
            case 9:
                minutos = "09";
                break;
            default:
                minutos = Integer.toString(dataAtual.get(Calendar.MINUTE));
                break;
        }
        //
        return ano+mes+diaDoMes+hora+minutos;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmpCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmpNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmpApelido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
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
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cmpEndereco = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        try {
            MaskFormatter m1 = new MaskFormatter("####-##-##");
            ftfNascimento = new javax.swing.JFormattedTextField(m1);
            ftfTelefone1 = new javax.swing.JFormattedTextField(new MaskFormatter("(##) ########"));
            ftfTelefone2 = new javax.swing.JFormattedTextField(new MaskFormatter("(##) #########"));
            ftfTelefone3 = new javax.swing.JFormattedTextField(new MaskFormatter("(##) #########"));
            jLabel14 = new javax.swing.JLabel();
            jLabel16 = new javax.swing.JLabel();
            jLabel17 = new javax.swing.JLabel();
            jLabel18 = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();
            jButton4 = new javax.swing.JButton();
            jLabel19 = new javax.swing.JLabel();
            jButton1 = new javax.swing.JButton();
            jLabel20 = new javax.swing.JLabel();
            cmpCpf = new javax.swing.JTextField();
            jPanel2 = new javax.swing.JPanel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    formWindowClosed(evt);
                }
            });

            jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Cadastro de Maníacos");

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
            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            jLabel3.setText("Nome completo");

            cmpNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            cmpNome.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmpNomeActionPerformed(evt);
                }
            });

            jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel4.setText("Apelido / Nome");

            cmpApelido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

            jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel5.setText("Sexo");

            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
            jComboBox1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jComboBox1ActionPerformed(evt);
                }
            });

            jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            jLabel6.setText("Nascimento");

            jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel7.setText("Nacionalidade");

            cmpNacionalidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            cmpNacionalidade.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmpNacionalidadeActionPerformed(evt);
                }
            });

            jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            jLabel8.setText("Cidade");

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

            cmpEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);

            btnCadastrar.setText("Cadastrar");
            btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCadastrarActionPerformed(evt);
                }
            });

            btnLimpar.setText("Limpar");
            btnLimpar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnLimparActionPerformed(evt);
                }
            });

            jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel13.setText("Endereço");

            cmpEndereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);

            btnSair.setText("Sair");
            btnSair.setPreferredSize(new java.awt.Dimension(65, 23));
            btnSair.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSairActionPerformed(evt);
                }
            });

            m1.setPlaceholderCharacter('_');
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        ftfNascimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftfNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfNascimentoActionPerformed(evt);
            }
        });

        jLabel14.setText("telefone");

        jLabel16.setText("*");
        jLabel16.setForeground(Color.RED);

        jLabel17.setText("*");
        jLabel17.setForeground(Color.RED);

        jLabel18.setText("*");
        jLabel18.setForeground(Color.RED);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sambamaniacos/imagem/Messengers_0250_budy_msn-iloveimg-resized.png"))); // NOI18N

        jButton4.setText("Tirar foto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Foto");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sambamaniacos/imagem/image-iloveimg-resized.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("CPF");

        cmpCpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmpCodigo, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(ftfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmpNacionalidade)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cmpCidade)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmpNome, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmpApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
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
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(cmpCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmpEndereco)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addComponent(jLabel8)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmpNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmpCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmpEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(cmpCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Pessoas modelo = new Pessoas();
        CRUD crud = new CRUD();     
        
        if(jLabel15.getIcon() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma imagem", "Alerta", JOptionPane.OK_OPTION);
            return;
        }
        
        //ImageIcon to BufferedImage
        imagem = new BufferedImage(
        jLabel15.getIcon().getIconWidth(),
        jLabel15.getIcon().getIconHeight(),
        BufferedImage.TYPE_INT_RGB);
        Graphics g = imagem.createGraphics();
        // paint the Icon to the BufferedImage.
        jLabel15.getIcon().paintIcon(null, g, 0,0);
        g.dispose();
        
        try {
            ImageIO.write(imagem, "JPEG", baos);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        modelo.setCodigo(codigo);
        modelo.setNome(cmpNome.getText());
        modelo.setApelido(cmpApelido.getText());
        modelo.setEndereco(cmpEndereco.getText());
        modelo.setCidade(cmpCidade.getText());
        modelo.setTelefone1(ftfTelefone1.getText());
        modelo.setTelefone2(ftfTelefone2.getText());
        modelo.setTelefone3(ftfTelefone3.getText());
        modelo.setNascimento(ftfNascimento.getText());
        modelo.setSituação("pendente");
        //Fazedo a conversão da Label Sexo
            String sexoaux;
            if(((String)jComboBox1.getSelectedItem()).equals("Masculino"))
                sexoaux = "M";
            else
                sexoaux = "F";
        //
        modelo.setSexo(sexoaux);
        modelo.setNacionalidade(cmpNacionalidade.getText());
        modelo.setEmail(cmpEmail.getText());
        modelo.setImagem(baos.toByteArray());
        modelo.setCpf(cmpCpf.getText());
        
        crud.persistir(modelo, conn);
        if(CRUD.returnException == false) {
            
            Principal.getTablemodel().getDados().add(modelo);
            Principal.getTablemodel().atualizarRow();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado!", "Alerta", JOptionPane.OK_OPTION);
            
        }
        else {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o maníaco. Verifique se a data está no padrão aaaa/mm/dd", "Alerta", JOptionPane.OK_OPTION);
            CRUD.returnException = false;
            return;
        }

        this.dispose();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void ftfNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfNascimentoActionPerformed

    private void cmpNacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmpNacionalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmpNacionalidadeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Snapshot().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        cmpEndereco.setText("");
        cmpNome.setText("");
        cmpApelido.setText("");
        cmpNacionalidade.setText("");
        cmpCidade.setText("");
        cmpEmail.setText("");
        
        codigo = gerarCodigo();
        cmpCodigo.setText(codigo);

    }//GEN-LAST:event_btnLimparActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        visibilidade = false;
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);

                jLabel15.setIcon(new ImageIcon(imagem));

            } catch (Exception ex) {
               // System.out.println(ex.printStackTrace().toString());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void setJLabel15(Icon icon) {
        jLabel15.setIcon(icon);
    }
    
    public static javax.swing.JLabel getjLabel15() {
        return jLabel15;
    }
    
    public static boolean isVisibilidade() {
        return visibilidade;
    }

    public static void setVisibilidade(boolean aVisibilidade) {
        visibilidade = aVisibilidade;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JTextField cmpApelido;
    private javax.swing.JTextField cmpCidade;
    private javax.swing.JTextField cmpCodigo;
    private javax.swing.JTextField cmpCpf;
    private javax.swing.JTextField cmpEmail;
    private javax.swing.JTextField cmpEndereco;
    private javax.swing.JTextField cmpNacionalidade;
    private javax.swing.JTextField cmpNome;
    private javax.swing.JFormattedTextField ftfNascimento;
    private javax.swing.JFormattedTextField ftfTelefone1;
    private javax.swing.JFormattedTextField ftfTelefone2;
    private javax.swing.JFormattedTextField ftfTelefone3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private static javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
