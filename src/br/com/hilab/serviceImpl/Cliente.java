package br.com.hilab.serviceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author helayne
 */
public class Cliente {
    
    private String host;
    private int port;
    private String dadosRecebido;
    private String dadoEnviadoServidor;
    private ObjectInputStream objectInputStream;
    public String[] recCliente = null;
    public String receCliente = null;
    //public String[] receCliente = null;
    
    public Cliente(String host, int port, String dadosRecebido, String dadoEnviaServidor){
        
        this.host = host;
        this.port = port;
        this.dadosRecebido = dadosRecebido;
        this.dadoEnviadoServidor = dadoEnviadoServidor;
    }
    
    public/* String[] */ void cliente() throws IOException, ClassNotFoundException  {
        
            Socket clientSocket = new Socket(InetAddress.getByName(this.host), this.port);
            objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            String dadoRecebidooServidor = dadosRecebido;
            try {
            while (!dadoRecebidooServidor.equals(null)) {
                
                dadoRecebidooServidor = (String) objectInputStream.readObject();
                System.out.println("O dado que o cliente recebeu do servidor foi esse: \n" + dadoRecebidooServidor);
                //receCliente = dadoRecebidooServidor.split("O dado que o cliente enviou para o servidr foi esse: " + dadoRecebidooServidor);
                receCliente = dadoRecebidooServidor/*.split("O dado que o cliente enviou para o servidr foi esse: " + dadoRecebidooServidor)*/;
                break;
            }
            clientSocket.close();
            // return receCliente;
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }
}
