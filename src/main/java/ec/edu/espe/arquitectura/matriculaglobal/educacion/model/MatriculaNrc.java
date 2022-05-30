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

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "edu_matricula_nrc")

public class MatriculaNrc implements Serializable {

    private static final long serialVersionUID = 12345L;
    @EmbeddedId
    protected MatriculaNrcPK matriculaNrcPK;
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Column(name = "numero", nullable = false)
    private short numero;
    @Column(name = "costo", nullable = false, precision = 7, scale = 2)
    private BigDecimal costo;
    @JoinColumns({
        @JoinColumn(name = "cod_matricula", referencedColumnName = "cod_matricula", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Matricula matricula;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Nrc nrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculaNrc")
    private List<Calificacion> calificacionList;

    public MatriculaNrc() {
    }

    public MatriculaNrc(MatriculaNrcPK matriculaNrcPK) {
        this.matriculaNrcPK = matriculaNrcPK;
    }

    public MatriculaNrc(short codNrc, int codPeriodo, int codDepartamento, int codMateria, String codMatricula, int codPersona) {
        this.matriculaNrcPK = new MatriculaNrcPK(codNrc, codPeriodo, codDepartamento, codMateria, codMatricula, codPersona);
    }

    public MatriculaNrcPK getMatriculaNrcPK() {
        return matriculaNrcPK;
    }

    public void setMatriculaNrcPK(MatriculaNrcPK matriculaNrcPK) {
        this.matriculaNrcPK = matriculaNrcPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Nrc getNrc() {
        return nrc;
    }

    public void setNrc(Nrc nrc) {
        this.nrc = nrc;
    }

    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaNrcPK != null ? matriculaNrcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MatriculaNrc)) {
            return false;
        }
        MatriculaNrc other = (MatriculaNrc) object;
        if ((this.matriculaNrcPK == null && other.matriculaNrcPK != null) || (this.matriculaNrcPK != null && !this.matriculaNrcPK.equals(other.matriculaNrcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ matriculaNrcPK=" + matriculaNrcPK + " ]";
    }
    
}
