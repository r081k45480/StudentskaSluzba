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
package com.StudentskaSluzba.backend.repository;

import java.time.*;
import java.util.List;
import java.util.Optional;

import com.StudentskaSluzba.backend.model.*;


public interface StudPredRepositoryCustom {

    List<StudPred> nepolozeniPredmeti();

    List<StudPred> findByStudent(Long studentId);

    List<StudPred> findByPredmet(Long predmetId);

    List<StudPred> findByOcena(Optional<Integer> ocena);

    List<StudPred> findByOcenaMandatory(Integer ocena);

    List<StudPred> findByDatumPolozeno(Optional<ZonedDateTime> datumPolozeno);

    List<StudPred> findByDatumPolozenoMandatory(ZonedDateTime datumPolozeno);

    List<StudPred> findBySemestarPrvogSlusanja(Integer semestarPrvogSlusanja);

    List<StudPred> findBySemestarPoslednjeSlusanja(Integer semestarPoslednjeSlusanja);

    List<StudPred> studPreds();

}
