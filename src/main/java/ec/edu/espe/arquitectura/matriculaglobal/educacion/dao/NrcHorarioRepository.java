package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorarioPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface NrcHorarioRepository extends JpaRepository<NrcHorario, NrcHorarioPK> {

    List<NrcHorario> findByHoraInicio(Date horaInicio);
    List<NrcHorario> findByHoraFin(Date horaFin);
    List<NrcHorario> findByCodAulaAndDiaSemana(Integer codAula, String diaSemana);
    List<NrcHorario> findByCodMateria(Integer codMateria);
}