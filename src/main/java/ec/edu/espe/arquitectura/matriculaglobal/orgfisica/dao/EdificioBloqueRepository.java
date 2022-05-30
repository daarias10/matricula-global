package ec.edu.espe.arquitectura.matriculaglobal.orgfisica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EdificioBloqueRepository extends JpaRepository<EdificioBloqueRepository, String> {
    List<EdificioBloqueRepository> findByDescripcion(String descripcion);
}
