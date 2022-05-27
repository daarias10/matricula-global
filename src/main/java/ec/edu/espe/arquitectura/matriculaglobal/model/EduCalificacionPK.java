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

@Embeddable
public class EduCalificacionPK implements Serializable {

    @Column(name = "cod_matricula", nullable = false, length = 10)
    private String codMatricula;
    @Column(name = "cod_nrc", nullable = false)
    private short codNrc;

    public EduCalificacionPK() {
    }

    public EduCalificacionPK(String codMatricula, short codNrc) {
        this.codMatricula = codMatricula;
        this.codNrc = codNrc;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public short getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(short codNrc) {
        this.codNrc = codNrc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMatricula != null ? codMatricula.hashCode() : 0);
        hash += (int) codNrc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduCalificacionPK)) {
            return false;
        }
        EduCalificacionPK other = (EduCalificacionPK) object;
        if ((this.codMatricula == null && other.codMatricula != null) || (this.codMatricula != null && !this.codMatricula.equals(other.codMatricula))) {
            return false;
        }
        if (this.codNrc != other.codNrc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ codMatricula=" + codMatricula + ", codNrc=" + codNrc + " ]";
    }
    
}