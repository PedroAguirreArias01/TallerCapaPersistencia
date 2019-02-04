/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.HorarioDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MateriaDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */
@Stateless
public class MateriaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    /**
     * metodo encargado de obtener todas la materias
     * @return lista de materias
     */
    public List<MateriaDTO> getMaterias(){
        String query = "Select e from MateriaDTO e";
        return em.createQuery(query).getResultList();
    }
    
    /**
     * 
     * @param materiaDTO
     * @return 
     */
    public MateriaDTO guardarMateria(MateriaDTO materiaDTO){
        em.persist(materiaDTO);
        return  materiaDTO;
    }
    
    public void eliminarMateria(MateriaDTO materiaDTO){
        em.remove(em.find(MateriaDTO.class, materiaDTO.getId()));
    }
    
    public void editarMateria(MateriaDTO materiaDTO){
        em.merge(materiaDTO);
    }

    public void eliminarHorario(HorarioDTO horario) {
        em.merge(horario);
    }
}
