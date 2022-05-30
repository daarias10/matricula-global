package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.InstitucionEducativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstitucionEducativaRepository extends JpaRepository<InstitucionEducativa, Integer> {

    List<InstitucionEducativa> findByindByNombreLike(String nombre);
}