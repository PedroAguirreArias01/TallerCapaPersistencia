package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.EstudianteDTO;
import co.edu.uptc.sw2.proyectoangular.logica.EstudianteLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioEstudiante")
public class ServicioEstudiante {
    
    @EJB
    private EstudianteLogica logica;

    @GET
    public List<EstudianteDTO> consultarEstudiante() {
        return logica.getEstudiantes();
    }

    @POST
    public EstudianteDTO guardarEstudiante(EstudianteDTO estudianteDTO) {
        for (int i = 0; i < logica.getEstudiantes().size(); i++) {
            if (logica.getEstudiantes().get(i).getId() == (estudianteDTO.getId())) {
                logica.editarEstudiante(estudianteDTO);
                return estudianteDTO;
            }
        }
        logica.guardarEstudiantes(estudianteDTO);
        return estudianteDTO;
    }

    @DELETE
    @Path("/{name}")
    public void deleteEstudiante(@PathParam("name") String name) {
        for (int i = 0; i < logica.getEstudiantes().size(); i++) {
            if (logica.getEstudiantes().get(i).getNombre().equals(name)) {
                logica.eliminarEstudiante(logica.getEstudiantes().get(i));
            }
        }
    }
}
