package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    List<Carrera> findByTotalSemestres(int totalSemestres);
    Carrera findByNombre(String nombre);
    List<Carrera> findByModalidad(String modalidad);


}