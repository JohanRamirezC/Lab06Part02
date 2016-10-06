/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.test;

import edu.eci.pdsw.samples.persistence.DaoEntradaForo;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.DaoUsuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import static edu.eci.pdsw.test.ForoUsuarioPersistenceTest.input;
import static edu.eci.pdsw.test.ForoUsuarioPersistenceTest.properties;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author 2105409
 * 
 * CLASE 1:
 * Entrada al Foro nueva con fecha actual
 * Tipo: Correcta
 * 
 * CLASE 2:
 * Entrada al foro con fecha diferente a la actual
 * Tipo: Incorrecta
 * 
 */
public class EntradaForoPersistenceTest {
    
    public static InputStream input = ClassLoader.getSystemResourceAsStream("applicationconfig_test.properties");
    public static Properties properties = new Properties();
    
    @Test
    public void FechaForoActual()throws IOException, PersistenceException{
        properties.load(input);
        DaoFactory daof=DaoFactory.getInstance(properties);  
        try{
            daof.beginSession();
            DaoEntradaForo user = daof.getDaoEntradaForo();
        }catch(PersistenceException e){
        
        }catch(Exception ex){
        
        }finally{
        
        }
    }
}
