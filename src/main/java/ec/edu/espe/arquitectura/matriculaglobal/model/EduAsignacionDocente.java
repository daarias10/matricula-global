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
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "edu_asignacion_docente")

public class EduAsignacionDocente implements Serializable {

    private static final long serialVersionUID = 13445432L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_docente", nullable = false)
    private Integer codDocente;
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(mappedBy = "codDocente")
    private List<EduNrc> eduNrcList;
    @JoinColumns({
        @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona"),
        @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona")})
    @ManyToOne
    private PerHistTipoPersona perHistTipoPersona;

    public EduAsignacionDocente() {
    }

    public EduAsignacionDocente(Integer codDocente) {
        this.codDocente = codDocente;
    }

    public Integer getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(Integer codDocente) {
        this.codDocente = codDocente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<EduNrc> getEduNrcList() {
        return eduNrcList;
    }

    public void setEduNrcList(List<EduNrc> eduNrcList) {
        this.eduNrcList = eduNrcList;
    }

    public PerHistTipoPersona getPerHistTipoPersona() {
        return perHistTipoPersona;
    }

    public void setPerHistTipoPersona(PerHistTipoPersona perHistTipoPersona) {
        this.perHistTipoPersona = perHistTipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDocente != null ? codDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduAsignacionDocente)) {
            return false;
        }
        EduAsignacionDocente other = (EduAsignacionDocente) object;
        if ((this.codDocente == null && other.codDocente != null) || (this.codDocente != null && !this.codDocente.equals(other.codDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codDocente=" + codDocente + " ]";
    }
    
}
