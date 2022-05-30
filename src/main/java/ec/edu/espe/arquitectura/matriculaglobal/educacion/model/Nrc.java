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

import ec.edu.espe.arquitectura.matriculaglobal.persona.model.Persona;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "edu_nrc", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cod_periodo"})})

public class Nrc implements Serializable {

    private static final long serialVersionUID = 12345L;
    @EmbeddedId
    protected NrcPK nrcPK;
    @Column(name = "cupo_disponible", nullable = false)
    private short cupoDisponible;
    @Column(name = "cupo_registrado", nullable = false)
    private short cupoRegistrado;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Materia materia;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false)
    @ManyToOne(optional = false)
    private Persona codPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrc")
    private List<NrcHorario> nrcHorarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrc")
    private List<MatriculaNrc> matriculaNrcList;

    public Nrc() {
    }

    public Nrc(NrcPK nrcPK) {
        this.nrcPK = nrcPK;
    }

    public Nrc(short codNrc, int codPeriodo, int codDepartamento, int codMateria) {
        this.nrcPK = new NrcPK(codNrc, codPeriodo, codDepartamento, codMateria);
    }

    public NrcPK getNrcPK() {
        return nrcPK;
    }

    public void setNrcPK(NrcPK nrcPK) {
        this.nrcPK = nrcPK;
    }

    public short getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(short cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public short getCupoRegistrado() {
        return cupoRegistrado;
    }

    public void setCupoRegistrado(short cupoRegistrado) {
        this.cupoRegistrado = cupoRegistrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Persona getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Persona codPersona) {
        this.codPersona = codPersona;
    }

    public List<NrcHorario> getNrcHorarioList() {
        return nrcHorarioList;
    }

    public void setNrcHorarioList(List<NrcHorario> nrcHorarioList) {
        this.nrcHorarioList = nrcHorarioList;
    }

    public List<MatriculaNrc> getMatriculaNrcList() {
        return matriculaNrcList;
    }

    public void setMatriculaNrcList(List<MatriculaNrc> matriculaNrcList) {
        this.matriculaNrcList = matriculaNrcList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrcPK != null ? nrcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Nrc)) {
            return false;
        }
        Nrc other = (Nrc) object;
        if ((this.nrcPK == null && other.nrcPK != null) || (this.nrcPK != null && !this.nrcPK.equals(other.nrcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ nrcPK=" + nrcPK + " ]";
    }
    
}
