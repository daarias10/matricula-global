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
@Table(name = "gen_pais")

public class GenPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "cod_pais", nullable = false, length = 2)
    private String codPais;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "por_omision", nullable = false, length = 1)
    private String porOmision;
    @Column(name = "codigo_telefonico", length = 3)
    private String codigoTelefonico;
    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;
    
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    
    @Column(name = "version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genPais")
    private List<GenPaisEstructura> genPaisEstructuraList;
    @OneToMany(mappedBy = "codPais")
    private List<GenUbicacionGeografica> genUbicacionGeograficaList;
    @OneToMany(mappedBy = "codPaisNacimiento")
    private List<PerPersona> perPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidad")
    private List<PerPersona> perPersonaList1;

    public GenPais() {
    }

    public GenPais(String codPais) {
        this.codPais = codPais;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorOmision() {
        return porOmision;
    }

    public void setPorOmision(String porOmision) {
        this.porOmision = porOmision;
    }

    public String getCodigoTelefonico() {
        return codigoTelefonico;
    }

    public void setCodigoTelefonico(String codigoTelefonico) {
        this.codigoTelefonico = codigoTelefonico;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public List<GenPaisEstructura> getGenPaisEstructuraList() {
        return genPaisEstructuraList;
    }

    public void setGenPaisEstructuraList(List<GenPaisEstructura> genPaisEstructuraList) {
        this.genPaisEstructuraList = genPaisEstructuraList;
    }

    public List<GenUbicacionGeografica> getGenUbicacionGeograficaList() {
        return genUbicacionGeograficaList;
    }

    public void setGenUbicacionGeograficaList(List<GenUbicacionGeografica> genUbicacionGeograficaList) {
        this.genUbicacionGeograficaList = genUbicacionGeograficaList;
    }

    public List<PerPersona> getPerPersonaList() {
        return perPersonaList;
    }

    public void setPerPersonaList(List<PerPersona> perPersonaList) {
        this.perPersonaList = perPersonaList;
    }

    public List<PerPersona> getPerPersonaList1() {
        return perPersonaList1;
    }

    public void setPerPersonaList1(List<PerPersona> perPersonaList1) {
        this.perPersonaList1 = perPersonaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof GenPais)) {
            return false;
        }
        GenPais other = (GenPais) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPais=" + codPais + " ]";
    }
    
}
