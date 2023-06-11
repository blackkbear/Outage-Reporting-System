/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Kimberly
 */
public interface BaseDAO {
    
    public Boolean insertar (Object obj);
    public Boolean actualizar (Object obj);
    public Boolean eliminar (Object obj);
 //   public void listar (JTable table);
    public ArrayList<Object[]> listar ();
    public void listarTablaPorTitulo(JTable table, Object obj);
    
}
