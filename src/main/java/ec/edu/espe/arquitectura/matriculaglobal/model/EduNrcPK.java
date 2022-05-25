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
public class EduNrcPK implements Serializable {

    @Column(name = "cod_nrc", nullable = false)
    private short codNrc;
    @Column(name = "cod_periodo", nullable = false)
    private int codPeriodo;

    public EduNrcPK() {
    }

    public EduNrcPK(short codNrc, int codPeriodo) {
        this.codNrc = codNrc;
        this.codPeriodo = codPeriodo;
    }

    public short getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(short codNrc) {
        this.codNrc = codNrc;
    }

    public int getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(int codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codNrc;
        hash += (int) codPeriodo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduNrcPK)) {
            return false;
        }
        EduNrcPK other = (EduNrcPK) object;
        if (this.codNrc != other.codNrc) {
            return false;
        }
        if (this.codPeriodo != other.codPeriodo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matriculaglobal.model.EduNrcPK[ codNrc=" + codNrc + ", codPeriodo=" + codPeriodo + " ]";
    }
    
}
