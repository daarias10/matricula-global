package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.MatriculaNrcPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaNrcRepository extends JpaRepository<MatriculaNrc, MatriculaNrcPK> {

    List<MatriculaNrc> findByEstado(String estado);
}