package br.com.hilab.serviceImpl;

import br.com.hilab.interfaces.DataSource;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.swing.JOptionPane;

/**
 *
 * @author helayne
 */
// Implementação específica para fonte de dados Serial
public class ConexaoSerialDataSource implements DataSource{

    private String portName;
    private OutputStream serialOut;
    private InputStream inputStream;
    private int taxa;
    private String portaCOM;
    private SerialPort serialPort;
    public  String[] portas;
    private Enumeration ListasPort;
    
    
    private String appName; //nome da aplicação
    private BufferedReader bufferedReaderInput; //objeto para leitura serial
    private OutputStream output; //objeto para escrita serial
    
    private static final int TIME_OUT = 1000;
    private static int DATA_RATE = 9600;
    
   // private String serialPortName = "COM5";
    private Enumeration portEnum;
    private String dadosEnviado;
    private String dadosRecebido;
    /**
     * Construtor da classe ControlePorta
     *
     * @param portaCOM - Porta COM que será utilizada para enviar os dados para
     * o arduino
     * @param taxa - Taxa de transferência da porta serial geralmente é 9600
     * @param dadosEnviado
     * @param dadosRecebido
     * @throws java.io.IOException
     */
    public ConexaoSerialDataSource(String portaCOM, int taxa, String dadosEnviado, String dadosRecebido) throws IOException {
        this.dadosEnviado = dadosEnviado;
        this.dadosRecebido = dadosRecebido;
        this.portName = portName;
        this.portaCOM = portaCOM;
        this.taxa = taxa;
        //open();
    }
    
    @Override
    public boolean open() throws IOException {
        boolean status = false;
        try {
            //Define uma variável portId do tipo CommPortIdentifier para realizar a comunicação serial
            
            try {
                //Tenta verificar se a porta COM informada existe
                CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
                //Abre a porta COM 
                SerialPort port = (SerialPort) portId.open("Comunicação serial", this.taxa);
                serialOut = port.getOutputStream();
                port.setSerialPortParams(this.taxa, //taxa de transferência da porta serial 
                        SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                        SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                        SerialPort.PARITY_NONE); //receber e enviar dados
            status = true;
            } catch (NoSuchPortException npe) {
                //Caso a porta COM não exista será exibido um erro 
                JOptionPane.showMessageDialog(null, "Porta " + this.portaCOM + " não encontrada.",
                        "Porta COM", JOptionPane.PLAIN_MESSAGE);
            status = false;
            }
        
        } catch (Exception e) {
            //  e.printStackTrace();
            JOptionPane.showMessageDialog(null, "não foi possivel a brir a porta, " + this.portaCOM + "pota COM não foi encontrada.",
                    "Porta COM", JOptionPane.PLAIN_MESSAGE);
        }
        return status;
    }

    /** Implementar lógica para enviar dados pela conexão Serial
     * @param data - Valor a ser enviado pela porta serial
     * @return 
     * @throws java.io.IOException
     */
    @Override
    public byte[] enviaDados(byte[] data) throws IOException {
        System.out.println("enviando dados pela porta Serial: " + this.portaCOM );
        System.out.println("Dado enviado pra porta: "+this.portaCOM+" foi esse:  "+ data+". \n" );
        String recebeDadosParaEnviar;
        byte[] recebe;
        try {
            output = serialPort.getOutputStream();
            output.write(data);//escreve o valor na porta serial para ser enviado
            System.out.println("Dado enviado foi \n" + output.toString() );
            recebe = data;
            return recebe;
        } catch (Exception e) {
            /* JOptionPane.showMessageDialog(null, "Não foi possível enviar o dado. "+data+"\n",
                    "Enviar dados", JOptionPane.PLAIN_MESSAGE);*/
            recebeDadosParaEnviar =  "Enviando dado recebido para porta: "+this.portaCOM+". \nNão foi enviado os dados: '" +this.dadosEnviado + "' para a porta " +this.portaCOM+" o motivo, porta COM não foi localizada.\n";
        }
       
        recebe = recebeDadosParaEnviar.getBytes();
        
        return recebe;
    }

    @Override
    public byte[] receiveData() throws IOException {
        String recebe = "Recebendo dados pela porta Serial: " + this.portaCOM +".\nOs dados recebidos foram: "+ this.dadosRecebido ;
        System.out.println(" Recebendo dados pela porta Serial: " + this.portaCOM );
        inputStream = new ByteArrayInputStream(recebe.getBytes());
        System.out.println("Dado recebido foi: \n" + inputStream.toString() + " \n" );
        
        // Defina o tamanho do buffer de leitura
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int bytesRead = inputStream.read(buffer);
        byte[] receivedData = new byte[bytesRead];
    // Tente ler dados da InputStream
    try {
        if (bytesRead > 0) {
            // Se dados foram lidos, retorne apenas a parte relevante do buffer
            System.arraycopy(buffer, 0, receivedData, 0, bytesRead);
            return receivedData;
        }
    } catch (Exception e) {
        System.err.println("Erro ao ler dados da comunicação serial"+e);
        
    }
        
        return receivedData;
    }
    
    /**
     * Método que fecha a comunicação com a porta serial
     *
     * @throws java.io.IOException
     */
    @Override
    public void close() throws IOException {
        // Implementando lógica para fechar a conexão Serial
        try {
            serialOut.close();
            System.out.println("Fechando conexão Serial na porta \n" + this.portaCOM );
        } catch (Exception e) {
           /*  JOptionPane.showMessageDialog(null, "Não foi possível fechar conexão da porta " + this.portaCOM + ". \n",
                    "Enviar dados", JOptionPane.PLAIN_MESSAGE);*/
            System.out.println("Fechando a conexão da porta " + this.portaCOM );
                   
        }
    }
    
    
    public String[] retornaListaPortas(){
        ListasPort = CommPortIdentifier.getPortIdentifiers();
        portas = new String[5];
        int i = 0;
        try {
            
        while( ListasPort.hasMoreElements()){
                CommPortIdentifier numeroPortas = (CommPortIdentifier) ListasPort.nextElement();
                portas[i] = numeroPortas.getName()+"  -  "+nomePorta1(numeroPortas.getPortType());
                i++;
        }
        
        
        } catch (Exception e) {
            System.err.println("Erro ao ler dados da comunicação serial" + e);
        }
       return portas;
    } 
    
   
    public String nomePorta1(int numeroPorta){
    switch(numeroPorta){
        case CommPortIdentifier.PORT_SERIAL:
             return "porta serial";
        case CommPortIdentifier.PORT_PARALLEL:
             return "porta Paralela";
        case CommPortIdentifier.PORT_I2C:
             return "porta PORT_I2C";     
        case CommPortIdentifier.PORT_RAW:
             return "porta PORT_RAW";
        case CommPortIdentifier.PORT_RS485:
             return "porta PORT_RS485";     
        default:
            return "Porta desconhecida";
    }
}

}
