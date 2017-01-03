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
import java.time.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.StudentskaSluzba.backend.model.*;

import com.StudentskaSluzba.backend.repository.StanjeRepositoryCustom;

import com.querydsl.jpa.JPQLQueryFactory;


public class StanjeRepositoryImpl implements StanjeRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(StanjeRepositoryImpl.class);

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public List<Stanje> findByIznos(BigDecimal iznos) {
        log.trace(".findByIznos(iznos: {})", iznos);
        final QStanje stanje = QStanje.stanje;
        return factory.select(stanje).from(stanje).where(stanje.iznos.eq(iznos)).fetch();
    }

    @Override
    public List<Stanje> findByDatum(ZonedDateTime datum) {
        log.trace(".findByDatum(datum: {})", datum);
        final QStanje stanje = QStanje.stanje;
        return factory.select(stanje).from(stanje).where(stanje.datum.eq(datum)).fetch();
    }

    @Override
    public List<Stanje> findByStudent(Long studentId) {
        log.trace(".findByStudent(studentId: {})", studentId);
        final QStanje stanje = QStanje.stanje;
        return factory.select(stanje).from(stanje).where(stanje.student.id.eq(studentId)).fetch();
    }

}
