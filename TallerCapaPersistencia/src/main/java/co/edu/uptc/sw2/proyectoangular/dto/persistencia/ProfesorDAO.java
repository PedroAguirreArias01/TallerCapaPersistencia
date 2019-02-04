/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.ProfesorDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */
@Stateless
public class ProfesorDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<ProfesorDTO> getProfesores(){
        String query = "Select e from ProfesorDTO e";
        return em.createQuery(query).getResultList();
    }
    
    public ProfesorDTO guardarProfesor(ProfesorDTO profesorDTO){
        em.persist(profesorDTO);
        return  profesorDTO;
    }
    
    public void eliminarProfesor(ProfesorDTO profesorDTO){
        em.remove(em.find(ProfesorDTO.class, profesorDTO.getId()));
    }
    
    public void editarProfesor(ProfesorDTO profesorDTO){
        em.merge(profesorDTO);
    }
}
