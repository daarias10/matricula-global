package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Materia;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MateriaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface MateriaRepository extends JpaRepository<Materia, MateriaPK> {
    List<Materia> findByNombreLike(String nombrePattern);

}