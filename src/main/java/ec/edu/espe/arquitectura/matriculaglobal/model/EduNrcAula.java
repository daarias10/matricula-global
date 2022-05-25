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
@Table(name = "edu_nrc_aula")

public class EduNrcAula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_nrc_aula", nullable = false)
    private Integer codNrcAula;
    @Column(name = "dia_semana", nullable = false, length = 25)
    private String diaSemana;
    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_fin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false)})
    @ManyToOne(optional = false)
    private EduNrc eduNrc;
    @JoinColumn(name = "cod_aula", referencedColumnName = "cod_aula")
    @ManyToOne
    private OfiAula codAula;

    public EduNrcAula() {
    }

    public EduNrcAula(Integer codNrcAula) {
        this.codNrcAula = codNrcAula;
    }

    public Integer getCodNrcAula() {
        return codNrcAula;
    }

    public void setCodNrcAula(Integer codNrcAula) {
        this.codNrcAula = codNrcAula;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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

    public OfiAula getCodAula() {
        return codAula;
    }

    public void setCodAula(OfiAula codAula) {
        this.codAula = codAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNrcAula != null ? codNrcAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduNrcAula)) {
            return false;
        }
        EduNrcAula other = (EduNrcAula) object;
        if ((this.codNrcAula == null && other.codNrcAula != null) || (this.codNrcAula != null && !this.codNrcAula.equals(other.codNrcAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codNrcAula=" + codNrcAula + " ]";
    }
    
}
