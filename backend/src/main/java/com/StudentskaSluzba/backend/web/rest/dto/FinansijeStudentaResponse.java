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


public class FinansijeStudentaResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    private Long studentId;

    @NotNull
    private BigDecimal iznos;

    @NotNull
    @Size(max = 255)
    private String opis;

    @NotNull
    private BigDecimal prethodnoStanje;

    @NotNull
    private ZonedDateTime datum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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
        final FinansijeStudentaResponse other = (FinansijeStudentaResponse) obj;
        if ((id == null && other.id != null) || !id.equals(other.id))
            return false;
        if ((studentId == null && other.studentId != null) || !studentId.equals(other.studentId))
            return false;
        if ((iznos == null && other.iznos != null) || !iznos.equals(other.iznos))
            return false;
        if ((opis == null && other.opis != null) || !opis.equals(other.opis))
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
        result = prime * result + ((iznos == null) ? 0 : iznos.hashCode());
        result = prime * result + ((opis == null) ? 0 : opis.hashCode());
        result = prime * result + ((prethodnoStanje == null) ? 0 : prethodnoStanje.hashCode());
        result = prime * result + ((datum == null) ? 0 : datum.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FinansijeStudentaResponse[" + "id=" + id + ", studentId=" + studentId + ", iznos=" + iznos + ", opis=" + opis + ", prethodnoStanje=" + prethodnoStanje + ", datum=" + datum + "]";
    }

}
