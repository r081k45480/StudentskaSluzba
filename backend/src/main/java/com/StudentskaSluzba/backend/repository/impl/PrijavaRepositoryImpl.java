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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.StudentskaSluzba.backend.model.*;

import com.StudentskaSluzba.backend.repository.PrijavaRepositoryCustom;

import com.querydsl.jpa.JPQLQueryFactory;


public class PrijavaRepositoryImpl implements PrijavaRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(PrijavaRepositoryImpl.class);

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public List<Prijava> findByRok(Long rokId) {
        log.trace(".findByRok(rokId: {})", rokId);
        final QPrijava prijava = QPrijava.prijava;
        return factory.select(prijava).from(prijava).where(prijava.rok.id.eq(rokId)).fetch();
    }

    @Override
    public List<Prijava> findByStudPred(Long studPredId) {
        log.trace(".findByStudPred(studPredId: {})", studPredId);
        final QPrijava prijava = QPrijava.prijava;
        return factory.select(prijava).from(prijava).where(prijava.studPred.id.eq(studPredId)).fetch();
    }

}
