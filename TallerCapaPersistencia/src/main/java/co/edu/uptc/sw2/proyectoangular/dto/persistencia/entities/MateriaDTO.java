package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MateriaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;
    private String nombre;
    private int creditos;
    private ProfesorDTO profesor;
    @OneToMany(mappedBy = "idMateriaDTO",orphanRemoval=true, cascade={CascadeType.ALL})
    private List<HorarioDTO> horario;
    private CarreraDTO carrera;
    //@ManyToMany
    //private MatriculaDTO idMatriculaDTO;

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public ProfesorDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDTO profesor) {
        this.profesor = profesor;
    }

    public List<HorarioDTO> getHorario() {
        return horario;
    }

    public void setHorario(List<HorarioDTO> horario) {
        this.horario = horario;
    }

    public int getId() {
        return idMateria;
    }

    public void setId(int id) {
        this.idMateria = id;
    }

    public CarreraDTO getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDTO carrera) {
        this.carrera = carrera;
    }

//    public MatriculaDTO getIdMatriculaDTO() {
//        return idMatriculaDTO;
//    }
//
//    public void setIdMatriculaDTO(MatriculaDTO idMatriculaDTO) {
//        this.idMatriculaDTO = idMatriculaDTO;
//    }
}
