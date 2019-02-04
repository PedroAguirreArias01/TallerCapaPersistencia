/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.EstudianteDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.EstudianteDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
@Stateless
public class EstudianteLogica {
    
      @EJB
    private EstudianteDAO estudianteDAO;
    
    public List<EstudianteDTO> getEstudiantes(){
        return estudianteDAO.getEstudiantes();
    }
    
    public EstudianteDTO guardarEstudiantes(EstudianteDTO estudianteDTO){
        return estudianteDAO.guardarEstudiante(estudianteDTO);
    }
    
    public void eliminarEstudiante(EstudianteDTO carreraDTO){
        estudianteDAO.eliminarEstudiante(carreraDTO);
    }
    
   public void editarEstudiante(EstudianteDTO estudianteDTO){
       estudianteDAO.editarEstudiante(estudianteDTO);
   }
}
