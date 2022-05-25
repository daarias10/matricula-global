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
@Table(name = "edu_matricula", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cod_periodo"})})
public class EduMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_matricula", nullable = false)
    private Integer codMatricula;
    @Column(name = "tipo", nullable = false)
    private int tipo;
    @Column(name = "modo", nullable = false, length = 32)
    private String modo;
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "costo", nullable = false)
    private double costo;
    @JoinColumn(name = "cod_inscripcion_estudiante", referencedColumnName = "cod_inscripcion_carrera", nullable = false)
    @ManyToOne(optional = false)
    private EduInscripcionCarrera codInscripcionEstudiante;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false)})
    @ManyToOne(optional = false)
    private EduNrc eduNrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInscripcion")
    private List<EduCalificacion> eduCalificacionList;

    public EduMatricula() {
    }

    public EduMatricula(Integer codMatricula) {
        this.codMatricula = codMatricula;
    }

    public Integer getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(Integer codMatricula) {
        this.codMatricula = codMatricula;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public EduInscripcionCarrera getCodInscripcionEstudiante() {
        return codInscripcionEstudiante;
    }

    public void setCodInscripcionEstudiante(EduInscripcionCarrera codInscripcionEstudiante) {
        this.codInscripcionEstudiante = codInscripcionEstudiante;
    }

    public EduNrc getEduNrc() {
        return eduNrc;
    }

    public void setEduNrc(EduNrc eduNrc) {
        this.eduNrc = eduNrc;
    }

    public List<EduCalificacion> getEduCalificacionList() {
        return eduCalificacionList;
    }

    public void setEduCalificacionList(List<EduCalificacion> eduCalificacionList) {
        this.eduCalificacionList = eduCalificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMatricula != null ? codMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduMatricula)) {
            return false;
        }
        EduMatricula other = (EduMatricula) object;
        if ((this.codMatricula == null && other.codMatricula != null) || (this.codMatricula != null && !this.codMatricula.equals(other.codMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codMatricula=" + codMatricula + " ]";
    }
    
}
