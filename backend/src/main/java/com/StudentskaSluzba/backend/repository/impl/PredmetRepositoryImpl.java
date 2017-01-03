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

import com.StudentskaSluzba.backend.repository.PredmetRepositoryCustom;

import com.querydsl.jpa.JPQLQueryFactory;


public class PredmetRepositoryImpl implements PredmetRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(PredmetRepositoryImpl.class);

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public List<Predmet> findByNaziv(String naziv) {
        log.trace(".findByNaziv(naziv: {})", naziv);
        final QPredmet predmet = QPredmet.predmet;
        return factory.select(predmet).from(predmet).where(predmet.naziv.eq(naziv)).fetch();
    }

    @Override
    public List<Predmet> findByEspb(Integer espb) {
        log.trace(".findByEspb(espb: {})", espb);
        final QPredmet predmet = QPredmet.predmet;
        return factory.select(predmet).from(predmet).where(predmet.espb.eq(espb)).fetch();
    }

    @Override
    public List<Predmet> findByObavezni(Boolean obavezni) {
        log.trace(".findByObavezni(obavezni: {})", obavezni);
        final QPredmet predmet = QPredmet.predmet;
        return factory.select(predmet).from(predmet).where(predmet.obavezni.eq(obavezni)).fetch();
    }

    @Override
    public List<Predmet> findByPredlozeniSemestar(Integer predlozeniSemestar) {
        log.trace(".findByPredlozeniSemestar(predlozeniSemestar: {})", predlozeniSemestar);
        final QPredmet predmet = QPredmet.predmet;
        return factory.select(predmet).from(predmet).where(predmet.predlozeniSemestar.eq(predlozeniSemestar)).fetch();
    }

    @Override
    public List<Predmet> findByImeProfesora(String imeProfesora) {
        log.trace(".findByImeProfesora(imeProfesora: {})", imeProfesora);
        final QPredmet predmet = QPredmet.predmet;
        return factory.select(predmet).from(predmet).where(predmet.imeProfesora.eq(imeProfesora)).fetch();
    }

}
