/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.ProfesorDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.ProfesorDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
@Stateless
public class ProfesorLogica {
    
    @EJB
    private ProfesorDAO profesorDAO;
    
    public List<ProfesorDTO> getProfesores(){
        return profesorDAO.getProfesores();
    }
    
    public ProfesorDTO guardarProfesor(ProfesorDTO municipio){
        return profesorDAO.guardarProfesor(municipio);
    }
    
    public void eliminarProfesor(ProfesorDTO profesorDTO){
        profesorDAO.eliminarProfesor(profesorDTO);
    }
    
    public void editarProfesor(ProfesorDTO profesorDTO){
        profesorDAO.editarProfesor(profesorDTO);
    }
}
