/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.test;

import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.DaoUsuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author 2105409
 */
public class ForoUsuarioPersistenceTest {
    
    public static InputStream input = ClassLoader.getSystemResourceAsStream("applicationconfig_test.properties");
    public static Properties properties = new Properties();
    
    @Test
    public void NewUserTest() throws IOException, PersistenceException{
        properties.load(input);
        DaoFactory daof=DaoFactory.getInstance(properties);        
        try{
            daof.beginSession();
            DaoUsuario user = daof.getDaoUsuario();
            Usuario Pipe = new Usuario("ElPapi@gmail.com","Pipe");
            user.save(Pipe);
            Usuario test = user.load(Pipe.getEmail());
            assertEquals("PASO HP!!!",test.getEmail(),Pipe.getEmail());
            daof.commitTransaction();
        }catch(PersistenceException ex2){
            fail("SOMOS UNAS HUEVAS  " +ex2.getMessage());
        }catch(Exception ex){
            fail("SOMOS RE TONTOS "+ex.getMessage());
        }
        finally{
            daof.endSession();  
        }      
    }
    
     @Test
    public void NewUserErrorTest() throws IOException, PersistenceException{
        properties.load(input);
        DaoFactory daof=DaoFactory.getInstance(properties);        
        try{
            daof.beginSession();
            DaoUsuario user = daof.getDaoUsuario();
            Usuario Luis = new Usuario("ElPapi@gmail.com","Pipe");
            user.save(Luis);
            user.save(Luis);
            daof.commitTransaction();
            fail("SOMOS UNAS HUEVAS");
        }catch(PersistenceException ex2){
            assertTrue("Prueba buena",true);
        }catch(Exception ex){
            fail("SOMOS RE TONTOS "+ex.getMessage());
        }
        finally{
            daof.endSession();  
        }      
    }
}
