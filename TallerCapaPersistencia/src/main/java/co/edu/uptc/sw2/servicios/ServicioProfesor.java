package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.ProfesorDTO;
import co.edu.uptc.sw2.proyectoangular.logica.ProfesorLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioProfesor")
public class ServicioProfesor {

    @EJB
    private ProfesorLogica logica;
    
    @GET
    public List<ProfesorDTO> getProfesors() {
        return logica.getProfesores();
    }

    @POST
    public ProfesorDTO guardarProfesor(ProfesorDTO profesorDTO) {
        for (int i = 0; i < logica.getProfesores().size(); i++) {
            if (logica.getProfesores().get(i).getId() == profesorDTO.getId()) {
                logica.editarProfesor(profesorDTO);
                return profesorDTO;
            }
        }
        logica.guardarProfesor(profesorDTO);
        return profesorDTO;
    }

    @DELETE
    @Path("/{name}")
    public void deleteProfesor(@PathParam("name") String name) {
        for (int i = 0; i < logica.getProfesores().size(); i++) {
            if (logica.getProfesores().get(i).getNombres().equals(name)) {
                logica.eliminarProfesor(logica.getProfesores().get(i));
                break;
            }
        }
    }
}
