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
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "edu_calificacion")
public class EduCalificacion implements Serializable {

    private static final long serialVersionUID = 132232L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_calificacion", nullable = false)
    private Integer codCalificacion;
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
    @Column(name = "estado", length = 3)
    private String estado;
    @Column(name = "observacion", length = 25)
    private String observacion;
    @JoinColumn(name = "cod_inscripcion", referencedColumnName = "cod_matricula", nullable = false)
    @ManyToOne(optional = false)
    private EduMatricula codInscripcion;

    public EduCalificacion() {
    }

    public EduCalificacion(Integer codCalificacion) {
        this.codCalificacion = codCalificacion;
    }

    public Integer getCodCalificacion() {
        return codCalificacion;
    }

    public void setCodCalificacion(Integer codCalificacion) {
        this.codCalificacion = codCalificacion;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public EduMatricula getCodInscripcion() {
        return codInscripcion;
    }

    public void setCodInscripcion(EduMatricula codInscripcion) {
        this.codInscripcion = codInscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCalificacion != null ? codCalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduCalificacion)) {
            return false;
        }
        EduCalificacion other = (EduCalificacion) object;
        if ((this.codCalificacion == null && other.codCalificacion != null) || (this.codCalificacion != null && !this.codCalificacion.equals(other.codCalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codCalificacion=" + codCalificacion + " ]";
    }
    
}
