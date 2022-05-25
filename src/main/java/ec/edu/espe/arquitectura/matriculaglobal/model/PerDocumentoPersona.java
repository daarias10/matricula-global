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
@Table(name = "per_documento_persona")
public class PerDocumentoPersona implements Serializable {

    private static final long serialVersionUID = 19922L;
    @EmbeddedId
    protected PerDocumentoPersonaPK perDocumentoPersonaPK;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "archivado", length = 1)
    private String archivado;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_caducidad")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidad;
    @Column(name = "digitalizado", length = 1)
    private String digitalizado;
    @Column(name = "url", length = 255)
    private String url;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PerPersona perPersona;
    @JoinColumn(name = "cod_tipo_documento", referencedColumnName = "cod_tipo_documento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PerTipoDocumento perTipoDocumento;

    public PerDocumentoPersona() {
    }

    public PerDocumentoPersona(PerDocumentoPersonaPK perDocumentoPersonaPK) {
        this.perDocumentoPersonaPK = perDocumentoPersonaPK;
    }

    public PerDocumentoPersona(int codPersona, String codTipoDocumento) {
        this.perDocumentoPersonaPK = new PerDocumentoPersonaPK(codPersona, codTipoDocumento);
    }

    public PerDocumentoPersonaPK getPerDocumentoPersonaPK() {
        return perDocumentoPersonaPK;
    }

    public void setPerDocumentoPersonaPK(PerDocumentoPersonaPK perDocumentoPersonaPK) {
        this.perDocumentoPersonaPK = perDocumentoPersonaPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getArchivado() {
        return archivado;
    }

    public void setArchivado(String archivado) {
        this.archivado = archivado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getDigitalizado() {
        return digitalizado;
    }

    public void setDigitalizado(String digitalizado) {
        this.digitalizado = digitalizado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public PerPersona getPerPersona() {
        return perPersona;
    }

    public void setPerPersona(PerPersona perPersona) {
        this.perPersona = perPersona;
    }

    public PerTipoDocumento getPerTipoDocumento() {
        return perTipoDocumento;
    }

    public void setPerTipoDocumento(PerTipoDocumento perTipoDocumento) {
        this.perTipoDocumento = perTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perDocumentoPersonaPK != null ? perDocumentoPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PerDocumentoPersona)) {
            return false;
        }
        PerDocumentoPersona other = (PerDocumentoPersona) object;
        if ((this.perDocumentoPersonaPK == null && other.perDocumentoPersonaPK != null) || (this.perDocumentoPersonaPK != null && !this.perDocumentoPersonaPK.equals(other.perDocumentoPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ perDocumentoPersonaPK=" + perDocumentoPersonaPK + " ]";
    }
    
}
