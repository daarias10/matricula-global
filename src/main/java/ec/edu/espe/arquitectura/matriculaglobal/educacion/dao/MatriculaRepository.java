package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaPK> {
    List<Matricula> FindByTipo(String tipo);
    List<Matricula> FindByFechabetween(Date fecha_inicial, Date fecha_final);
    List<Matricula> FindByPersona(String persona);
    List<Matricula> FindByCodPeriodo(String codPeriodo);
}