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
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "edu_matricula", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cod_periodo"})})

public class Matricula implements Serializable {

    private static final long serialVersionUID = 12345L;
    @EmbeddedId
    protected MatriculaPK matriculaPK;
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "costo", nullable = false)
    private double costo;
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", nullable = false)
    @ManyToOne(optional = false)
    private Carrera codCarrera;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false)
    @OneToOne(optional = false)
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private List<MatriculaNrc> matriculaNrcList;

    public Matricula() {
    }

    public Matricula(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public Matricula(String codMatricula, int codPersona) {
        this.matriculaPK = new MatriculaPK(codMatricula, codPersona);
    }

    public MatriculaPK getMatriculaPK() {
        return matriculaPK;
    }

    public void setMatriculaPK(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Carrera getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Carrera codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
        hash += (matriculaPK != null ? matriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.matriculaPK == null && other.matriculaPK != null) || (this.matriculaPK != null && !this.matriculaPK.equals(other.matriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ matriculaPK=" + matriculaPK + " ]";
    }
    
}