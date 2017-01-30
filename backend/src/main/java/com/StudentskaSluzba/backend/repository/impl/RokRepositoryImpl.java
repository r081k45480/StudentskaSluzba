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

import java.time.ZonedDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.StudentskaSluzba.backend.model.*;

import com.StudentskaSluzba.backend.repository.RokRepositoryCustom;

import com.querydsl.jpa.JPQLQueryFactory;


public class RokRepositoryImpl implements RokRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(RokRepositoryImpl.class);

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public List<Rok> findByGodina(Integer godina) {
        log.trace(".findByGodina(godina: {})", godina);
        final QRok rok = QRok.rok;
        return factory.select(rok).from(rok).where(rok.godina.eq(godina)).fetch();
    }

    @Override
    public List<Rok> findByNaziv(String naziv) {
        log.trace(".findByNaziv(naziv: {})", naziv);
        final QRok rok = QRok.rok;
        return factory.select(rok).from(rok).where(rok.naziv.eq(naziv)).fetch();
    }

	@Override
	public Rok getTrenutniRok() {
		log.trace(".getTrenutniRok()");
        final QRok rok = QRok.rok;
        return factory.select(rok).from(rok).orderBy(rok.id.desc()).fetchFirst();
	}

}
