/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hilab.interfaces;

import java.io.IOException;

/**
 *
 * @author helayne
 */

// Interface para definir as operações comuns entre as fontes de dados
public interface DataSource {
    boolean open() throws IOException;
    void close() throws IOException;
    byte[] enviaDados(byte[] data) throws IOException;
    byte[] receiveData() throws IOException;
    
   
}
