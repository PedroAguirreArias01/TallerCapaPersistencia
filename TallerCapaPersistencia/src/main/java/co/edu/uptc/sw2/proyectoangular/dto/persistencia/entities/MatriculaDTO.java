package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MatriculaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatricula;
    private int annio;
    private int semestre;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<MateriaDTO> materias;
    private EstudianteDTO estudiante;

    public int getAnnio() {
        return annio;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public List<MateriaDTO> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaDTO> materias) {
        this.materias = materias;
    }

    public void setAnnio(int annio) {
        this.annio = annio;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public List<MateriaDTO> getMateria() {
        return materias;
    }

    public void setMateria(List<MateriaDTO> materia) {
        this.materias = materia;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    public int getId() {
        return idMatricula;
    }

    public void setId(int id) {
        this.idMatricula = id;
    }
}
