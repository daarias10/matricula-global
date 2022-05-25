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
    @Column(name = "cupos", nullable = false)
    private int cupos;
    @JoinColumn(name = "cod_docente", referencedColumnName = "cod_docente")
    @ManyToOne
    private EduAsignacionDocente codDocente;
    @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false)
    @ManyToOne(optional = false)
    private EduMateria codMateria;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EduPeriodo eduPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduNrc")
    private List<EduMatricula> eduMatriculaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduNrc")
    private List<EduNrcAula> eduNrcAulaList;

    public EduNrc() {
    }

    public EduNrc(EduNrcPK eduNrcPK) {
        this.eduNrcPK = eduNrcPK;
    }

    public EduNrc(short codNrc, int codPeriodo) {
        this.eduNrcPK = new EduNrcPK(codNrc, codPeriodo);
    }

    public EduNrcPK getEduNrcPK() {
        return eduNrcPK;
    }

    public void setEduNrcPK(EduNrcPK eduNrcPK) {
        this.eduNrcPK = eduNrcPK;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public EduAsignacionDocente getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(EduAsignacionDocente codDocente) {
        this.codDocente = codDocente;
    }

    public EduMateria getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(EduMateria codMateria) {
        this.codMateria = codMateria;
    }

    public EduPeriodo getEduPeriodo() {
        return eduPeriodo;
    }

    public void setEduPeriodo(EduPeriodo eduPeriodo) {
        this.eduPeriodo = eduPeriodo;
    }

    public List<EduMatricula> getEduMatriculaList() {
        return eduMatriculaList;
    }

    public void setEduMatriculaList(List<EduMatricula> eduMatriculaList) {
        this.eduMatriculaList = eduMatriculaList;
    }

    public List<EduNrcAula> getEduNrcAulaList() {
        return eduNrcAulaList;
    }

    public void setEduNrcAulaList(List<EduNrcAula> eduNrcAulaList) {
        this.eduNrcAulaList = eduNrcAulaList;
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
