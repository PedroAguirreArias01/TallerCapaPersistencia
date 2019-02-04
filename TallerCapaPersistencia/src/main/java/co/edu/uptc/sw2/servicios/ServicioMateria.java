package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.HorarioDTO;
import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MateriaDTO;
import co.edu.uptc.sw2.proyectoangular.logica.MateriaLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioMateria")
public class ServicioMateria {

    @EJB
    private MateriaLogica logica;

    @DELETE
    @Path("/eliminarHorario")
    public void eliminarHorario(HorarioDTO horario) {
        for (int i = 0; i < logica.getMaterias().size(); i++) {
            for (int j = 0; j < logica.getMaterias().get(i).getHorario().size(); j++) {
                if (logica.getMaterias().get(i).getHorario().get(j).getId() == horario.getId()) {
                    logica.eliminarHorario(horario);
                    break;
                }
            }
        }
    }

    @GET
    public List<MateriaDTO> getMaterias() {
        return logica.getMaterias();
    }

    @POST
    public MateriaDTO guardarMateria(MateriaDTO materiaDTO) {
        for (int i = 0; i < logica.getMaterias().size(); i++) {
            if (logica.getMaterias().get(i).getId() == (materiaDTO.getId())) {
                logica.ediatarMateria(materiaDTO);
                for (HorarioDTO horarioDTO : materiaDTO.getHorario()) {
                    horarioDTO.setIdMateriaDTO(materiaDTO);
                }
                return materiaDTO;
            }
        }
        logica.guardarMateria(materiaDTO);
        return materiaDTO;
    }

    @DELETE
    @Path("/{id}")
    public void deleteMateria(@PathParam("id") int id) {
        for (MateriaDTO materiaDTO : logica.getMaterias()) {
            if (id == materiaDTO.getId()) {
                logica.eliminarMateria(materiaDTO);
            }
        }
    }

}
