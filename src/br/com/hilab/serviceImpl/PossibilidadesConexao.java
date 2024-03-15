package br.com.hilab.serviceImpl;

import br.com.hilab.form.FormSocket;
import br.com.hilab.interfaces.DataSource;
import gnu.io.CommPortIdentifier;
import java.awt.Button;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author helayne
 */
public class PossibilidadesConexao {
    
    private DataSource source1;
    private DataSource source2;
    private int taxa;
    private Enumeration ListasRetorno;
    public  String[] retornoConexao; 
    
    public String[] tunelBidirecicional(DataSource sourcee1, DataSource sourcee2) throws UnsupportedEncodingException {
       
        // Criar e iniciar o túnel
        TunelBidirecional dataTunnel = new TunelBidirecional(sourcee1, sourcee2);
        retornoConexao = dataTunnel.startTunnel();
        return retornoConexao;
    }
    
    // Implementando a lógica do túnel serial-serial
    public String[] startSerialToSerialTunnel(String serialPort1, String serialPort2, String dadosEnviado, String dadoRecebido) throws IOException {
        source1 = new ConexaoSerialDataSource(serialPort1, taxa, dadosEnviado, dadoRecebido);
        source2 = new ConexaoSerialDataSource(serialPort2, taxa, dadosEnviado, dadoRecebido);
        
        
        retornoConexao = tunelBidirecicional(source1, source2);

        return retornoConexao;
    }
    
    
    // Implementando a lógica do túnel serial-TCP
    
    public void startSerialToTcpTunnel(String serialPort, int tcpPort, String dadosEnviado, String dadoRecebido) {
        try {
             String ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
         
        source1 = new ConexaoSerialDataSource(serialPort, taxa, dadosEnviado, dadoRecebido);
        source2 = new ConexaoTcpDataSource(ipDaMaquina.toLowerCase(Locale.ENGLISH), tcpPort,dadoRecebido);
        
        retornoConexao = tunelBidirecicional(source1, source2);
        
        
        } catch (IOException ex) {
            Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("startSerialToTcpTunnel");
        }
    }
    
    // Implementando a lógica do túnel TCP-serial
   
    public String[] startTcpToSerialTunnel(int tcpPort, String serialPort, String dadosEnviado, String dadoRecebido) {
        try {
            String ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
            source1 = new ConexaoTcpDataSource(ipDaMaquina.toLowerCase(Locale.ENGLISH), tcpPort, dadoRecebido);
            source2 = new ConexaoSerialDataSource(serialPort, taxa, dadosEnviado, dadoRecebido);

            retornoConexao = tunelBidirecicional(source1, source2);

        } catch (IOException ex) {
            Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);

        }
        return retornoConexao;
    }
    
    // Implementando a lógica do túnel TCP-TCP
    public void startTcpToTcpTunnel(int localPort, String remoteHost, int remotePort, String dadosEnviado, String dadoRecebido) {
         try {
            String ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
            
    
        source1 = new ConexaoTcpDataSource( ipDaMaquina.toLowerCase(Locale.ENGLISH), localPort, dadoRecebido);
        source2 = new ConexaoTcpDataSource( ipDaMaquina.toLowerCase(Locale.ENGLISH), remotePort, dadoRecebido);
        
        tunelBidirecicional(source1, source2);
                
        } catch (IOException ex) {
            Logger.getLogger(FormSocket.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
   
 }
    

