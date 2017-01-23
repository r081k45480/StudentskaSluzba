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

import java.time.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.StudentskaSluzba.backend.model.*;

import com.StudentskaSluzba.backend.repository.StudPredRepositoryCustom;
import com.StudentskaSluzba.backend.repository.tuple.*;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQueryFactory;


public class StudPredRepositoryImpl implements StudPredRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(StudPredRepositoryImpl.class);

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public List<StudPredPredmetTuple> nepolozeniPredmeti(Long userId) {
        log.trace(".nepolozeniPredmeti(userId: {})", userId);
        final QStudPred studPred = QStudPred.studPred;
        final QPredmet predmet = QPredmet.predmet;
        return factory.select(studPred, predmet).from(studPred).innerJoin(studPred.predmet, predmet).where(new BooleanBuilder().and(studPred.ocena.isNull()).and(studPred.student.id.eq(userId)))
                .fetch().stream().map(t -> new StudPredPredmetTuple(t.get(studPred), t.get(predmet))).collect(Collectors.toList());
    }

    @Override
    public List<StudPredPredmetTuple> prijavljeniPredmeti(Long userId) {
        log.trace(".prijavljeniPredmeti(userId: {})", userId);
        final QStudPred studPred = QStudPred.studPred;
        final QPredmet predmet = QPredmet.predmet;
        return factory.select(studPred, predmet).from(studPred).innerJoin(studPred.predmet, predmet).where(studPred.student.id.eq(userId)).fetch().stream()
                .map(t -> new StudPredPredmetTuple(t.get(studPred), t.get(predmet))).collect(Collectors.toList());
    }

    @Override
    public List<StudPredPredmetTuple> polozeniPredmeti(Long userId) {
        log.trace(".polozeniPredmeti(userId: {})", userId);
        final QStudPred studPred = QStudPred.studPred;
        final QPredmet predmet = QPredmet.predmet;
        return factory.select(studPred, predmet).from(studPred).innerJoin(studPred.predmet, predmet).where(studPred.student.id.eq(userId)).fetch().stream()
                .map(t -> new StudPredPredmetTuple(t.get(studPred), t.get(predmet))).collect(Collectors.toList());
    }

    @Override
    public List<StudPredPredmetTuple> neslusaniPredmeti(Long userId) {
        log.trace(".neslusaniPredmeti(userId: {})", userId);
        final QStudPred studPred = QStudPred.studPred;
        final QPredmet predmet = QPredmet.predmet;
        return factory.select(studPred, predmet).from(studPred).innerJoin(studPred.predmet, predmet).where(studPred.student.id.eq(userId)).fetch().stream()
                .map(t -> new StudPredPredmetTuple(t.get(studPred), t.get(predmet))).collect(Collectors.toList());
    }

    @Override
    public List<StudPred> findByStudent(Long studentId) {
        log.trace(".findByStudent(studentId: {})", studentId);
        final QStudPred studPred = QStudPred.studPred;
        return factory.select(studPred).from(studPred).where(studPred.student.id.eq(studentId)).fetch();
    }

    @Override
    public List<StudPred> findByPredmet(Long predmetId) {
        log.trace(".findByPredmet(predmetId: {})", predmetId);
        final QStudPred studPred = QStudPred.studPred;
        return factory.select(studPred).from(studPred).where(studPred.predmet.id.eq(predmetId)).fetch();
    }

    @Override
    public List<StudPred> findByOcena(Optional<Integer> ocena) {
        log.trace(".findByOcena(ocena: {})", ocena);
        final QStudPred studPred = QStudPred.studPred;
        return factory.select(studPred).from(studPred).where(ocena.isPresent() ? studPred.ocena.eq(ocena.get()) : null).fetch();
    }

    @Override
    public List<StudPred> findByOcenaMandatory(Integer ocena) {
        log.trace(".findByOcenaMandatory(ocena: {})", ocena);
        final QStudPred studPred = QStudPred.studPred;
        return factory.select(studPred).from(studPred).where(studPred.ocena.eq(ocena)).fetch();
    }

    @Override
    public List<StudPred> findByDatumPolozeno(Optional<ZonedDateTime> datumPolozeno) {
        log.trace(".findByDatumPolozeno(datumPolozeno: {})", datumPolozeno);
        final QStudPred studPred = QStudPred.studPred;
        return factory.select(studPred).from(studPred).where(datumPolozeno.isPresent() ? studPred.datumPolozeno.eq(datumPolozeno.get()) : null).fetch();
    }

    @Override
    public List<StudPred> findByDatumPolozenoMandatory(ZonedDateTime datumPolozeno) {
        log.trace(".findByDatumPolozenoMandatory(datumPolozeno: {})", datumPolozeno);
        final QStudPred studPred = QStudPred.studPred;
        return factory.select(studPred).from(studPred).where(studPred.datumPolozeno.eq(datumPolozeno)).fetch();
    }

    @Override
    public List<StudPred> findBySemestarPrvogSlusanja(Integer semestarPrvogSlusanja) {
        log.trace(".findBySemestarPrvogSlusanja(semestarPrvogSlusanja: {})", semestarPrvogSlusanja);
        final QStudPred studPred = QStudPred.studPred;
        return factory.select(studPred).from(studPred).where(studPred.semestarPrvogSlusanja.eq(semestarPrvogSlusanja)).fetch();
    }

    @Override
    public List<StudPred> findBySemestarPoslednjeSlusanja(Integer semestarPoslednjeSlusanja) {
        log.trace(".findBySemestarPoslednjeSlusanja(semestarPoslednjeSlusanja: {})", semestarPoslednjeSlusanja);
        final QStudPred studPred = QStudPred.studPred;
        return factory.select(studPred).from(studPred).where(studPred.semestarPoslednjeSlusanja.eq(semestarPoslednjeSlusanja)).fetch();
    }

    @Override
    public List<StudPred> studPreds() {
        log.trace(".studPreds()");
        final QStudPred studPred = QStudPred.studPred;
        return factory.select(studPred).from(studPred).fetch();
    }

}
