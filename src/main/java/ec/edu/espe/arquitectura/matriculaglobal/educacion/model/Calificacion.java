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
import javax.persistence.*;

@Entity
@Table(name = "edu_calificacion")

public class Calificacion implements Serializable {

    private static final long serialVersionUID = 31322L;
    @EmbeddedId
    protected CalificacionPK calificacionPK;
    @Column(name = "nota1", precision = 5, scale = 2)
    private BigDecimal nota1;
    @Column(name = "nota2", precision = 5, scale = 2)
    private BigDecimal nota2;
    @Column(name = "nota3", precision = 5, scale = 2)
    private BigDecimal nota3;
    @Column(name = "nota4", precision = 5, scale = 2)
    private BigDecimal nota4;
    @Column(name = "nota5", precision = 5, scale = 2)
    private BigDecimal nota5;
    @Column(name = "nota6", precision = 5, scale = 2)
    private BigDecimal nota6;
    @Column(name = "nota7", precision = 5, scale = 2)
    private BigDecimal nota7;
    @Column(name = "nota8", precision = 5, scale = 2)
    private BigDecimal nota8;
    @Column(name = "nota9", precision = 5, scale = 2)
    private BigDecimal nota9;
    @Column(name = "nota10", precision = 5, scale = 2)
    private BigDecimal nota10;
    @Column(name = "promedio", precision = 5, scale = 2)
    private BigDecimal promedio;
    @Column(name = "observacion", length = 25)
    private String observacion;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_matricula", referencedColumnName = "cod_matricula", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private MatriculaNrc matriculaNrc;

    public Calificacion() {
    }

    public Calificacion(CalificacionPK calificacionPK) {
        this.calificacionPK = calificacionPK;
    }

    public Calificacion(String codMatricula, short codNrc) {
        this.calificacionPK = new CalificacionPK(codMatricula, codNrc);
    }

    public CalificacionPK getCalificacionPK() {
        return calificacionPK;
    }

    public void setcalificacionPK(CalificacionPK CalificacionPK) {
        this.calificacionPK = CalificacionPK;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    public BigDecimal getNota4() {
        return nota4;
    }

    public void setNota4(BigDecimal nota4) {
        this.nota4 = nota4;
    }

    public BigDecimal getNota5() {
        return nota5;
    }

    public void setNota5(BigDecimal nota5) {
        this.nota5 = nota5;
    }

    public BigDecimal getNota6() {
        return nota6;
    }

    public void setNota6(BigDecimal nota6) {
        this.nota6 = nota6;
    }

    public BigDecimal getNota7() {
        return nota7;
    }

    public void setNota7(BigDecimal nota7) {
        this.nota7 = nota7;
    }

    public BigDecimal getNota8() {
        return nota8;
    }

    public void setNota8(BigDecimal nota8) {
        this.nota8 = nota8;
    }

    public BigDecimal getNota9() {
        return nota9;
    }

    public void setNota9(BigDecimal nota9) {
        this.nota9 = nota9;
    }

    public BigDecimal getNota10() {
        return nota10;
    }

    public void setNota10(BigDecimal nota10) {
        this.nota10 = nota10;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public MatriculaNrc getMatriculaNrc() {
        return matriculaNrc;
    }

    public void setMatriculaNrc(MatriculaNrc matriculaNrc) {
        this.matriculaNrc = matriculaNrc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calificacionPK != null ? calificacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.calificacionPK == null && other.calificacionPK != null) || (this.calificacionPK != null && !this.calificacionPK.equals(other.calificacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ CalificacionPK=" + calificacionPK + " ]";
    }
    
}