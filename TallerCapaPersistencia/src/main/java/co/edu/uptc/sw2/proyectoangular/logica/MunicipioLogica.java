/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectoangular.logica;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.MunicipioDAO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MunicipioDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PEDRO
 */
@Stateless
public class MunicipioLogica {

    @EJB
    private MunicipioDAO municipioDAO;

    public List<MunicipioDTO> getMunicipios() {
        return municipioDAO.getMunicipios();
    }

    public MunicipioDTO guardarMunicipio(MunicipioDTO municipio) {
        return municipioDAO.guardarMunicipio(municipio);
    }

    public void eliminarMunicipio(MunicipioDTO municipioDTO) {
        municipioDAO.eliminarMunicipio(municipioDTO);
    }

    public MunicipioDTO editarMunicipio(MunicipioDTO mu) {
        return municipioDAO.editarMunicipio(mu);
    }
}
