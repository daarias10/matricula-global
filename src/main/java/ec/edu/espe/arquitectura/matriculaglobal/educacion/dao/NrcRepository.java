package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Nrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NrcRepository extends JpaRepository<Nrc, NrcPK> {
}