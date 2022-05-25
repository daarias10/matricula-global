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
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "edu_materia")

public class EduMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_materia", nullable = false)
    private Integer codMateria;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "creditos", nullable = false, precision = 4, scale = 2)
    private BigDecimal creditos;
    @Column(name = "horas", nullable = false, precision = 4, scale = 2)
    private BigDecimal horas;
    @Column(name = "ponderacion", nullable = false, precision = 5, scale = 2)
    private BigDecimal ponderacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMateria")
    private List<EduNrc> eduNrcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMateria")
    private List<EduMallaCarrera> eduMallaCarreraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMateriaPadre")
    private List<EduPrerequisito> eduPrerequisitoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduCodMateria")
    private List<EduPrerequisito> eduPrerequisitoList1;
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false)
    @ManyToOne(optional = false)
    private EduDepartamento codDepartamento;

    public EduMateria() {
    }

    public EduMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void setCreditos(BigDecimal creditos) {
        this.creditos = creditos;
    }

    public BigDecimal getHoras() {
        return horas;
    }

    public void setHoras(BigDecimal horas) {
        this.horas = horas;
    }

    public BigDecimal getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(BigDecimal ponderacion) {
        this.ponderacion = ponderacion;
    }

    public List<EduNrc> getEduNrcList() {
        return eduNrcList;
    }

    public void setEduNrcList(List<EduNrc> eduNrcList) {
        this.eduNrcList = eduNrcList;
    }

    public List<EduMallaCarrera> getEduMallaCarreraList() {
        return eduMallaCarreraList;
    }

    public void setEduMallaCarreraList(List<EduMallaCarrera> eduMallaCarreraList) {
        this.eduMallaCarreraList = eduMallaCarreraList;
    }

    public List<EduPrerequisito> getEduPrerequisitoList() {
        return eduPrerequisitoList;
    }

    public void setEduPrerequisitoList(List<EduPrerequisito> eduPrerequisitoList) {
        this.eduPrerequisitoList = eduPrerequisitoList;
    }

    public List<EduPrerequisito> getEduPrerequisitoList1() {
        return eduPrerequisitoList1;
    }

    public void setEduPrerequisitoList1(List<EduPrerequisito> eduPrerequisitoList1) {
        this.eduPrerequisitoList1 = eduPrerequisitoList1;
    }

    public EduDepartamento getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(EduDepartamento codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMateria != null ? codMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduMateria)) {
            return false;
        }
        EduMateria other = (EduMateria) object;
        if ((this.codMateria == null && other.codMateria != null) || (this.codMateria != null && !this.codMateria.equals(other.codMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codMateria=" + codMateria + " ]";
    }
    
}
