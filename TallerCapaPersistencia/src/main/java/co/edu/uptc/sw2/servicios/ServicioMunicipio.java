package co.edu.uptc.sw2.servicios;

import co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities.MunicipioDTO;
import co.edu.uptc.sw2.proyectoangular.logica.MunicipioLogica;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("ServicioMunicipio")
public class ServicioMunicipio {
    
    @EJB
    private MunicipioLogica logica;
    
    @GET
    public List<MunicipioDTO> getMunicipio() {
        return logica.getMunicipios();
    }

    @POST
    public MunicipioDTO guardarMunicipio(MunicipioDTO municipio) {
        
        for (int i = 0; i < logica.getMunicipios().size(); i++) {
            if (logica.getMunicipios().get(i).getId() == (municipio.getId())) {
                
                return logica.editarMunicipio(municipio);
            }
        }
        logica.guardarMunicipio(municipio);
        return municipio;
    }

    @DELETE
    @Path("/{name}")
    public void deleteMunicipio(@PathParam("name") String name) {
        for (int i = 0; i < logica.getMunicipios().size(); i++) {
            if (logica.getMunicipios().get(i).getNombre().equals(name)) {
                logica.eliminarMunicipio(logica.getMunicipios().get(i));
            }
        }
    }
}
