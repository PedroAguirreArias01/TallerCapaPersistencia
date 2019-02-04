/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.FacultadDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */

@Stateless
public class FacultadDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<FacultadDTO> getFacultad(){
        String query = "Select e from FacultadDTO e";
        return em.createQuery(query).getResultList();
    }
    
    public FacultadDTO guardarFacultad(FacultadDTO facultadDTO){
        em.persist(facultadDTO);
        return  facultadDTO;
    }
    
    public void eliminarFacultad(FacultadDTO facultadDTO){
        em.remove(em.find(FacultadDTO.class, facultadDTO.getId()));
    }
    
    public FacultadDTO editarFacultad(FacultadDTO facultadDTO){
        em.merge(facultadDTO);
        return facultadDTO;
    }
}
