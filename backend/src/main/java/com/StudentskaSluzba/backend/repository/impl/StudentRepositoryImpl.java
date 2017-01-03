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
package com.StudentskaSluzba.backend.repository.impl;

import java.math.BigDecimal;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.StudentskaSluzba.backend.model.*;
import com.StudentskaSluzba.backend.model.enumeration.*;
import com.StudentskaSluzba.backend.repository.StudentRepositoryCustom;

import com.querydsl.jpa.JPQLQueryFactory;


public class StudentRepositoryImpl implements StudentRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(StudentRepositoryImpl.class);

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public List<Student> findByIme(String ime) {
        log.trace(".findByIme(ime: {})", ime);
        final QStudent student = QStudent.student;
        return factory.select(student).from(student).where(student.ime.eq(ime)).fetch();
    }

    @Override
    public List<Student> findByPrezime(String prezime) {
        log.trace(".findByPrezime(prezime: {})", prezime);
        final QStudent student = QStudent.student;
        return factory.select(student).from(student).where(student.prezime.eq(prezime)).fetch();
    }

    @Override
    public Optional<Student> findByIndeks(String indeks) {
        log.trace(".findByIndeks(indeks: {})", indeks);
        final QStudent student = QStudent.student;
        return Optional.ofNullable(factory.select(student).from(student).where(student.indeks.eq(indeks)).fetchOne());
    }

    @Override
    public List<Student> findByTrenutnoStanjeRacuna(BigDecimal trenutnoStanjeRacuna) {
        log.trace(".findByTrenutnoStanjeRacuna(trenutnoStanjeRacuna: {})", trenutnoStanjeRacuna);
        final QStudent student = QStudent.student;
        return factory.select(student).from(student).where(student.trenutnoStanjeRacuna.eq(trenutnoStanjeRacuna)).fetch();
    }

    @Override
    public List<Student> findByBudzet(Boolean budzet) {
        log.trace(".findByBudzet(budzet: {})", budzet);
        final QStudent student = QStudent.student;
        return factory.select(student).from(student).where(student.budzet.eq(budzet)).fetch();
    }

    @Override
    public List<Student> findByTekuciSemestar(Integer tekuciSemestar) {
        log.trace(".findByTekuciSemestar(tekuciSemestar: {})", tekuciSemestar);
        final QStudent student = QStudent.student;
        return factory.select(student).from(student).where(student.tekuciSemestar.eq(tekuciSemestar)).fetch();
    }

    @Override
    public List<Student> findByOsvojeniBodovi(Integer osvojeniBodovi) {
        log.trace(".findByOsvojeniBodovi(osvojeniBodovi: {})", osvojeniBodovi);
        final QStudent student = QStudent.student;
        return factory.select(student).from(student).where(student.osvojeniBodovi.eq(osvojeniBodovi)).fetch();
    }

    @Override
    public List<Student> findByRole(UserRole role) {
        log.trace(".findByRole(role: {})", role);
        final QStudent student = QStudent.student;
        return factory.select(student).from(student).where(student.role.eq(role)).fetch();
    }

    @Override
    public Optional<Student> findByUsername(String username) {
        log.trace(".findByUsername(username: {})", username);
        final QStudent student = QStudent.student;
        return Optional.ofNullable(factory.select(student).from(student).where(student.username.eq(username)).fetchOne());
    }

    @Override
    public List<Student> findByPasswordHash(String passwordHash) {
        log.trace(".findByPasswordHash(passwordHash)");
        final QStudent student = QStudent.student;
        return factory.select(student).from(student).where(student.passwordHash.eq(passwordHash)).fetch();
    }

}
