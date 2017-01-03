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
@Table(name = "StudPred")
public class StudPred implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "studentId")
    private Student student;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "predmetId")
    private Predmet predmet;

    public StudPred() {
    }

    public StudPred(Long id, Student student, Predmet predmet) {
        this.id = id;
        this.student = student;
        this.predmet = predmet;
    }

    public StudPred(Student student, Predmet predmet) {
        this.student = student;
        this.predmet = predmet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final StudPred other = (StudPred) obj;
        if ((id == null && other.id != null) || !id.equals(other.id))
            return false;
        if (((student == null || student.getId() == null) && (other.student != null && other.student.getId() != null)) || !student.getId().equals(other.student.getId()))
            return false;
        if (((predmet == null || predmet.getId() == null) && (other.predmet != null && other.predmet.getId() != null)) || !predmet.getId().equals(other.predmet.getId()))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((student == null || student.getId() == null) ? 0 : student.getId().hashCode());
        result = prime * result + ((predmet == null || predmet.getId() == null) ? 0 : predmet.getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StudPred[" + "id=" + id + ", student=" + (student == null ? student : student.getId()) + ", predmet=" + (predmet == null ? predmet : predmet.getId()) + "]";
    }

}
