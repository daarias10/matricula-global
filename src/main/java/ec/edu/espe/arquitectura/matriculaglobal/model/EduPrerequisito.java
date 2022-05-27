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
    
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false)})
    @ManyToOne(optional = false)
    private EduMateria eduMateria;
    @JoinColumns({
        @JoinColumn(name = "cod_materia_prerequisito", referencedColumnName = "cod_materia", nullable = false),
        @JoinColumn(name = "edu_cod_departamento", referencedColumnName = "cod_departamento", nullable = false)})
    @ManyToOne(optional = false)
    private EduMateria eduMateria1;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EduMateria getEduMateria() {
        return eduMateria;
    }

    public void setEduMateria(EduMateria eduMateria) {
        this.eduMateria = eduMateria;
    }

    public EduMateria getEduMateria1() {
        return eduMateria1;
    }

    public void setEduMateria1(EduMateria eduMateria1) {
        this.eduMateria1 = eduMateria1;
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
