/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.EstudianteDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */
@Stateless
public class EstudianteDAO {
    
     @PersistenceContext
    private EntityManager em;
    
    public List<EstudianteDTO> getEstudiantes(){
        String query = "Select e from EstudianteDTO e";
        return em.createQuery(query).getResultList();
    }
    
    public EstudianteDTO guardarEstudiante(EstudianteDTO estudianteDTO){
        em.persist(estudianteDTO);
        return  estudianteDTO;
    }
    
    public void eliminarEstudiante(EstudianteDTO estudianteDTO){
        em.remove(em.find(EstudianteDTO.class, estudianteDTO.getId()));
    }
    
    public void editarEstudiante(EstudianteDTO estudianteDTO){
        em.merge(estudianteDTO);
    }
}
