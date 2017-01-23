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


public class PolozeniPredmetiResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long predmetId;

    @NotNull
    @Size(max = 255)
    private String predmetNaziv;

    @NotNull
    @Min(0)
    private Integer predmetEspb;

    @NotNull
    private Boolean predmetObavezni;

    @NotNull
    @Size(max = 255)
    private String predmetImeProfesora;

    @NotNull
    @Min(1)
    private Integer semestarPrvogSlusanja;

    @Max(10)
    private Integer ocena;

    private ZonedDateTime datumPolozeno;

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long predmetId) {
        this.predmetId = predmetId;
    }

    public String getPredmetNaziv() {
        return predmetNaziv;
    }

    public void setPredmetNaziv(String predmetNaziv) {
        this.predmetNaziv = predmetNaziv;
    }

    public Integer getPredmetEspb() {
        return predmetEspb;
    }

    public void setPredmetEspb(Integer predmetEspb) {
        this.predmetEspb = predmetEspb;
    }

    public Boolean getPredmetObavezni() {
        return predmetObavezni;
    }

    public void setPredmetObavezni(Boolean predmetObavezni) {
        this.predmetObavezni = predmetObavezni;
    }

    public String getPredmetImeProfesora() {
        return predmetImeProfesora;
    }

    public void setPredmetImeProfesora(String predmetImeProfesora) {
        this.predmetImeProfesora = predmetImeProfesora;
    }

    public Integer getSemestarPrvogSlusanja() {
        return semestarPrvogSlusanja;
    }

    public void setSemestarPrvogSlusanja(Integer semestarPrvogSlusanja) {
        this.semestarPrvogSlusanja = semestarPrvogSlusanja;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final PolozeniPredmetiResponse other = (PolozeniPredmetiResponse) obj;
        if ((predmetId == null && other.predmetId != null) || !predmetId.equals(other.predmetId))
            return false;
        if ((predmetNaziv == null && other.predmetNaziv != null) || !predmetNaziv.equals(other.predmetNaziv))
            return false;
        if ((predmetEspb == null && other.predmetEspb != null) || !predmetEspb.equals(other.predmetEspb))
            return false;
        if ((predmetObavezni == null && other.predmetObavezni != null) || !predmetObavezni.equals(other.predmetObavezni))
            return false;
        if ((predmetImeProfesora == null && other.predmetImeProfesora != null) || !predmetImeProfesora.equals(other.predmetImeProfesora))
            return false;
        if ((semestarPrvogSlusanja == null && other.semestarPrvogSlusanja != null) || !semestarPrvogSlusanja.equals(other.semestarPrvogSlusanja))
            return false;
        if ((ocena == null && other.ocena != null) || !ocena.equals(other.ocena))
            return false;
        if ((datumPolozeno == null && other.datumPolozeno != null) || !datumPolozeno.equals(other.datumPolozeno))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((predmetId == null) ? 0 : predmetId.hashCode());
        result = prime * result + ((predmetNaziv == null) ? 0 : predmetNaziv.hashCode());
        result = prime * result + ((predmetEspb == null) ? 0 : predmetEspb.hashCode());
        result = prime * result + ((predmetObavezni == null) ? 0 : predmetObavezni.hashCode());
        result = prime * result + ((predmetImeProfesora == null) ? 0 : predmetImeProfesora.hashCode());
        result = prime * result + ((semestarPrvogSlusanja == null) ? 0 : semestarPrvogSlusanja.hashCode());
        result = prime * result + ((ocena == null) ? 0 : ocena.hashCode());
        result = prime * result + ((datumPolozeno == null) ? 0 : datumPolozeno.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PolozeniPredmetiResponse[" + "predmetId=" + predmetId + ", predmetNaziv=" + predmetNaziv + ", predmetEspb=" + predmetEspb + ", predmetObavezni=" + predmetObavezni
                + ", predmetImeProfesora=" + predmetImeProfesora + ", semestarPrvogSlusanja=" + semestarPrvogSlusanja + ", ocena=" + ocena + ", datumPolozeno=" + datumPolozeno + "]";
    }

}
