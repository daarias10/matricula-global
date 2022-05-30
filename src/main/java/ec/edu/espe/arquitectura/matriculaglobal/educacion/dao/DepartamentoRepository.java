package ec.edu.espe.arquitectura.matriculaglobal.educacion.dao;

import ec.edu.espe.arquitectura.matriculaglobal.educacion.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    Departamento FindByNombreLike(String nombre);
    List<Departamento> FindBySiglasLike(String siglas);
}