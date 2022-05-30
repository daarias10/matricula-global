package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Nrc;
import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.NrcPK;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface NrcRepository extends JpaRepository<Nrc, NrcPK> {

    List<Nrc> findByNombreLike(String nombrePattern);
    List<Nrc> findByNombreLikeAndCupoDisponibleIsGreaterThan(String nombrePattern,short cupo);
    List<Nrc> findByCodPersona(Integer codDocente);
    List<Nrc> findByCodPeriodoAndCodMateria(Integer codPeriodo, Integer codMateria);
    List<Nrc> findByNombreLikeAndCupoRegistradoGreaterThan(String nombrePattern, short cupoRegistradoMinimo);

}