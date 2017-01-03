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
package com.StudentskaSluzba.backend.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "Predmet")
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "naziv")
    private String naziv;

    @NotNull
    @Min(0)
    @Column(name = "espb")
    private Integer espb;

    @NotNull
    @Column(name = "obavezni")
    private Boolean obavezni;

    @NotNull
    @Min(1)
    @Column(name = "predlozeniSemestar")
    private Integer predlozeniSemestar;

    @NotNull
    @Size(max = 255)
    @Column(name = "imeProfesora")
    private String imeProfesora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getEspb() {
        return espb;
    }

    public void setEspb(Integer espb) {
        this.espb = espb;
    }

    public Boolean getObavezni() {
        return obavezni;
    }

    public void setObavezni(Boolean obavezni) {
        this.obavezni = obavezni;
    }

    public Integer getPredlozeniSemestar() {
        return predlozeniSemestar;
    }

    public void setPredlozeniSemestar(Integer predlozeniSemestar) {
        this.predlozeniSemestar = predlozeniSemestar;
    }

    public String getImeProfesora() {
        return imeProfesora;
    }

    public void setImeProfesora(String imeProfesora) {
        this.imeProfesora = imeProfesora;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Predmet other = (Predmet) obj;
        if ((id == null && other.id != null) || !id.equals(other.id))
            return false;
        if ((naziv == null && other.naziv != null) || !naziv.equals(other.naziv))
            return false;
        if ((espb == null && other.espb != null) || !espb.equals(other.espb))
            return false;
        if ((obavezni == null && other.obavezni != null) || !obavezni.equals(other.obavezni))
            return false;
        if ((predlozeniSemestar == null && other.predlozeniSemestar != null) || !predlozeniSemestar.equals(other.predlozeniSemestar))
            return false;
        if ((imeProfesora == null && other.imeProfesora != null) || !imeProfesora.equals(other.imeProfesora))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
        result = prime * result + ((espb == null) ? 0 : espb.hashCode());
        result = prime * result + ((obavezni == null) ? 0 : obavezni.hashCode());
        result = prime * result + ((predlozeniSemestar == null) ? 0 : predlozeniSemestar.hashCode());
        result = prime * result + ((imeProfesora == null) ? 0 : imeProfesora.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Predmet[" + "id=" + id + ", naziv=" + naziv + ", espb=" + espb + ", obavezni=" + obavezni + ", predlozeniSemestar=" + predlozeniSemestar + ", imeProfesora=" + imeProfesora + "]";
    }

}
