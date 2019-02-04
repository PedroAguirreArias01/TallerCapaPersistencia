/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.MatriculaDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MatriculaDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
@Stateless
public class MatriculaLogica {
    
    @EJB
    private MatriculaDAO matriculaDAO;
    
     public List<MatriculaDTO> getMatricula(){
        return matriculaDAO.getMatricula();
    }
    
    public MatriculaDTO guardarMatricula(MatriculaDTO matriculaDTO){
        return matriculaDAO.guardarMatricula(matriculaDTO);
    }
    
    public void eliminarMatricula(MatriculaDTO matriculaDTO){
        matriculaDAO.eliminarMatricula(matriculaDTO);
    }
    
    public void ediatarMatricula(MatriculaDTO matriculaDTO){
        matriculaDAO.editarMatricula(matriculaDTO);
    }
}
