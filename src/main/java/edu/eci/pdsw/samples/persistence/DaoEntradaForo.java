/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;

/**
 *
 * @author estudiante
 */
public interface DaoEntradaForo {
    
    public EntradaForo load(int identificador) throws PersistenceException;
    
    public void save(EntradaForo p) throws PersistenceException;
    
    public void update(EntradaForo p) throws PersistenceException;

}
