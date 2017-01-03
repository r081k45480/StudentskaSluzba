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
import java.util.List;
import java.util.stream.Collectors;

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
public class StudPredApi {

    private final Logger log = LoggerFactory.getLogger(StudPredApi.class);

    @Inject
    private PredmetRepository predmetRepository;

    @Inject
    private StudPredRepository studPredRepository;

    @Inject
    private StudentRepository studentRepository;

    @RequestMapping(value = "/stud-pred/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<ReadStudPredResponse> readStudPred(@PathVariable Long id) {
        log.debug("GET /stud-pred/{}", id);
        final Optional<StudPred> result = Optional.ofNullable(studPredRepository.findOne(id));
        if (result.isPresent()) {
            return ResponseEntity.ok().body(convertToReadStudPredResponse(result.get()));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/stud-pred", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<CreateStudPredResponse> createStudPred(@Valid @RequestBody CreateStudPredRequest request) throws URISyntaxException {
        log.debug("POST /stud-pred {}", request);
        final StudPred studPred = convertToStudPred(request);
        final StudPred result = studPredRepository.save(studPred);
        return ResponseEntity.created(new URI("/stud-pred/" + result.getId())).body(convertToCreateStudPredResponse(result));
    }

    @RequestMapping(value = "/stud-pred/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<UpdateStudPredResponse> updateStudPred(@PathVariable Long id, @Valid @RequestBody RestUpdateStudPredRequest request) {
        log.debug("PUT /stud-pred/{} {}", id, request);
        final StudPred studPred = convertToStudPred(id, request);
        final StudPred result = studPredRepository.save(studPred);
        return ResponseEntity.ok().body(convertToUpdateStudPredResponse(result));
    }

    @RequestMapping(value = "/stud-pred/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<Void> deleteStudPred(@PathVariable Long id) {
        log.debug("DELETE /stud-pred/{}", id);
        studPredRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/stud-preds", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<StudPredsResponse>> studPreds() {
        log.debug("GET /stud-preds");
        final List<StudPred> result = studPredRepository.studPreds();
        return ResponseEntity.ok().body(result.stream().map(this::convertToStudPredsResponse).collect(Collectors.toList()));
    }

    private ReadStudPredResponse convertToReadStudPredResponse(StudPred studPred) {
        final ReadStudPredResponse readStudPredResponse = new ReadStudPredResponse();
        readStudPredResponse.setId(studPred.getId());
        readStudPredResponse.setStudentId(studPred.getStudent().getId());
        readStudPredResponse.setPredmetId(studPred.getPredmet().getId());
        return readStudPredResponse;
    }

    private StudPred convertToStudPred(CreateStudPredRequest createStudPredRequest) {
        final StudPred studPred = new StudPred();
        studPred.setStudent(studentRepository.findOne(createStudPredRequest.getStudentId()));
        studPred.setPredmet(predmetRepository.findOne(createStudPredRequest.getPredmetId()));
        return studPred;
    }

    private CreateStudPredResponse convertToCreateStudPredResponse(StudPred studPred) {
        final CreateStudPredResponse createStudPredResponse = new CreateStudPredResponse();
        createStudPredResponse.setId(studPred.getId());
        createStudPredResponse.setStudentId(studPred.getStudent().getId());
        createStudPredResponse.setPredmetId(studPred.getPredmet().getId());
        return createStudPredResponse;
    }

    private StudPred convertToStudPred(Long id, RestUpdateStudPredRequest restUpdateStudPredRequest) {
        final StudPred studPred = new StudPred();
        studPred.setId(id);
        studPred.setStudent(studentRepository.findOne(restUpdateStudPredRequest.getStudentId()));
        studPred.setPredmet(predmetRepository.findOne(restUpdateStudPredRequest.getPredmetId()));
        return studPred;
    }

    private UpdateStudPredResponse convertToUpdateStudPredResponse(StudPred studPred) {
        final UpdateStudPredResponse updateStudPredResponse = new UpdateStudPredResponse();
        updateStudPredResponse.setId(studPred.getId());
        updateStudPredResponse.setStudentId(studPred.getStudent().getId());
        updateStudPredResponse.setPredmetId(studPred.getPredmet().getId());
        return updateStudPredResponse;
    }

    private StudPredsResponse convertToStudPredsResponse(StudPred model) {
        final StudPredsResponse dto = new StudPredsResponse();
        dto.setId(model.getId());
        dto.setStudentId(model.getStudent().getId());
        dto.setPredmetId(model.getPredmet().getId());
        return dto;
    }
}
