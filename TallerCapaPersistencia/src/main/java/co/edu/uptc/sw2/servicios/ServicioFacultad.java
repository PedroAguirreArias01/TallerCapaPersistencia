package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.FacultadDTO;
import co.edu.uptc.sw2.proyectoangular.logica.FacultadLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioFacultad")
public class ServicioFacultad {

    @EJB
    private FacultadLogica logica;
    
    @GET
    public List<FacultadDTO> getFacultad() {
        return logica.getFacultades();
    }

   @POST
    public FacultadDTO guardarFacultad(FacultadDTO facultad) {
        for (int i = 0; i < logica.getFacultades().size(); i++) {
            if (logica.getFacultades().get(i).getId() == (facultad.getId())) {
                logica.editarFacultad(facultad);
                return facultad;
            }
        }
        logica.guardarFacultad(facultad);
        return facultad;
    }
    
    @DELETE
    @Path("/{name}")
    public void deleteFacultad(@PathParam("name") String name) {
        for (int i = 0; i < logica.getFacultades().size(); i++) {
            if (logica.getFacultades().get(i).getNombre().equals(name)) {
                logica.eliminarFacultad(logica.getFacultades().get(i));
            }
        }
    }
}
