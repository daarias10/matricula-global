/*
 * Copyright 2022 User.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ec.edu.espe.arquitectura.matriculaglobal.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "edu_departamento")

public class EduDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_departamento", nullable = false)
    private Integer codDepartamento;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Column(name = "siglas", nullable = false, length = 32)
    private String siglas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDepartamento")
    private List<EduCarrera> eduCarreraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduDepartamento")
    private List<EduMateria> eduMateriaList;

    public EduDepartamento() {
    }

    public EduDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public List<EduCarrera> getEduCarreraList() {
        return eduCarreraList;
    }

    public void setEduCarreraList(List<EduCarrera> eduCarreraList) {
        this.eduCarreraList = eduCarreraList;
    }

    public List<EduMateria> getEduMateriaList() {
        return eduMateriaList;
    }

    public void setEduMateriaList(List<EduMateria> eduMateriaList) {
        this.eduMateriaList = eduMateriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDepartamento != null ? codDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduDepartamento)) {
            return false;
        }
        EduDepartamento other = (EduDepartamento) object;
        if ((this.codDepartamento == null && other.codDepartamento != null) || (this.codDepartamento != null && !this.codDepartamento.equals(other.codDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codDepartamento=" + codDepartamento + " ]";
    }
    
}
