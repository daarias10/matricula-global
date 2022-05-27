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
import javax.persistence.*;

@Entity
@Table(name = "edu_nrc_horario")

public class EduNrcHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EduNrcHorarioPK eduNrcHorarioPK;
    
    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    
    @Column(name = "hora_fin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EduNrc eduNrc;
    @JoinColumn(name = "cod_aula", referencedColumnName = "cod_aula", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OfiAula ofiAula;

    public EduNrcHorario() {
    }

    public EduNrcHorario(EduNrcHorarioPK eduNrcHorarioPK) {
        this.eduNrcHorarioPK = eduNrcHorarioPK;
    }

    public EduNrcHorario(short codNrc, int codPeriodo, int codDepartamento, int codMateria, int codAula, String diaSemana) {
        this.eduNrcHorarioPK = new EduNrcHorarioPK(codNrc, codPeriodo, codDepartamento, codMateria, codAula, diaSemana);
    }

    public EduNrcHorarioPK getEduNrcHorarioPK() {
        return eduNrcHorarioPK;
    }

    public void setEduNrcHorarioPK(EduNrcHorarioPK eduNrcHorarioPK) {
        this.eduNrcHorarioPK = eduNrcHorarioPK;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public EduNrc getEduNrc() {
        return eduNrc;
    }

    public void setEduNrc(EduNrc eduNrc) {
        this.eduNrc = eduNrc;
    }

    public OfiAula getOfiAula() {
        return ofiAula;
    }

    public void setOfiAula(OfiAula ofiAula) {
        this.ofiAula = ofiAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduNrcHorarioPK != null ? eduNrcHorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EduNrcHorario)) {
            return false;
        }
        EduNrcHorario other = (EduNrcHorario) object;
        if ((this.eduNrcHorarioPK == null && other.eduNrcHorarioPK != null) || (this.eduNrcHorarioPK != null && !this.eduNrcHorarioPK.equals(other.eduNrcHorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ eduNrcHorarioPK=" + eduNrcHorarioPK + " ]";
    }
    
}
