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
@Table(name = "Prijava")
public class Prijava implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rokId")
    private Rok rok;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "studPredId")
    private StudPred studPred;

    public Prijava() {
    }

    public Prijava(Long id, Rok rok, StudPred studPred) {
        this.id = id;
        this.rok = rok;
        this.studPred = studPred;
    }

    public Prijava(Rok rok, StudPred studPred) {
        this.rok = rok;
        this.studPred = studPred;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rok getRok() {
        return rok;
    }

    public void setRok(Rok rok) {
        this.rok = rok;
    }

    public StudPred getStudPred() {
        return studPred;
    }

    public void setStudPred(StudPred studPred) {
        this.studPred = studPred;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Prijava other = (Prijava) obj;
        if ((id == null && other.id != null) || !id.equals(other.id))
            return false;
        if (((rok == null || rok.getId() == null) && (other.rok != null && other.rok.getId() != null)) || !rok.getId().equals(other.rok.getId()))
            return false;
        if (((studPred == null || studPred.getId() == null) && (other.studPred != null && other.studPred.getId() != null)) || !studPred.getId().equals(other.studPred.getId()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((rok == null || rok.getId() == null) ? 0 : rok.getId().hashCode());
        result = prime * result + ((studPred == null || studPred.getId() == null) ? 0 : studPred.getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Prijava[" + "id=" + id + ", rok=" + (rok == null ? rok : rok.getId()) + ", studPred=" + (studPred == null ? studPred : studPred.getId()) + "]";
    }

}
