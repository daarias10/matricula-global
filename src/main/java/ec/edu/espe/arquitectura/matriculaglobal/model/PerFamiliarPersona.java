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
@Table(name = "per_familiar_persona")
public class PerFamiliarPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerFamiliarPersonaPK perFamiliarPersonaPK;
    @Column(name = "tipo_familiar", nullable = false, length = 3)
    private String tipoFamiliar;
    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;
    @Column(name = "tipo_identificacion", length = 3)
    private String tipoIdentificacion;
    @Column(name = "identificacion", length = 20)
    private String identificacion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "telefono", length = 20)
    private String telefono;
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

    public PerFamiliarPersona() {
    }

    public PerFamiliarPersona(int codPersona, short secFamiliarPersona) {
        this.perFamiliarPersonaPK = new PerFamiliarPersonaPK(codPersona, secFamiliarPersona);
    }

    public PerFamiliarPersonaPK getPerFamiliarPersonaPK() {
        return perFamiliarPersonaPK;
    }

    public void setPerFamiliarPersonaPK(PerFamiliarPersonaPK perFamiliarPersonaPK) {
        this.perFamiliarPersonaPK = perFamiliarPersonaPK;
    }

    public String getTipoFamiliar() {
        return tipoFamiliar;
    }

    public void setTipoFamiliar(String tipoFamiliar) {
        this.tipoFamiliar = tipoFamiliar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perFamiliarPersonaPK != null ? perFamiliarPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PerFamiliarPersona)) {
            return false;
        }
        PerFamiliarPersona other = (PerFamiliarPersona) object;
        if ((this.perFamiliarPersonaPK == null && other.perFamiliarPersonaPK != null) || (this.perFamiliarPersonaPK != null && !this.perFamiliarPersonaPK.equals(other.perFamiliarPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ perFamiliarPersonaPK=" + perFamiliarPersonaPK + " ]";
    }
    
}
