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
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "edu_matricula", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cod_periodo"})})

public class EduMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EduMatriculaPK eduMatriculaPK;
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "costo", nullable = false)
    private double costo;
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", nullable = false)
    @ManyToOne(optional = false)
    private EduCarrera codCarrera;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false)
    @OneToOne(optional = false)
    private EduPeriodo codPeriodo;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PerPersona perPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMatricula")
    private List<EduMatriculaNrc> eduMatriculaNrcList;

    public EduMatricula() {
    }

    public EduMatricula(EduMatriculaPK eduMatriculaPK) {
        this.eduMatriculaPK = eduMatriculaPK;
    }

    public EduMatricula(String codMatricula, int codPersona) {
        this.eduMatriculaPK = new EduMatriculaPK(codMatricula, codPersona);
    }

    public EduMatriculaPK getEduMatriculaPK() {
        return eduMatriculaPK;
    }

    public void setEduMatriculaPK(EduMatriculaPK eduMatriculaPK) {
        this.eduMatriculaPK = eduMatriculaPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public EduCarrera getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(EduCarrera codCarrera) {
        this.codCarrera = codCarrera;
    }

    public EduPeriodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(EduPeriodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public PerPersona getPerPersona() {
        return perPersona;
    }

    public void setPerPersona(PerPersona perPersona) {
        this.perPersona = perPersona;
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
        hash += (eduMatriculaPK != null ? eduMatriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduMatricula)) {
            return false;
        }
        EduMatricula other = (EduMatricula) object;
        if ((this.eduMatriculaPK == null && other.eduMatriculaPK != null) || (this.eduMatriculaPK != null && !this.eduMatriculaPK.equals(other.eduMatriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ eduMatriculaPK=" + eduMatriculaPK + " ]";
    }
    
}
