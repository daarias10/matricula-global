package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Matricula;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaPK> {
    Matricula findByMatriculaPK(MatriculaPK pk);
    List<Matricula> findByTipo(String tipo);
    List<Matricula> findByFechabetween(Date fecha_inicial, Date fecha_final);
    List<Matricula> findByCodPersona(int codpersona);
    List<Matricula> findByCodPeriodoAndCodCarrera(int codPeriodo, int CodCarrera);
}