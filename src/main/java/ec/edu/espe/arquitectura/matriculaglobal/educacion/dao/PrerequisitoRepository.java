package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Prerequisito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrerequisitoRepository extends JpaRepository<Prerequisito, Integer> {
    List<Prerequisito> findByindByCodPrerequisito(Integer codPrerequisito);
    List<Prerequisito> findByCodMateria(Integer codMateria);
    List<Prerequisito> findByTipo(String tipo);
    List<Prerequisito> findByCodMateriaAndTipo(Integer codMateria, String tipo);

}