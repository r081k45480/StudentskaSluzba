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
package com.StudentskaSluzba.backend.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.codahale.metrics.annotation.Timed;
import javax.validation.Valid;
import com.StudentskaSluzba.backend.model.*;
import com.StudentskaSluzba.backend.web.rest.dto.*;

import com.StudentskaSluzba.backend.repository.*;


@RestController
@RequestMapping("/api/")
public class StudentApi {

    private final Logger log = LoggerFactory.getLogger(StudentApi.class);

    @Inject
    private StudentRepository studentRepository;

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<ReadStudentResponse> readStudent(@PathVariable Long id) {
        log.debug("GET /student/{}", id);
        final Optional<Student> result = Optional.ofNullable(studentRepository.findOne(id));
        if (result.isPresent()) {
            return ResponseEntity.ok().body(convertToReadStudentResponse(result.get()));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<CreateStudentResponse> createStudent(@Valid @RequestBody CreateStudentRequest request) throws URISyntaxException {
        log.debug("POST /student {}", request);
        final Student student = convertToStudent(request);
        final Student result = studentRepository.save(student);
        return ResponseEntity.created(new URI("/student/" + result.getId())).body(convertToCreateStudentResponse(result));
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<UpdateStudentResponse> updateStudent(@PathVariable Long id, @Valid @RequestBody RestUpdateStudentRequest request) {
        log.debug("PUT /student/{} {}", id, request);
        final Student student = convertToStudent(id, request);
        final Student result = studentRepository.save(student);
        return ResponseEntity.ok().body(convertToUpdateStudentResponse(result));
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        log.debug("DELETE /student/{}", id);
        studentRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    private ReadStudentResponse convertToReadStudentResponse(Student student) {
        final ReadStudentResponse readStudentResponse = new ReadStudentResponse();
        readStudentResponse.setId(student.getId());
        readStudentResponse.setIme(student.getIme());
        readStudentResponse.setPrezime(student.getPrezime());
        readStudentResponse.setIndex(student.getIndex());
        readStudentResponse.setTrenutnoStanjeRacuna(student.getTrenutnoStanjeRacuna());
        readStudentResponse.setBudzet(student.getBudzet());
        readStudentResponse.setTekuciSemestar(student.getTekuciSemestar());
        readStudentResponse.setOsvojeniBodovi(student.getOsvojeniBodovi());
        return readStudentResponse;
    }

    private Student convertToStudent(CreateStudentRequest createStudentRequest) {
        final Student student = new Student();
        student.setIme(createStudentRequest.getIme());
        student.setPrezime(createStudentRequest.getPrezime());
        student.setIndex(createStudentRequest.getIndex());
        student.setTrenutnoStanjeRacuna(createStudentRequest.getTrenutnoStanjeRacuna());
        student.setBudzet(createStudentRequest.getBudzet());
        student.setTekuciSemestar(createStudentRequest.getTekuciSemestar());
        student.setOsvojeniBodovi(createStudentRequest.getOsvojeniBodovi());
        return student;
    }

    private CreateStudentResponse convertToCreateStudentResponse(Student student) {
        final CreateStudentResponse createStudentResponse = new CreateStudentResponse();
        createStudentResponse.setId(student.getId());
        createStudentResponse.setIme(student.getIme());
        createStudentResponse.setPrezime(student.getPrezime());
        createStudentResponse.setIndex(student.getIndex());
        createStudentResponse.setTrenutnoStanjeRacuna(student.getTrenutnoStanjeRacuna());
        createStudentResponse.setBudzet(student.getBudzet());
        createStudentResponse.setTekuciSemestar(student.getTekuciSemestar());
        createStudentResponse.setOsvojeniBodovi(student.getOsvojeniBodovi());
        return createStudentResponse;
    }

    private Student convertToStudent(Long id, RestUpdateStudentRequest restUpdateStudentRequest) {
        final Student student = new Student();
        student.setId(id);
        student.setIme(restUpdateStudentRequest.getIme());
        student.setPrezime(restUpdateStudentRequest.getPrezime());
        student.setIndex(restUpdateStudentRequest.getIndex());
        student.setTrenutnoStanjeRacuna(restUpdateStudentRequest.getTrenutnoStanjeRacuna());
        student.setBudzet(restUpdateStudentRequest.getBudzet());
        student.setTekuciSemestar(restUpdateStudentRequest.getTekuciSemestar());
        student.setOsvojeniBodovi(restUpdateStudentRequest.getOsvojeniBodovi());
        return student;
    }

    private UpdateStudentResponse convertToUpdateStudentResponse(Student student) {
        final UpdateStudentResponse updateStudentResponse = new UpdateStudentResponse();
        updateStudentResponse.setId(student.getId());
        updateStudentResponse.setIme(student.getIme());
        updateStudentResponse.setPrezime(student.getPrezime());
        updateStudentResponse.setIndex(student.getIndex());
        updateStudentResponse.setTrenutnoStanjeRacuna(student.getTrenutnoStanjeRacuna());
        updateStudentResponse.setBudzet(student.getBudzet());
        updateStudentResponse.setTekuciSemestar(student.getTekuciSemestar());
        updateStudentResponse.setOsvojeniBodovi(student.getOsvojeniBodovi());
        return updateStudentResponse;
    }
}
