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
@Table(name = "per_hist_tipo_persona")

public class PerHistTipoPersona implements Serializable {

    private static final long serialVersionUID = 132423L;
    @EmbeddedId
    protected PerHistTipoPersonaPK perHistTipoPersonaPK;
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "cod_usuario_ini", nullable = false, length = 30)
    private String codUsuarioIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "cod_usuario_fin", length = 30)
    private String codUsuarioFin;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @OneToMany(mappedBy = "perHistTipoPersona")
    private List<EduInscripcionCarrera> eduInscripcionCarreraList;
    @OneToMany(mappedBy = "perHistTipoPersona")
    private List<EduAsignacionDocente> eduAsignacionDocenteList;
    @JoinColumn(name = "cod_institucion_educativa", referencedColumnName = "cod_institucion_educativa")
    @ManyToOne
    private EduInstitucionEducativa codInstitucionEducativa;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PerPersona perPersona;
    @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PerTipoPersona perTipoPersona;

    public PerHistTipoPersona() {
    }

    public PerHistTipoPersona(PerHistTipoPersonaPK perHistTipoPersonaPK) {
        this.perHistTipoPersonaPK = perHistTipoPersonaPK;
    }

    public PerHistTipoPersona(int codPersona, String codTipoPersona) {
        this.perHistTipoPersonaPK = new PerHistTipoPersonaPK(codPersona, codTipoPersona);
    }

    public PerHistTipoPersonaPK getPerHistTipoPersonaPK() {
        return perHistTipoPersonaPK;
    }

    public void setPerHistTipoPersonaPK(PerHistTipoPersonaPK perHistTipoPersonaPK) {
        this.perHistTipoPersonaPK = perHistTipoPersonaPK;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCodUsuarioIni() {
        return codUsuarioIni;
    }

    public void setCodUsuarioIni(String codUsuarioIni) {
        this.codUsuarioIni = codUsuarioIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodUsuarioFin() {
        return codUsuarioFin;
    }

    public void setCodUsuarioFin(String codUsuarioFin) {
        this.codUsuarioFin = codUsuarioFin;
    }

    public String getAudUsuario() {
        return audUsuario;
    }

    public void setAudUsuario(String audUsuario) {
        this.audUsuario = audUsuario;
    }

    public Date getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    public String getAudIp() {
        return audIp;
    }

    public void setAudIp(String audIp) {
        this.audIp = audIp;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<EduInscripcionCarrera> getEduInscripcionCarreraList() {
        return eduInscripcionCarreraList;
    }

    public void setEduInscripcionCarreraList(List<EduInscripcionCarrera> eduInscripcionCarreraList) {
        this.eduInscripcionCarreraList = eduInscripcionCarreraList;
    }

    public List<EduAsignacionDocente> getEduAsignacionDocenteList() {
        return eduAsignacionDocenteList;
    }

    public void setEduAsignacionDocenteList(List<EduAsignacionDocente> eduAsignacionDocenteList) {
        this.eduAsignacionDocenteList = eduAsignacionDocenteList;
    }

    public EduInstitucionEducativa getCodInstitucionEducativa() {
        return codInstitucionEducativa;
    }

    public void setCodInstitucionEducativa(EduInstitucionEducativa codInstitucionEducativa) {
        this.codInstitucionEducativa = codInstitucionEducativa;
    }

    public PerPersona getPerPersona() {
        return perPersona;
    }

    public void setPerPersona(PerPersona perPersona) {
        this.perPersona = perPersona;
    }

    public PerTipoPersona getPerTipoPersona() {
        return perTipoPersona;
    }

    public void setPerTipoPersona(PerTipoPersona perTipoPersona) {
        this.perTipoPersona = perTipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perHistTipoPersonaPK != null ? perHistTipoPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PerHistTipoPersona)) {
            return false;
        }
        PerHistTipoPersona other = (PerHistTipoPersona) object;
        if ((this.perHistTipoPersonaPK == null && other.perHistTipoPersonaPK != null) || (this.perHistTipoPersonaPK != null && !this.perHistTipoPersonaPK.equals(other.perHistTipoPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ perHistTipoPersonaPK=" + perHistTipoPersonaPK + " ]";
    }
    
}
