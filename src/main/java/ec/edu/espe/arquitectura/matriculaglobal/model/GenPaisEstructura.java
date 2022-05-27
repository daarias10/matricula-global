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
@Table(name = "gen_pais_estructura")

public class GenPaisEstructura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GenPaisEstructuraPK genPaisEstructuraPK;
    
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    
    @Column(name = "version", nullable = false)
    private int version;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GenPais genPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genPaisEstructura")
    private List<GenUbicacionGeografica> genUbicacionGeograficaList;

    public GenPaisEstructura() {
    }

    public GenPaisEstructura(GenPaisEstructuraPK genPaisEstructuraPK) {
        this.genPaisEstructuraPK = genPaisEstructuraPK;
    }

    public GenPaisEstructura(String codPais, short nivel) {
        this.genPaisEstructuraPK = new GenPaisEstructuraPK(codPais, nivel);
    }

    public GenPaisEstructuraPK getGenPaisEstructuraPK() {
        return genPaisEstructuraPK;
    }

    public void setGenPaisEstructuraPK(GenPaisEstructuraPK genPaisEstructuraPK) {
        this.genPaisEstructuraPK = genPaisEstructuraPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public GenPais getGenPais() {
        return genPais;
    }

    public void setGenPais(GenPais genPais) {
        this.genPais = genPais;
    }

    public List<GenUbicacionGeografica> getGenUbicacionGeograficaList() {
        return genUbicacionGeograficaList;
    }

    public void setGenUbicacionGeograficaList(List<GenUbicacionGeografica> genUbicacionGeograficaList) {
        this.genUbicacionGeograficaList = genUbicacionGeograficaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genPaisEstructuraPK != null ? genPaisEstructuraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof GenPaisEstructura)) {
            return false;
        }
        GenPaisEstructura other = (GenPaisEstructura) object;
        if ((this.genPaisEstructuraPK == null && other.genPaisEstructuraPK != null) || (this.genPaisEstructuraPK != null && !this.genPaisEstructuraPK.equals(other.genPaisEstructuraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ genPaisEstructuraPK=" + genPaisEstructuraPK + " ]";
    }
    
}
