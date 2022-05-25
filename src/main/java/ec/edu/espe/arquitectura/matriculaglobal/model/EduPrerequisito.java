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
import javax.persistence.*;

@Entity
@Table(name = "edu_prerequisito")

public class EduPrerequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_prerequisito", nullable = false)
    private Integer codPrerequisito;
    @Column(name = "agrupacion_prerequisitos", nullable = false)
    private int agrupacionPrerequisitos;
    @JoinColumn(name = "cod_materia_padre", referencedColumnName = "cod_materia", nullable = false)
    @ManyToOne(optional = false)
    private EduMateria codMateriaPadre;
    @JoinColumn(name = "edu_cod_materia", referencedColumnName = "cod_materia", nullable = false)
    @ManyToOne(optional = false)
    private EduMateria eduCodMateria;

    public EduPrerequisito() {
    }

    public EduPrerequisito(Integer codPrerequisito) {
        this.codPrerequisito = codPrerequisito;
    }

    public Integer getCodPrerequisito() {
        return codPrerequisito;
    }

    public void setCodPrerequisito(Integer codPrerequisito) {
        this.codPrerequisito = codPrerequisito;
    }

    public int getAgrupacionPrerequisitos() {
        return agrupacionPrerequisitos;
    }

    public void setAgrupacionPrerequisitos(int agrupacionPrerequisitos) {
        this.agrupacionPrerequisitos = agrupacionPrerequisitos;
    }

    public EduMateria getCodMateriaPadre() {
        return codMateriaPadre;
    }

    public void setCodMateriaPadre(EduMateria codMateriaPadre) {
        this.codMateriaPadre = codMateriaPadre;
    }

    public EduMateria getEduCodMateria() {
        return eduCodMateria;
    }

    public void setEduCodMateria(EduMateria eduCodMateria) {
        this.eduCodMateria = eduCodMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrerequisito != null ? codPrerequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduPrerequisito)) {
            return false;
        }
        EduPrerequisito other = (EduPrerequisito) object;
        if ((this.codPrerequisito == null && other.codPrerequisito != null) || (this.codPrerequisito != null && !this.codPrerequisito.equals(other.codPrerequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codPrerequisito=" + codPrerequisito + " ]";
    }
    
}
