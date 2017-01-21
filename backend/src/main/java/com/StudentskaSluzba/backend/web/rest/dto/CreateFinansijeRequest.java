/**
* Copyright 2016 dryTools doo
* Email: contact@drytools.co
* 
* This file is part of StudentskaSluzba.
* 
* StudentskaSluzba is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* StudentskaSluzba is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with StudentskaSluzba. If not, see <http://www.gnu.org/licenses/>.*
**/
package com.StudentskaSluzba.backend.web.rest.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.*;

import javax.validation.constraints.*;


public class CreateFinansijeRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long studentId;

    @NotNull
    private BigDecimal iznos;

    @NotNull
    private BigDecimal prethodnoStanje;

    @NotNull
    private ZonedDateTime datum;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public BigDecimal getPrethodnoStanje() {
        return prethodnoStanje;
    }

    public void setPrethodnoStanje(BigDecimal prethodnoStanje) {
        this.prethodnoStanje = prethodnoStanje;
    }

    public ZonedDateTime getDatum() {
        return datum;
    }

    public void setDatum(ZonedDateTime datum) {
        this.datum = datum;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CreateFinansijeRequest other = (CreateFinansijeRequest) obj;
        if ((studentId == null && other.studentId != null) || !studentId.equals(other.studentId))
            return false;
        if ((iznos == null && other.iznos != null) || !iznos.equals(other.iznos))
            return false;
        if ((prethodnoStanje == null && other.prethodnoStanje != null) || !prethodnoStanje.equals(other.prethodnoStanje))
            return false;
        if ((datum == null && other.datum != null) || !datum.equals(other.datum))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
        result = prime * result + ((iznos == null) ? 0 : iznos.hashCode());
        result = prime * result + ((prethodnoStanje == null) ? 0 : prethodnoStanje.hashCode());
        result = prime * result + ((datum == null) ? 0 : datum.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CreateFinansijeRequest[" + "studentId=" + studentId + ", iznos=" + iznos + ", prethodnoStanje=" + prethodnoStanje + ", datum=" + datum + "]";
    }

}
