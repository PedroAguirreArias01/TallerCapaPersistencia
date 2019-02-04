package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.CarreraDTO;
import co.edu.uptc.sw2.proyectoangular.logica.CarreraLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Stateless
@Path("ServicioCarrera")
public class ServicioCarrera {

    @EJB
    private CarreraLogica logica;
    
    @GET
    public List<CarreraDTO> getCarrera() {
        return logica.getCarreras();
    }

    @POST
    public CarreraDTO guardarCarrera(CarreraDTO carreraDTO) {
        for (int i = 0; i < logica.getCarreras().size(); i++) {
            if (logica.getCarreras().get(i).getId() == (carreraDTO.getId())) {
                logica.editarCarrera(carreraDTO);
                return carreraDTO;
            }
        }
        logica.guardarCarrera(carreraDTO);
        return carreraDTO;
    }

    @DELETE
    @Path("/{name}")
    public void deleteCarrera(@PathParam("name") String name) {
        for (int i = 0; i < logica.getCarreras().size(); i++) {
            if (logica.getCarreras().get(i).getNombre().equals(name)) {
                logica.eliminarCarrera(logica.getCarreras().get(i));
            }
        }
    }
}
