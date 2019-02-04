/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.FacultadDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.FacultadDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
@Stateless
public class FacultadLogica {
    
    @EJB
    private FacultadDAO facultadDAO;
    
    public List<FacultadDTO> getFacultades(){
        return facultadDAO.getFacultad();
    }
    
    public FacultadDTO guardarFacultad(FacultadDTO facultadDTO){
        return facultadDAO.guardarFacultad(facultadDTO);
    }
    
    public void eliminarFacultad(FacultadDTO facultadDTO){
        facultadDAO.eliminarFacultad(facultadDTO);
    }
    
    public FacultadDTO editarFacultad(FacultadDTO facultadDTO){
        return facultadDAO.editarFacultad(facultadDTO);
    }
}
