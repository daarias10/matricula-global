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

import ec.edu.espe.arquitectura.matriculaglobal.general.model.UbicacionGeografica;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "edu_institucion_educativa")
public class InstitucionEducativa implements Serializable {

    private static final long serialVersionUID = 12345L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_institucion_educativa", nullable = false)
    private Integer codInstitucionEducativa;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @Column(name = "direccion", nullable = false, length = 500)
    private String direccion;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @JoinColumn(name = "cod_ubicacion_geo_int", referencedColumnName = "cod_ubicacion_geo_int", nullable = false)
    @ManyToOne(optional = false)
    private UbicacionGeografica codUbicacionGeoInt;

    public InstitucionEducativa() {
    }

    public InstitucionEducativa(Integer codInstitucionEducativa) {
        this.codInstitucionEducativa = codInstitucionEducativa;
    }

    public Integer getCodInstitucionEducativa() {
        return codInstitucionEducativa;
    }

    public void setCodInstitucionEducativa(Integer codInstitucionEducativa) {
        this.codInstitucionEducativa = codInstitucionEducativa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public UbicacionGeografica getCodUbicacionGeoInt() {
        return codUbicacionGeoInt;
    }

    public void setCodUbicacionGeoInt(UbicacionGeografica codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInstitucionEducativa != null ? codInstitucionEducativa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof InstitucionEducativa)) {
            return false;
        }
        InstitucionEducativa other = (InstitucionEducativa) object;
        if ((this.codInstitucionEducativa == null && other.codInstitucionEducativa != null) || (this.codInstitucionEducativa != null && !this.codInstitucionEducativa.equals(other.codInstitucionEducativa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codInstitucionEducativa=" + codInstitucionEducativa + " ]";
    }
    
}
