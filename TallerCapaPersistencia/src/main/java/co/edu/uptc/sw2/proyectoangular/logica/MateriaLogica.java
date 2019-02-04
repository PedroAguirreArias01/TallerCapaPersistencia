/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.MateriaDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.HorarioDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MateriaDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
@Stateless
public class MateriaLogica {
    
    @EJB
    private MateriaDAO materiaDAO;
    
     public List<MateriaDTO> getMaterias(){
        return materiaDAO.getMaterias();
    }
    
    public MateriaDTO guardarMateria(MateriaDTO materiaDTO){
        return materiaDAO.guardarMateria(materiaDTO);
    }
    
    public void eliminarMateria(MateriaDTO materiaDTO){
        materiaDAO.eliminarMateria(materiaDTO);
    }
    
    public void ediatarMateria(MateriaDTO materiaDTO){
        materiaDAO.editarMateria(materiaDTO);
    }
    

    public void eliminarHorario(HorarioDTO horario) {
        materiaDAO.eliminarHorario(horario);
    }
}
