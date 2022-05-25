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
@Table(name = "ofi_sede")
public class OfiSede implements Serializable {

    private static final long serialVersionUID = 1233344L;
    @Id
    @Column(name = "cod_sede", nullable = false, length = 8)
    private String codSede;
    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;
    @Column(name = "direccion", length = 10)
    private String direccion;
    @Column(name = "es_principal", nullable = false, length = 1)
    private String esPrincipal;
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Column(name = "version", nullable = false)
    private int version;
    @OneToMany(mappedBy = "codSede")
    private List<OfiEdificio> ofiEdificioList;
    @JoinColumn(name = "cod_institucion", referencedColumnName = "cod_institucion")
    @ManyToOne
    private OfiInstitucion codInstitucion;

    public OfiSede() {
    }

    public OfiSede(String codSede) {
        this.codSede = codSede;
    }
    
    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(String esPrincipal) {
        this.esPrincipal = esPrincipal;
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

    public List<OfiEdificio> getOfiEdificioList() {
        return ofiEdificioList;
    }

    public void setOfiEdificioList(List<OfiEdificio> ofiEdificioList) {
        this.ofiEdificioList = ofiEdificioList;
    }

    public OfiInstitucion getCodInstitucion() {
        return codInstitucion;
    }

    public void setCodInstitucion(OfiInstitucion codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSede != null ? codSede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfiSede)) {
            return false;
        }
        OfiSede other = (OfiSede) object;
        if ((this.codSede == null && other.codSede != null) || (this.codSede != null && !this.codSede.equals(other.codSede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matriculaglobal.model.OfiSede[ codSede=" + codSede + " ]";
    }
    
}
