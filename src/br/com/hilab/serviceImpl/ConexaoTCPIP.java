/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hilab.serviceImpl;

import br.com.hilab.form.FormSocket;
import gnu.io.SerialPort;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author helayne
 */
public class ConexaoTCPIP {

    private String host;
    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStream inputStream = null;
    FormSocket formSocket = new FormSocket();
    private String dadosRecebido;
    private String dadosEnviado;
    public String recebeDadosSocket;
    PossibilidadesConexao possibilidadesConexao = new PossibilidadesConexao();
    public ObjectOutputStream outputStream;
    ConexaoTcpDataSource cSocket;
    public String[] dadoss;

    public ConexaoTCPIP(String host, int port, String dadosRecebido, String dadosEnviado) {

        this.host = host;
        this.port = port;
        this.dadosRecebido = dadosRecebido;
        this.dadosEnviado = dadosEnviado;
    }

    public boolean open() throws IOException {

        // Implementando a lógica para abrir a conexão TCP
        boolean status = true;
        try {
            try {

                serverSocket = new ServerSocket(port);
                // serverSocket.close(); // Fecha o socket imediatamente para liberar a porta
                this.recebeDadosSocket = "Conexão TCP/IP estabelecida com " + serverSocket.getInetAddress().getHostAddress() + port;
                System.out.println("Conexão TCP/IP estabelecida com " + serverSocket.getInetAddress().getHostAddress());
                /*JOptionPane.showMessageDialog(null, "Conexão com serverSocket TCP/IP estabelecida com: " + serverSocket.getInetAddress().getHostAddress() + "/" + port,
                        "Porta COM", JOptionPane.PLAIN_MESSAGE);*/

                while (true) {
                    JOptionPane.showMessageDialog(null, "O Servidor foi iniciado.\nEsperando o cliente se conectar. \nPara o cliente se conectar:\n"
                            + "Selecione as opções 'LIGAR' ou 'DESLIGAR' após selecionado click em enviar. ",
                            "Conexão Servidor", JOptionPane.PLAIN_MESSAGE);
                    clientSocket = serverSocket.accept(); // Este método bloqueia até que uma conexão seja estabelecida

                    // Exemplo de escrita de dados para o cliente
                    outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                    outputStream.flush();
                    outputStream.writeObject(this.dadosEnviado);
                    
                    String[] dados = {"O cliente se conectou no endereço: " + clientSocket.getInetAddress().getHostAddress() + ".\nOs dados enviados ao cliente foram: " + this.dadosEnviado};
                    dadoss = dados;
                    status = true;

                    break;
               }
                
               
            } catch (IOException e) {
                System.err.println("Erro ao aceitar conexão: " + e.getMessage());
            } 
        } catch (Exception e) {
            //  e.printStackTrace();
            JOptionPane.showMessageDialog(null, "não foi possivel a brir a porta, " + this.port + "pois ela não foi encontrada.",
                    "Porta COM", JOptionPane.PLAIN_MESSAGE);
        }
        
         // Fecha o socket do servidor
                   clientSocket.close();
                   outputStream.close();   
                   serverSocket.close();
        
        return status;
    }

    

}
