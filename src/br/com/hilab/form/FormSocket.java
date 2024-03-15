package br.com.hilab.form;

import br.com.hilab.serviceImpl.Cliente;
import br.com.hilab.serviceImpl.ConexaoSerialDataSource;
import br.com.hilab.serviceImpl.ConexaoTCPIP;
import br.com.hilab.serviceImpl.ConexaoTcpDataSource;
import br.com.hilab.serviceImpl.PossibilidadesConexao;
import conexaoArduindo.Arduino;
import java.awt.Cursor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author helayne
 */
public class FormSocket extends javax.swing.JFrame {

    private Enumeration ListasRetorno;
    public String[] retornoConexao;

    public FormSocket() {
        initComponents();
        jTextArea3.setEditable(false);
        jTextAreaSerial.setEditable(false);
        jTextArea4.setEditable(false);
        jTextArea3TcpIPservidor.setEditable(false);
        jButton2TCPip.setEnabled(false);
        jButton3Cliente.setEnabled(false);
        jButton2LigarEsq.setEnabled(false);
        jButton3DeligarEsq.setEnabled(false);
        jButton6SairEsq.setEnabled(false);
        jButton6.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton6SairEsq = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2LigarEsq = new javax.swing.JButton();
        jButton3DeligarEsq = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSerial = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2TCPip = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3TcpIPservidor = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton5 = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jRadioButton6 = new javax.swing.JRadioButton();
        jButton3Cliente = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 900));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setText("Possibilidades de Conxão ");

        jButton6SairEsq.setText("Sair");
        jButton6SairEsq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6SairEsqMouseClicked(evt);
            }
        });
        jButton6SairEsq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6SairEsqActionPerformed(evt);
            }
        });

        jLabel2.setText("Lista de Porta Serial encontrada:");

        jButton2LigarEsq.setText("Ligar");
        jButton2LigarEsq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2LigarEsqMouseClicked(evt);
            }
        });
        jButton2LigarEsq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2LigarEsqActionPerformed(evt);
            }
        });

        jButton3DeligarEsq.setText("Desligar");
        jButton3DeligarEsq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3DeligarEsqMouseClicked(evt);
            }
        });
        jButton3DeligarEsq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3DeligarEsqActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Serial - Serial");
        jRadioButton1.setToolTipText("");
        jRadioButton1.setName(""); // NOI18N
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("TCP-TCP");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("TCP-Serial");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Serial- TCP");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextAreaSerial.setEditable(false);
        jTextAreaSerial.setColumns(20);
        jTextAreaSerial.setRows(5);
        jScrollPane1.setViewportView(jTextAreaSerial);

        jButton1.setText("Conectar");
        buttonGroup1.add(jButton1);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Escolha um tipo de conexão:");

        jLabel3.setText("Conexão Serial");

        jLabel5.setText("Conexão TCP/IP");

        jButton2TCPip.setText("Ligar");
        jButton2TCPip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2TCPipMouseClicked(evt);
            }
        });
        jButton2TCPip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2TCPipActionPerformed(evt);
            }
        });

        jLabel6.setText("Conexao Servidor:");

        jLabel7.setText("Conexao Cliente:");

        jTextArea3TcpIPservidor.setColumns(20);
        jTextArea3TcpIPservidor.setRows(5);
        jScrollPane4.setViewportView(jTextArea3TcpIPservidor);

        jButton4.setText("Procurar portas");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane6.setViewportView(jTextArea3);

        jButton5.setText("ok");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setText("escolher outra conexão ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Ligar");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane5.setViewportView(jTextArea4);

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("Desligar");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jButton3Cliente.setText("Enviar");
        jButton3Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ClienteActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(368, 368, 368))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(jLabel5)
                            .addGap(297, 297, 297)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(150, 150, 150))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jRadioButton5)
                                        .addGap(46, 46, 46)
                                        .addComponent(jRadioButton6)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton3Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2TCPip, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2LigarEsq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3DeligarEsq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6SairEsq, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(76, 76, 76)
                                .addComponent(jRadioButton3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(jButton1)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jRadioButton2)
                                .addGap(124, 124, 124)
                                .addComponent(jRadioButton4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton6))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2LigarEsq)
                                .addGap(27, 27, 27)
                                .addComponent(jButton3DeligarEsq)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6SairEsq))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(33, 33, 33)
                        .addComponent(jButton5))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jButton2TCPip)
                                    .addGap(52, 52, 52)
                                    .addComponent(jButton2))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton5)
                                        .addComponent(jRadioButton6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(89, 89, 89)
                                    .addComponent(jButton3Cliente))))))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(403, 403, 403)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jRadioButton1.isSelected()) {
            jTextArea3.setEditable(false);
            jTextAreaSerial.setEditable(false);
            jTextArea4.setEditable(false);
            jTextArea3TcpIPservidor.setEditable(false);
            jButton2TCPip.setEnabled(false);
            jButton3Cliente.setEnabled(false);
            jButton2LigarEsq.setEnabled(true);
            jButton3DeligarEsq.setEnabled(true);
            jButton6SairEsq.setEnabled(false);
            jButton6.setEnabled(true);
            jButton1.setEnabled(false);
            jRadioButton1.setEnabled(false);
            jRadioButton2.setEnabled(false);
            jRadioButton3.setEnabled(false);
            jRadioButton4.setEnabled(false);
            jRadioButton5.setEnabled(false);
            jRadioButton6.setEnabled(false);

        } else if (jRadioButton2.isSelected()) {
            jTextArea3TcpIPservidor.setEditable(false);
            jTextArea3.setEditable(false);
            jTextAreaSerial.setEditable(false);
            jTextArea4.setEditable(false);
            jButton2TCPip.setEnabled(false);
            jButton3Cliente.setEnabled(false);
            jButton2LigarEsq.setEnabled(true);
            jButton3DeligarEsq.setEnabled(true);
            jButton6SairEsq.setEnabled(false);
            jButton6.setEnabled(true);
            jButton1.setEnabled(false);
            jRadioButton1.setEnabled(false);
            jRadioButton2.setEnabled(false);
            jRadioButton3.setEnabled(false);
            jRadioButton4.setEnabled(false);
            jRadioButton5.setEnabled(false);
            jRadioButton6.setEnabled(false);

            String[] retPortas = retornoPortas();

            for (int i = 0; i < retPortas.length; i++) // jTextArea3.append(retPortas[i]+"\n");
            {
                jComboBox1.addItem(retPortas[i] + "\n");
            }

        } else if (jRadioButton3.isSelected()) {
            jTextArea3.setEditable(false);
            jTextAreaSerial.setEditable(false);
            jTextArea4.setEditable(false);
            jTextArea3TcpIPservidor.setEditable(true);
            jButton2TCPip.setEnabled(true);
            jButton3Cliente.setEnabled(false);
            jButton2LigarEsq.setEnabled(false);
            jButton3DeligarEsq.setEnabled(false);
            jButton6SairEsq.setEnabled(false);
            jButton6.setEnabled(true);
            jButton1.setEnabled(false);
            jRadioButton1.setEnabled(false);
            jRadioButton2.setEnabled(false);
            jRadioButton3.setEnabled(false);
            jRadioButton4.setEnabled(false);
            jRadioButton5.setEnabled(false);
            jRadioButton6.setEnabled(false);

            String[] retPortas = retornoPortas();

            for (int i = 0; i < retPortas.length; i++) // jTextArea3.append(retPortas[i]+"\n");
            {
                jComboBox1.addItem(retPortas[i] + "\n");
            }

        } else if (jRadioButton4.isSelected()) {
            jTextArea3.setEditable(false);
            jTextAreaSerial.setEditable(false);
            jTextArea4.setEditable(false);
            jTextArea3TcpIPservidor.setEditable(true);
            jButton2TCPip.setEnabled(true);
            jButton3Cliente.setEnabled(false);
            jButton2LigarEsq.setEnabled(false);
            jButton3DeligarEsq.setEnabled(false);
            jButton6SairEsq.setEnabled(false);
            jButton6.setEnabled(false);
            jButton1.setEnabled(false);
            jRadioButton1.setEnabled(false);
            jRadioButton2.setEnabled(false);
            jRadioButton3.setEnabled(false);
            jRadioButton4.setEnabled(false);
            jRadioButton5.setEnabled(false);
            jRadioButton6.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Precione o botão 'Ligar' para iniciar o Servidor",
                    "Iniciar Servidor", JOptionPane.PLAIN_MESSAGE);

            String[] retPortas = retornoPortas();

            for (int i = 0; i < retPortas.length; i++) // jTextArea3.append(retPortas[i]+"\n");
            {
                jComboBox1.addItem(retPortas[i] + "\n");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton3DeligarEsqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3DeligarEsqActionPerformed
        //Serial para TCP/IP ou SERIal
        jTextAreaSerial.setText("");

        PossibilidadesConexao possibilidadesConexao = new PossibilidadesConexao();

        if (jRadioButton1.isSelected()) {

            try {

                Arduino arduino = new Arduino("COM1", "COM2", "--(Foi precionado o botão: " + "'" + jButton3DeligarEsq.getActionCommand() + "'.)--", "--(Foi precionado o botão: " + "'" + jButton3DeligarEsq.getActionCommand() + "'.)--");
                arduino.comunicacaoArduino(jButton2LigarEsq);
                for (int i = 0; i < arduino.tunelBidirecicionalStart.length; i++) {
                    jTextAreaSerial.append(arduino.tunelBidirecicionalStart[i] + "\n");
                }

            } catch (IOException ex) {
                Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (jRadioButton2.isSelected()) {
            //  possibilidadesConexao.startSerialToTcpTunnel("COM1", 3322, "--(Foi precionado o botão: " + "'" + jButton3DeligarEsq.getActionCommand() + "'.)--", "--(Foi precionado o botão: " + "'" + jButton3DeligarEsq.getActionCommand() + "'.)--");

        } else if (jRadioButton3.isSelected()) {
            //  possibilidadesConexao.startTcpToSerialTunnel(3322, "COM2", "--(Foi precionado o botão: " + "'" + jButton3DeligarEsq.getActionCommand() + "'.)--", "--(Foi precionado o botão: " + "'" + jButton3DeligarEsq.getActionCommand() + "'.)--");

        } else if (jRadioButton4.isSelected()) {
            // possibilidadesConexao.startTcpToTcpTunnel(9875, "LOCALHOST", 9876, "--(Foi precionado o botão: " + "'" + jButton3DeligarEsq.getActionCommand() + "'.)--", "--(Foi precionado o botão: " + "'" + jButton3DeligarEsq.getActionCommand() + "'.)--");

        }
    }//GEN-LAST:event_jButton3DeligarEsqActionPerformed

    private void jButton2LigarEsqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2LigarEsqMouseClicked

    }//GEN-LAST:event_jButton2LigarEsqMouseClicked

    private void jButton3DeligarEsqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3DeligarEsqMouseClicked

    }//GEN-LAST:event_jButton3DeligarEsqMouseClicked

    private void jButton6SairEsqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6SairEsqMouseClicked

    }//GEN-LAST:event_jButton6SairEsqMouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton2LigarEsqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2LigarEsqActionPerformed
        //Serial para TCP/IP ou SERIal
        jTextAreaSerial.setText("");
        PossibilidadesConexao possibilidadesConexao = new PossibilidadesConexao();

        if (jRadioButton1.isSelected()) {

            try {

                Arduino arduino = new Arduino("COM1", "COM2", "--(Foi precionado o botão: " + "'" + jButton2LigarEsq.getActionCommand() + "'.)--", "--(Foi precionado o botão: " + "'" + jButton2LigarEsq.getActionCommand() + "'.)--");
                arduino.comunicacaoArduino(jButton2LigarEsq);
                for (int i = 0; i < arduino.tunelBidirecicionalStart.length; i++) {
                    jTextAreaSerial.append(arduino.tunelBidirecicionalStart[i] + "\n");
                }

            } catch (IOException ex) {
                Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (jRadioButton2.isSelected()) {

            String selected = (String) jComboBox1.getSelectedItem();
            int numero = Integer.parseInt(selected.trim());
            System.out.println("Porta escolhida: " + numero);
            possibilidadesConexao.startSerialToTcpTunnel("COM2", numero, "--(Foi precionado o botão: " + "'" + jRadioButton5.getActionCommand() + "'.)--", "--(Foi precionado o botão: " + "'" + jRadioButton5.getActionCommand() + "'.)--");

            for (int i = 0; i < possibilidadesConexao.retornoConexao.length; i++) {
                jTextArea3TcpIPservidor.append(possibilidadesConexao.retornoConexao[2] + "\n");
                jTextArea3TcpIPservidor.append(possibilidadesConexao.retornoConexao[3] + "\n");
                jTextAreaSerial.append(possibilidadesConexao.retornoConexao[0] + "\n");
                jTextAreaSerial.append(possibilidadesConexao.retornoConexao[1] + "\n");
                break;
            }
        } else if (jRadioButton3.isSelected()) {
            // possibilidadesConexao.startTcpToSerialTunnel(3322, "COM1", "dadoEnviado", "dadoRecebido");

        } else if (jRadioButton4.isSelected()) {
            // possibilidadesConexao.startTcpToTcpTunnel(9875, "LOCALHOST", 9876, "dadoEnviado", "dadoRecebido");

        }

        jButton6SairEsq.setEnabled(true);
    }//GEN-LAST:event_jButton2LigarEsqActionPerformed

    private void jButton2TCPipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2TCPipMouseClicked

    }//GEN-LAST:event_jButton2TCPipMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            jTextArea3.setEditable(false);
            jTextAreaSerial.setEditable(false);
            jButton4.setEnabled(true);
            String portName = "196.196.000.000";
            int port = 9676;
            ConexaoSerialDataSource portasSerial = new ConexaoSerialDataSource(portName, port, "dadoEnviado", "dadoRecebido");
            portasSerial.retornaListaPortas();

            for (int i = 0; i < portasSerial.portas.length; i++) {
                jTextArea3.append(portasSerial.portas[i] + "\n");
            }
            jButton4.setEnabled(false);
            jButton5.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked


    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        jTextArea3.setEditable(false);
        jTextAreaSerial.setEditable(false);
        jTextArea4.setEditable(false);
        jTextArea3TcpIPservidor.setEditable(false);
        jTextArea3.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        jButton5.setEnabled(true);
        jTextArea3.setText("");
        jButton5.setEnabled(false);
        jButton4.setEnabled(true);

    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6SairEsqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6SairEsqActionPerformed
        jTextAreaSerial.setText("");
        jButton6.setEnabled(false);
        jButton2LigarEsq.setEnabled(false);
        jButton3DeligarEsq.setEnabled(false);
        jButton6SairEsq.setEnabled(false);
        jButton1.setEnabled(true);
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jRadioButton3.setEnabled(true);
        jRadioButton4.setEnabled(true);
        jTextArea3TcpIPservidor.setText("");

    }//GEN-LAST:event_jButton6SairEsqActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextAreaSerial.setText("");
        jTextArea3TcpIPservidor.setText("");
        jTextArea4.setText("");
        jButton6.setEnabled(false);
        jButton2LigarEsq.setEnabled(false);
        jButton3DeligarEsq.setEnabled(false);
        jButton6SairEsq.setEnabled(false);
        jButton1.setEnabled(true);
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jRadioButton3.setEnabled(true);
        jRadioButton4.setEnabled(true);
        jButton2TCPip.setEnabled(false);
    }//GEN-LAST:event_jButton6ActionPerformed
    class Servidor extends Thread {
    String ipDaMaquina = null;
        public void run() {
            ConexaoTCPIP conexaoTCPIP = null;
          
           try {
            ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                //TCP/IP para TCP/IP
                jButton2TCPip.setEnabled(false);
                String selected = (String) jComboBox1.getSelectedItem();
                int numero = Integer.parseInt(selected.trim());
                System.out.println("Porta escolhida: " + numero);
                conexaoTCPIP = new ConexaoTCPIP("192.168.1.151", 1100, "String dadosRecebido", "--(Foi precionado o botão servidor: " + "'" + jRadioButton5.getActionCommand() + "'.)--");
                conexaoTCPIP.open();

                jTextArea3TcpIPservidor.append("Servidor iniciando servidor no endereço: " + conexaoTCPIP.recebeDadosSocket + "\nAguardando comunição com o cliente. \n");

                for (int i = 0; i < conexaoTCPIP.dadoss.length; i++) {
                    jTextArea3TcpIPservidor.append(conexaoTCPIP.dadoss[i] + "\n");
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }
    }

    class ClienteRun extends Thread {
    String ipDaMaquina = null;
        
        public void run() {
            //TCP/IP para TCP/IP
            try {
            ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
            //String RadioButtonGetActionCommand;
            Cliente cliente;

            //jButton2TCPip.setEnabled(false);
            if (jRadioButton5.isSelected()) {

                cliente = new Cliente(ipDaMaquina, 1100, "--(Foi precionado o botão cliente: " + jRadioButton1.getActionCommand() + "'.)--", "dadoREc");
                try {
                    cliente.cliente();
                } catch (IOException ex) {
                    Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
                jTextArea4.append("O cliente se conectou com o servidor. \nOs dados recebido do servidor foram: " + cliente.receCliente);

                /*for (int i = 0; i < cliente.receCliente.length; i++) {
                    jTextArea4.append(cliente.receCliente[i] + "\n");
                    }*/
                
            } else if (jRadioButton6.isSelected()) {

                cliente = new Cliente("192.168.1.151", 1100, "--(Foi precionado o botão do cliente: " + jRadioButton2.getActionCommand() + "'.)--", "dadoREc");
                try {
                    cliente.cliente();
                } catch (IOException ex) {
                    Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
                }

                jTextArea4.append("O cliente se conectou com o servidor. \nOs dados recebido do servidor foram: " + cliente.receCliente);

                /* for (int i = 0; i < cliente.receCliente.length; i++) {
                    jTextArea4.append(cliente.receCliente[i] + "\n");
                    }*/
                

            }
        }
    }

    private void jButton2TCPipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2TCPipActionPerformed
        //TCP/IP para conexao TCP/IP ou serial
        ConexaoTCPIP conexaoTCPIP = null;
        PossibilidadesConexao possibilidadesConexao = new PossibilidadesConexao();
        jRadioButton5.setEnabled(true);
        jRadioButton6.setEnabled(true);
        jButton3Cliente.setEnabled(false);
        
        if (jRadioButton1.isSelected()) {
            //  possibilidadesConexao.startTcpToSerialTunnel(3322, "COM1", "dadoEnviado", "dadoRecebido");

        } else if (jRadioButton2.isSelected()) {
            // serial para TCP/IP
            //  possibilidadesConexao.startSerialToTcpTunnel("COM1", 3322, "dadoEnviado", "dadoRecebido");
        
        } else if (jRadioButton3.isSelected()) {
           //TCP/IP e serial
           // new Servidor().start();
           String selected = (String) jComboBox1.getSelectedItem();
            int numero = Integer.parseInt(selected.trim());
            System.out.println("Porta escolhida: " + numero);
            possibilidadesConexao.startTcpToSerialTunnel(numero, "COM2", "--(Foi precionado o botão: " + "'" + jRadioButton5.getActionCommand() + "'.)--", "--(Foi precionado o botão: " + "'" + jRadioButton5.getActionCommand() + "'.)--");
            for (int i = 0; i < possibilidadesConexao.retornoConexao.length; i++) {
                jTextArea3TcpIPservidor.append(possibilidadesConexao.retornoConexao[0] + "\n");
                jTextArea3TcpIPservidor.append(possibilidadesConexao.retornoConexao[1] + "\n");
                jTextAreaSerial.append(possibilidadesConexao.retornoConexao[2] + "\n");
                jTextAreaSerial.append(possibilidadesConexao.retornoConexao[3] + "\n");
                break;
            }
        } else if (jRadioButton4.isSelected()) {
            new Servidor().start();

        }
    }//GEN-LAST:event_jButton2TCPipActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ClienteActionPerformed
        //TCP/IP para TCP/IP
        jRadioButton5.setEnabled(false);
        jRadioButton6.setEnabled(false);
        jButton3Cliente.setEnabled(false);
        jButton2TCPip.setEnabled(true);  
        jButton6.setEnabled(true);
        
        new ClienteRun().start();
    }//GEN-LAST:event_jButton3ClienteActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jButton3Cliente.setEnabled(true);
//jRadioButton1.isSelected() 
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
       jButton3Cliente.setEnabled(true);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextAreaSerial.setText("");
        jButton6.setEnabled(false);
        jButton2LigarEsq.setEnabled(false);
        jButton3DeligarEsq.setEnabled(false);
        jButton6SairEsq.setEnabled(false);
        jButton1.setEnabled(true);
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jRadioButton3.setEnabled(true);
        jRadioButton4.setEnabled(true);
        jRadioButton5.setEnabled(false);
        jRadioButton6.setEnabled(false);
        jTextArea3TcpIPservidor.setText("");
        jTextArea4.setText("");
        jButton2.setEnabled(false);
        jButton3Cliente.setEnabled(false);
        jButton2TCPip.setEnabled(false);
        String ipDaMaquina = null;
        try {
            ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        String selected = (String) jComboBox1.getSelectedItem();
        int numeroPorta = Integer.parseInt(selected.trim());    
        ConexaoTcpDataSource conexaoTcpDataSource = new ConexaoTcpDataSource(ipDaMaquina.toLowerCase(Locale.ENGLISH), numeroPorta, "");
        
        try {
            conexaoTcpDataSource.close();
        } catch (IOException ex) {
            Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
    public String[] retornoPortas() {
        int startPort = 1024; // Porta inicial para verificar
        int endPort = 1100; // Porta final para verificar
        int retPorta = 0;
        String portString = null;
        // String[] nome = null;
        System.out.println("Portas disponíveis:");

        for (int port = startPort; port <= endPort; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close(); // Fecha o socket imediatamente para liberar a porta
                portString = String.valueOf(port);
                //System.out.println("Porta " + port + " disponível");
                // portString = String.valueOf(port);

            } catch (IOException e) {
                // A abertura do socket falhou, então a porta já está em uso
            }
        }

        String[] nome = {portString};

        return nome;

    }

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
            java.util.logging.Logger.getLogger(FormSocket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSocket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSocket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSocket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSocket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton2LigarEsq;
    private javax.swing.JButton jButton2TCPip;
    private javax.swing.JButton jButton3Cliente;
    private javax.swing.JButton jButton3DeligarEsq;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton6SairEsq;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea3TcpIPservidor;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextAreaSerial;
    // End of variables declaration//GEN-END:variables
}
