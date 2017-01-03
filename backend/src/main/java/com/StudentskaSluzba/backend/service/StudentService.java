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
package com.StudentskaSluzba.backend.service;

import java.math.BigDecimal;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.StudentskaSluzba.backend.config.CustomProperties;
import com.StudentskaSluzba.backend.model.*;
import com.StudentskaSluzba.backend.model.enumeration.*;
import com.StudentskaSluzba.backend.repository.*;
import com.StudentskaSluzba.backend.web.rest.dto.*;
import com.StudentskaSluzba.backend.web.rest.exception.*;
import com.StudentskaSluzba.backend.security.JWTUtils;


@Service
public class StudentService {

    private final Logger log = LoggerFactory.getLogger(StudentService.class);

    @Inject
    private CustomProperties customProperties;

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private StudentRepository studentRepository;

    public Student signUp(String ime, String prezime, String index, BigDecimal trenutnoStanjeRacuna, Boolean budzet, Integer tekuciSemestar, Integer osvojeniBodovi, String username, String password) {
        log.debug("signUp(ime: {}, prezime: {}, index: {}, trenutnoStanjeRacuna: {}, budzet: {}, tekuciSemestar: {}, osvojeniBodovi: {}, username: {})", ime, prezime, index, trenutnoStanjeRacuna,
                budzet, tekuciSemestar, osvojeniBodovi, username);

        final Student student = new Student();
        student.setIme(ime);
        student.setPrezime(prezime);
        student.setIndex(index);
        student.setTrenutnoStanjeRacuna(trenutnoStanjeRacuna);
        student.setBudzet(budzet);
        student.setTekuciSemestar(tekuciSemestar);
        student.setOsvojeniBodovi(osvojeniBodovi);
        student.setUsername(username);
        student.setRole(UserRole.STUDENT);
        student.setPasswordHash(passwordEncoder.encode(password));
        studentRepository.save(student);
        return student;
    }

    public SignInResponse signIn(String username, String password) {

        log.debug("signIn(username: {})", username);

        final Student student = studentRepository.findByUsername(username).orElseThrow(() -> new AuthenticationError("credentials.invalid", "Credentials are invalid!"));
        if (!passwordEncoder.matches(password, student.getPasswordHash()))
            throw new AuthenticationError("credentials.invalid", "Credentials are invalid!");

        final SignInResponse response = new SignInResponse();
        final String accessToken = JWTUtils.createToken(student.getId(), student.getRole(), customProperties.getSecretKey());
        response.setAccessToken(accessToken);
        response.setId(student.getId());
        response.setIme(student.getIme());
        response.setPrezime(student.getPrezime());
        response.setIndex(student.getIndex());
        response.setTrenutnoStanjeRacuna(student.getTrenutnoStanjeRacuna());
        response.setBudzet(student.getBudzet());
        response.setTekuciSemestar(student.getTekuciSemestar());
        response.setOsvojeniBodovi(student.getOsvojeniBodovi());
        response.setRole(student.getRole());
        response.setUsername(student.getUsername());
        return response;
    }

    public Student changePassword(Long studentId, String oldPassword, String newPassword) {

        log.debug("changePassword(studentId: {})", studentId);

        final Student student = studentRepository.findOne(studentId);
        if (student == null) {
            throw new AuthenticationError("credentials.invalid", "Credentials are invalid!");
        }
        if (!passwordEncoder.matches(oldPassword, student.getPasswordHash())) {
            throw new AuthenticationError("credentials.invalid", "Credentials are invalid!");
        }
        student.setPasswordHash(passwordEncoder.encode(newPassword));
        studentRepository.save(student);
        return student;
    }

}
