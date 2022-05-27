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
@Table(name = "edu_nrc", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cod_periodo"})})

public class EduNrc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EduNrcPK eduNrcPK;
    @Column(name = "cupo_disponible", nullable = false)
    private short cupoDisponible;
    @Column(name = "cupo_registrado", nullable = false)
    private short cupoRegistrado;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EduMateria eduMateria;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EduPeriodo eduPeriodo;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false)
    @ManyToOne(optional = false)
    private PerPersona codPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduNrc")
    private List<EduNrcHorario> eduNrcHorarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduNrc")
    private List<EduMatriculaNrc> eduMatriculaNrcList;

    public EduNrc() {
    }

    public EduNrc(EduNrcPK eduNrcPK) {
        this.eduNrcPK = eduNrcPK;
    }

    public EduNrc(short codNrc, int codPeriodo, int codDepartamento, int codMateria) {
        this.eduNrcPK = new EduNrcPK(codNrc, codPeriodo, codDepartamento, codMateria);
    }

    public EduNrcPK getEduNrcPK() {
        return eduNrcPK;
    }

    public void setEduNrcPK(EduNrcPK eduNrcPK) {
        this.eduNrcPK = eduNrcPK;
    }

    public short getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(short cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public short getCupoRegistrado() {
        return cupoRegistrado;
    }

    public void setCupoRegistrado(short cupoRegistrado) {
        this.cupoRegistrado = cupoRegistrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EduMateria getEduMateria() {
        return eduMateria;
    }

    public void setEduMateria(EduMateria eduMateria) {
        this.eduMateria = eduMateria;
    }

    public EduPeriodo getEduPeriodo() {
        return eduPeriodo;
    }

    public void setEduPeriodo(EduPeriodo eduPeriodo) {
        this.eduPeriodo = eduPeriodo;
    }

    public PerPersona getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(PerPersona codPersona) {
        this.codPersona = codPersona;
    }

    public List<EduNrcHorario> getEduNrcHorarioList() {
        return eduNrcHorarioList;
    }

    public void setEduNrcHorarioList(List<EduNrcHorario> eduNrcHorarioList) {
        this.eduNrcHorarioList = eduNrcHorarioList;
    }

    public List<EduMatriculaNrc> getEduMatriculaNrcList() {
        return eduMatriculaNrcList;
    }

    public void setEduMatriculaNrcList(List<EduMatriculaNrc> eduMatriculaNrcList) {
        this.eduMatriculaNrcList = eduMatriculaNrcList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduNrcPK != null ? eduNrcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduNrc)) {
            return false;
        }
        EduNrc other = (EduNrc) object;
        if ((this.eduNrcPK == null && other.eduNrcPK != null) || (this.eduNrcPK != null && !this.eduNrcPK.equals(other.eduNrcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ eduNrcPK=" + eduNrcPK + " ]";
    }
    
}
