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
package ec.edu.espe.arquitectura.matriculaglobal.educacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "edu_materia")
public class Materia implements Serializable {

    private static final long serialVersionUID = 12345L;
    @EmbeddedId
    private MateriaPK pk;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "creditos", nullable = false, precision = 4, scale = 2)
    private BigDecimal creditos;
    @Column(name = "horas", nullable = false, precision = 4, scale = 2)
    private BigDecimal horas;
    @Column(name = "ponderacion", nullable = false, precision = 5, scale = 2)
    private BigDecimal ponderacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<Nrc> nrcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<MallaCarrera> mallaCarreraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<Prerequisito> prerequisitoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia1")
    private List<Prerequisito> prerequisitoList1;
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamento departamento;

    public Materia() {
    }

    public Materia(MateriaPK eduMateriaPK) {
        this.pk = eduMateriaPK;
    }

    public MateriaPK getPk() {
        return pk;
    }

    public void setPk(MateriaPK pk) {
        this.pk = pk;
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

    public List<Nrc> getNrcList() {
        return nrcList;
    }

    public void setNrcList(List<Nrc> nrcList) {
        this.nrcList = nrcList;
    }

    public List<MallaCarrera> getMallaCarreraList() {
        return mallaCarreraList;
    }

    public void setMallaCarreraList(List<MallaCarrera> mallaCarreraList) {
        this.mallaCarreraList = mallaCarreraList;
    }

    public List<Prerequisito> getPrerequisitoList() {
        return prerequisitoList;
    }

    public void setPrerequisitoList(List<Prerequisito> prerequisitoList) {
        this.prerequisitoList = prerequisitoList;
    }

    public List<Prerequisito> getPrerequisitoList1() {
        return prerequisitoList1;
    }

    public void setPrerequisitoList1(List<Prerequisito> prerequisitoList1) {
        this.prerequisitoList1 = prerequisitoList1;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ eduMateriaPK=" + pk + " ]";
    }
    
}
