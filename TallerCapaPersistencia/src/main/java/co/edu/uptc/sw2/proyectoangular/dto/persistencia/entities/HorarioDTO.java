package co.edu.uptc.sw2.proyectoangular.dto.persistencia.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class HorarioDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;
    private int dia;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horaFin;
    @ManyToOne
    private MateriaDTO idMateriaDTO;
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public int getId() {
        return idHorario;
    }

    public void setId(int id) {
        this.idHorario = id;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public MateriaDTO getIdMateriaDTO() {
        return idMateriaDTO;
    }

    public void setIdMateriaDTO(MateriaDTO idMateriaDTO) {
        this.idMateriaDTO = idMateriaDTO;
    }
    
    
}
