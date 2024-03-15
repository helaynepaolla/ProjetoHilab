package conexaoArduindo;

import br.com.hilab.serviceImpl.ConexaoSerialDataSource;
import br.com.hilab.serviceImpl.PossibilidadesConexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author helayne
 */
public class Arduino {
    PossibilidadesConexao possibilidadesConexao = new PossibilidadesConexao();
    private ConexaoSerialDataSource conexaoSerialDataSource;
    private String porta1;
    private String porta2;
    private int taxa = 9600;
    private String dadoEnviado;
    private String dadoRecebido;
    public String[] tunelBidirecicionalStart = null;
    /**
   * Construtor da classe Arduino
   */
  public Arduino(String porta1,String porta2, String dadoRecebido, String dadoEnviado){
        this.porta1 = porta1;
        this.porta2 = porta2;
        this.dadoRecebido = dadoRecebido;
        this.dadoEnviado = dadoEnviado;
  }     
 
  
  /**
   * Envia o comando para a porta serial
   * @param button - Botão que é clicado na interface Java
     * @return 
     * @throws java.io.IOException
   */
  public String[] comunicacaoArduino(JButton button) throws IOException {        
    
    if("Ligar".equals(button.getActionCommand())){
        
        tunelBidirecicionalStart = possibilidadesConexao.startSerialToSerialTunnel(this.porta1, this.porta2, this.dadoRecebido, this.dadoEnviado);
        System.out.println("Foi precionado o botão: " + button.getText());

    }
    else if("Desligar".equals(button.getActionCommand())){
       
        tunelBidirecicionalStart =  possibilidadesConexao.startSerialToSerialTunnel(this.porta1, this.porta2, this.dadoRecebido, this.dadoEnviado);
        System.out.println("Foi precionado o botão: "+button.getText());
        
    }
    else{
     
      System.out.println(button.getText());//Imprime o nome do botão pressionado
    }
        return tunelBidirecicionalStart;
  }
}
