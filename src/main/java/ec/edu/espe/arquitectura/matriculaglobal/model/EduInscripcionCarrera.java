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
@Table(name = "edu_inscripcion_carrera")
public class EduInscripcionCarrera implements Serializable {

    private static final long serialVersionUID = 12223L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_inscripcion_carrera", nullable = false)
    private Integer codInscripcionCarrera;
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInscripcionEstudiante")
    private List<EduMatricula> eduMatriculaList;
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", nullable = false)
    @ManyToOne(optional = false)
    private EduCarrera codCarrera;
    @JoinColumns({
        @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona"),
        @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona")})
    @ManyToOne
    private PerHistTipoPersona perHistTipoPersona;

    public EduInscripcionCarrera() {
    }

    public EduInscripcionCarrera(Integer codInscripcionCarrera) {
        this.codInscripcionCarrera = codInscripcionCarrera;
    }

    public Integer getCodInscripcionCarrera() {
        return codInscripcionCarrera;
    }

    public void setCodInscripcionCarrera(Integer codInscripcionCarrera) {
        this.codInscripcionCarrera = codInscripcionCarrera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<EduMatricula> getEduMatriculaList() {
        return eduMatriculaList;
    }

    public void setEduMatriculaList(List<EduMatricula> eduMatriculaList) {
        this.eduMatriculaList = eduMatriculaList;
    }

    public EduCarrera getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(EduCarrera codCarrera) {
        this.codCarrera = codCarrera;
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
        hash += (codInscripcionCarrera != null ? codInscripcionCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduInscripcionCarrera)) {
            return false;
        }
        EduInscripcionCarrera other = (EduInscripcionCarrera) object;
        if ((this.codInscripcionCarrera == null && other.codInscripcionCarrera != null) || (this.codInscripcionCarrera != null && !this.codInscripcionCarrera.equals(other.codInscripcionCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codInscripcionCarrera=" + codInscripcionCarrera + " ]";
    }
    
}
