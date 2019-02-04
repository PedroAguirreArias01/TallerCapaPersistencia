/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MatriculaDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */
@Stateless
public class MatriculaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<MatriculaDTO> getMatricula(){
        String query = "Select e from MatriculaDTO e";
        return em.createQuery(query).getResultList();
    }
    
    public MatriculaDTO guardarMatricula(MatriculaDTO matriculaDTO){
        em.merge(matriculaDTO);
        return  matriculaDTO;
    }
    
    public void eliminarMatricula(MatriculaDTO matriculaDTO){
        em.remove(em.find(MatriculaDTO.class, matriculaDTO.getId()));
    }
    
    public void editarMatricula(MatriculaDTO matriculaDTO){
        em.merge(matriculaDTO);
    }
}
