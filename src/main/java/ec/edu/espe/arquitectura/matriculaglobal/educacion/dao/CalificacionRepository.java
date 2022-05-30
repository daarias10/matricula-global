package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.CalificacionPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalificacionRepository extends JpaRepository<Calificacion, CalificacionPK> {

}
