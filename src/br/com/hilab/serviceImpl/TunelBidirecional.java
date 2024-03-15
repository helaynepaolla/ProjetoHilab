package br.com.hilab.serviceImpl;

import br.com.hilab.interfaces.DataSource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author helayne
 */

// Classe principal que representa o túnel entre duas fontes de dados Bidirecional
public class TunelBidirecional {
    
    private DataSource source1 ;
    private DataSource source2;

    public TunelBidirecional(DataSource source1, DataSource source2) {
        this.source1 = source1;
        this.source2 = source2;
    }

    public String[] startTunnel() throws UnsupportedEncodingException {
        byte[] dataFromSource1 = null;
        byte[] dataFromSource2 = null;
        byte[] dataFromSource3 = null;
        byte[] dataFromSource4 = null;
        try {
            source1.open();
            source2.open();
            
            // Lógica para transferência bidirecional de dados entre as fontes
            while (true) {
                dataFromSource1 = source1.receiveData();
                dataFromSource3 = source2.enviaDados(dataFromSource1);

                dataFromSource2 = source2.receiveData();
                dataFromSource4 = source1.enviaDados(dataFromSource2);
            break;    
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                source1.close();
                source2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String convString1  = new String(dataFromSource1, "UTF-8");
        String convString2  = new String(dataFromSource2, "UTF-8");
        String convString3  = new String(dataFromSource3, "UTF-8");
        String convString4  = new String(dataFromSource4, "UTF-8");
        
        String[] nome =  { convString1, convString3,convString2, convString4};
       
        return nome;
    }
}
