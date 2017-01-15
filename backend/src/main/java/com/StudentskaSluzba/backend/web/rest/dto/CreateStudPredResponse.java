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

import java.time.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;


public class CreateStudPredResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    private Long studentId;

    @NotNull
    private Long predmetId;

    @Max(10)
    private Integer ocena;

    private ZonedDateTime datumPolozeno;

    @NotNull
    @Min(1)
    private Integer semestarPrvogSlusanja;

    @NotNull
    @Min(1)
    private Integer semestarPoslednjeSlusanja;

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

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long predmetId) {
        this.predmetId = predmetId;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public ZonedDateTime getDatumPolozeno() {
        return datumPolozeno;
    }

    public void setDatumPolozeno(ZonedDateTime datumPolozeno) {
        this.datumPolozeno = datumPolozeno;
    }

    public Integer getSemestarPrvogSlusanja() {
        return semestarPrvogSlusanja;
    }

    public void setSemestarPrvogSlusanja(Integer semestarPrvogSlusanja) {
        this.semestarPrvogSlusanja = semestarPrvogSlusanja;
    }

    public Integer getSemestarPoslednjeSlusanja() {
        return semestarPoslednjeSlusanja;
    }

    public void setSemestarPoslednjeSlusanja(Integer semestarPoslednjeSlusanja) {
        this.semestarPoslednjeSlusanja = semestarPoslednjeSlusanja;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CreateStudPredResponse other = (CreateStudPredResponse) obj;
        if ((id == null && other.id != null) || !id.equals(other.id))
            return false;
        if ((studentId == null && other.studentId != null) || !studentId.equals(other.studentId))
            return false;
        if ((predmetId == null && other.predmetId != null) || !predmetId.equals(other.predmetId))
            return false;
        if ((ocena == null && other.ocena != null) || !ocena.equals(other.ocena))
            return false;
        if ((datumPolozeno == null && other.datumPolozeno != null) || !datumPolozeno.equals(other.datumPolozeno))
            return false;
        if ((semestarPrvogSlusanja == null && other.semestarPrvogSlusanja != null) || !semestarPrvogSlusanja.equals(other.semestarPrvogSlusanja))
            return false;
        if ((semestarPoslednjeSlusanja == null && other.semestarPoslednjeSlusanja != null) || !semestarPoslednjeSlusanja.equals(other.semestarPoslednjeSlusanja))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
        result = prime * result + ((predmetId == null) ? 0 : predmetId.hashCode());
        result = prime * result + ((ocena == null) ? 0 : ocena.hashCode());
        result = prime * result + ((datumPolozeno == null) ? 0 : datumPolozeno.hashCode());
        result = prime * result + ((semestarPrvogSlusanja == null) ? 0 : semestarPrvogSlusanja.hashCode());
        result = prime * result + ((semestarPoslednjeSlusanja == null) ? 0 : semestarPoslednjeSlusanja.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CreateStudPredResponse[" + "id=" + id + ", studentId=" + studentId + ", predmetId=" + predmetId + ", ocena=" + ocena + ", datumPolozeno=" + datumPolozeno + ", semestarPrvogSlusanja="
                + semestarPrvogSlusanja + ", semestarPoslednjeSlusanja=" + semestarPoslednjeSlusanja + "]";
    }

}
