package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorario;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcHorarioPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.List;

public interface NrcHorarioRepository extends JpaRepository<NrcHorario, NrcHorarioPK> {

    List<NrcHorario> findByHoraInicio(Time horaInicio);
    List<NrcHorario> findByindByHoraFin(Time horaFin);
    List<NrcHorario> findByCodAulaAnddiaSemana(Integer codAula, String diaSemana);
    List<NrcHorario> findByCodMateria(Integer codMateria);
}