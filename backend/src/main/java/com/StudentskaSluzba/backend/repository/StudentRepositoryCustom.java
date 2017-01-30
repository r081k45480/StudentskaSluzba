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

import java.math.BigDecimal;

import java.util.List;
import java.util.Optional;

import com.StudentskaSluzba.backend.model.*;
import com.StudentskaSluzba.backend.model.enumeration.*;
import com.StudentskaSluzba.backend.repository.tuple.*;


public interface StudentRepositoryCustom {

    Double prosecnaOcena(Integer userId);

    List<Student> findByIme(String ime);

    List<Student> findByPrezime(String prezime);

    Optional<Student> findByIndeks(String indeks);

    List<Student> findByTrenutnoStanjeRacuna(BigDecimal trenutnoStanjeRacuna);

    List<Student> findByBudzet(Boolean budzet);

    List<Student> findByTekuciSemestar(Integer tekuciSemestar);

    List<Student> findByOsvojeniBodovi(Integer osvojeniBodovi);

    List<Student> findByRole(UserRole role);

    Optional<Student> findByUsername(String username);

    List<Student> findByPasswordHash(String passwordHash);

}
