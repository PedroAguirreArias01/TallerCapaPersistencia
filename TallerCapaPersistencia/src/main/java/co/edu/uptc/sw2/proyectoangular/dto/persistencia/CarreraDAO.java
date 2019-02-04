/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.dto.persistencia;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.CarreraDTO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PEDRO
 */
@Stateless
public class CarreraDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<CarreraDTO> getCarrera(){
        String query = "Select e from CarreraDTO e";
        return em.createQuery(query).getResultList();
    }
    
    public CarreraDTO guardarCarrera(CarreraDTO carreraDTO){
        em.persist(carreraDTO);
        return  carreraDTO;
    }
    
    public void eliminarCarrera(CarreraDTO carreraDTO){
        em.remove(em.find(CarreraDTO.class, carreraDTO.getId()));
    }
    
    public void editarCarrera(CarreraDTO carreraDTO){
        em.merge(carreraDTO);
    }
}
