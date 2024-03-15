package br.com.hilab.serviceImpl;

import br.com.hilab.form.FormSocket;
import br.com.hilab.interfaces.DataSource;
import gnu.io.SerialPortEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author helayne
 */
// Implementação específica para fonte de dados TCP
public class ConexaoTcpDataSource implements DataSource {
   
    private String host;
    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStream inputStream = null;
    FormSocket formSocket = new FormSocket();
    private String dadosRecebido;
    public String recebeDadosSocket;
    PossibilidadesConexao possibilidadesConexao = new PossibilidadesConexao();
    ObjectOutputStream outputStream;
    ConexaoTcpDataSource cSocket ;
    
    public ConexaoTcpDataSource(String host, int port, String dadosRecebido) {
        
        this.host = host;
        this.port = port;
        this.dadosRecebido = dadosRecebido;
        
    }

    @Override
    public boolean open() throws IOException {

        // Implementando a lógica para abrir a conexão TCP
        boolean status = true;
        try {
            try {

                serverSocket = new ServerSocket(port);
                serverSocket.close(); // Fecha o socket imediatamente para liberar a porta
                this.recebeDadosSocket = "Conexão TCP/IP estabelecida com " + serverSocket.getInetAddress().getHostAddress() + port;
                System.out.println("Conexão TCP/IP estabelecida com " + serverSocket.getInetAddress().getHostAddress());
                /*JOptionPane.showMessageDialog(null, "Conexão com serverSocket TCP/IP estabelecida com: " + serverSocket.getInetAddress().getHostAddress() + "/" + port,
                        "Porta COM", JOptionPane.PLAIN_MESSAGE);*/
                status = true;
                while (true) {
                    clientSocket = serverSocket.accept(); // Este método bloqueia até que uma conexão seja estabelecida
                    JOptionPane.showMessageDialog(null, "Conexão com serverSocket TCP/IP estabelecida com: " + clientSocket.getInetAddress().getHostAddress() + "/" + port,
                        "Porta COM", JOptionPane.PLAIN_MESSAGE);
                    
                     // Exemplo de escrita de dados para o cliente
                    outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                    outputStream.flush();
                    outputStream.writeObject("Cliente conectou com sucesso");
                    
                    status = true;
                   // Fechar conexão com o cliente
                    clientSocket.close();
                    serverSocket.close();
                }
            } catch (IOException e) {
                System.err.println("Erro ao aceitar conexão: " + e.getMessage());
            }
        } catch (Exception e) {
            //  e.printStackTrace();
            JOptionPane.showMessageDialog(null, "não foi possivel a brir a porta, " + this.port + "pois ela não foi encontrada.",
                    "Porta COM", JOptionPane.PLAIN_MESSAGE);
        }

        return status;
    }
    public String[] bottunlienteSockett(JButton button, JFrame jFrame) throws IOException {

            
            button.setEnabled(true);

        return null;
    }

    @Override
    public void close() throws IOException {
        // Implementando a lógica para fechar a conexão TCP
        System.out.println("Fechando conexão TCP em " + host + ":" + port);
        if (clientSocket != null) {
            clientSocket.close();
        }

    }

    @Override
    public byte[] enviaDados(byte[] data) throws IOException {
        // Implementando lógica para enviar dados pela conexão TCP
        System.out.println("Enviando dados pela conexão TCP" + port);

        System.out.println("enviando dados pela porta TCP/IP: " + this.port);
        System.out.println("Dado enviado pra porta: " + this.port + " foi esse:  " + data + ". \n");
        String recebeDadosParaEnviar;
        byte[] recebe;
        try {
            outputStream.write(data);//escreve o valor na porta serial para ser enviado

            System.out.println("Dado enviado foi \n" + outputStream.toString());
            recebe = data;
            return recebe;
        } catch (Exception e) {
            /* JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. "+data+"\n",
                    "Enviar dados", JOptionPane.PLAIN_MESSAGE);*/
            recebeDadosParaEnviar = "Enviando dado recebido para porta TCP/IP: '" + this.port + "'. \nNão foi enviado os dados: '" + dadosRecebido + "', para a porta " + this.port + " o motivo, ela não foi localizada.\n";
        }

        recebe = recebeDadosParaEnviar.getBytes();

        return recebe;
    }

    @Override
    public byte[] receiveData() throws IOException {

        String recebe = "Recebendo dados pela porta TCP/IP: " + this.port + ".\nOs dados recebidos foram: " + this.dadosRecebido;
        System.out.println(" Recebendo dados pela porta TCP/IP: " + this.port);
        inputStream = new ByteArrayInputStream(recebe.getBytes());
        System.out.println("Dado recebido foi: \n" + inputStream.toString() + " \n");

        // Definindo o tamanho do buffer de leitura
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int bytesRead = inputStream.read(buffer);
        byte[] receivedData = new byte[bytesRead];
        // Tentando ler dados da InputStream
        try {
            if (bytesRead > 0) {
                // Se dados foram lidos, vai ser retornado apenas a parte relevante do buffer
                System.arraycopy(buffer, 0, receivedData, 0, bytesRead);
                return receivedData;
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler dados da comunicação serial" + e);

        }
        return receivedData;

    }
}
