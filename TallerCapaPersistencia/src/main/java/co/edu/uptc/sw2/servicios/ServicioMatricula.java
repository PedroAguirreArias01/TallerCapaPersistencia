package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MatriculaDTO;
import co.edu.uptc.sw2.proyectoangular.logica.MatriculaLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioMatricula")
public class ServicioMatricula {

    @EJB
    private MatriculaLogica logica;

    @GET
    public List<MatriculaDTO> getMatricula() {
        return logica.getMatricula();
    }

    @POST
    public MatriculaDTO guardarMatricula(MatriculaDTO matricula) {
        for (int i = 0; i < logica.getMatricula().size(); i++) {
            if (logica.getMatricula().get(i).getId() == (matricula.getId())) {
                logica.ediatarMatricula(matricula);
                return matricula;
            }
        }
        logica.guardarMatricula(matricula);
        return matricula;
    }

    @DELETE
    @Path("/{id}")
    public void deleteMatricula(@PathParam("id") int id) {
        for (MatriculaDTO matriculaDTO : logica.getMatricula()) {
            if (id == matriculaDTO.getId()) {
                logica.eliminarMatricula(matriculaDTO);
            }
        }
    }
}
