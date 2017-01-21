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

import org.springframework.format.annotation.DateTimeFormat;


@RestController
@RequestMapping("/api/")
public class FinansijeApi {

    private final Logger log = LoggerFactory.getLogger(FinansijeApi.class);

    @Inject
    private StanjeRepository stanjeRepository;

    @Inject
    private StudentRepository studentRepository;

    @RequestMapping(value = "/finansije/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<ReadFinansijeResponse> readFinansije(@PathVariable Long id) {
        log.debug("GET /finansije/{}", id);
        final Optional<Stanje> result = Optional.ofNullable(stanjeRepository.findOne(id));
        if (result.isPresent()) {
            return ResponseEntity.ok().body(convertToReadFinansijeResponse(result.get()));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/finansije", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<CreateFinansijeResponse> createFinansije(@Valid @RequestBody CreateFinansijeRequest request) throws URISyntaxException {
        log.debug("POST /finansije {}", request);
        final Stanje stanje = convertToStanje(request);
        final Stanje result = stanjeRepository.save(stanje);
        return ResponseEntity.created(new URI("/finansije/" + result.getId())).body(convertToCreateFinansijeResponse(result));
    }

    @RequestMapping(value = "/finansije/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<UpdateFinansijeResponse> updateFinansije(@PathVariable Long id, @Valid @RequestBody RestUpdateFinansijeRequest request) {
        log.debug("PUT /finansije/{} {}", id, request);
        final Stanje stanje = convertToStanje(id, request);
        final Stanje result = stanjeRepository.save(stanje);
        return ResponseEntity.ok().body(convertToUpdateFinansijeResponse(result));
    }

    @RequestMapping(value = "/finansije/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<Void> deleteFinansije(@PathVariable Long id) {
        log.debug("DELETE /finansije/{}", id);
        stanjeRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/finansije-studenta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<FinansijeStudentaResponse>> finansijeStudenta(@RequestParam("studentId") Long studentId) {
        log.debug("GET /finansije-studenta");
        final List<Stanje> result = stanjeRepository.findByStudent(studentId);
        return ResponseEntity.ok().body(result.stream().map(this::convertToFinansijeStudentaResponse).collect(Collectors.toList()));
    }

    private ReadFinansijeResponse convertToReadFinansijeResponse(Stanje model) {
        final ReadFinansijeResponse dto = new ReadFinansijeResponse();
        dto.setId(model.getId());
        dto.setStudentId(model.getStudent().getId());
        dto.setIznos(model.getIznos());
        dto.setPrethodnoStanje(model.getPrethodnoStanje());
        dto.setDatum(model.getDatum());
        return dto;
    }

    private Stanje convertToStanje(CreateFinansijeRequest dto) {
        final Stanje stanje = new Stanje();
        final Student student = studentRepository.findOne(dto.getStudentId());
        stanje.setStudent(student);
        stanje.setIznos(dto.getIznos());
        stanje.setPrethodnoStanje(dto.getPrethodnoStanje());
        stanje.setDatum(dto.getDatum());
        return stanje;
    }

    private CreateFinansijeResponse convertToCreateFinansijeResponse(Stanje model) {
        final CreateFinansijeResponse dto = new CreateFinansijeResponse();
        dto.setId(model.getId());
        dto.setStudentId(model.getStudent().getId());
        dto.setIznos(model.getIznos());
        dto.setPrethodnoStanje(model.getPrethodnoStanje());
        dto.setDatum(model.getDatum());
        return dto;
    }

    private Stanje convertToStanje(Long id, RestUpdateFinansijeRequest dto) {
        final Stanje stanje = new Stanje();
        stanje.setId(id);
        final Student student = studentRepository.findOne(dto.getStudentId());
        stanje.setStudent(student);
        stanje.setIznos(dto.getIznos());
        stanje.setPrethodnoStanje(dto.getPrethodnoStanje());
        stanje.setDatum(dto.getDatum());
        return stanje;
    }

    private UpdateFinansijeResponse convertToUpdateFinansijeResponse(Stanje model) {
        final UpdateFinansijeResponse dto = new UpdateFinansijeResponse();
        dto.setId(model.getId());
        dto.setStudentId(model.getStudent().getId());
        dto.setIznos(model.getIznos());
        dto.setPrethodnoStanje(model.getPrethodnoStanje());
        dto.setDatum(model.getDatum());
        return dto;
    }

    private FinansijeStudentaResponse convertToFinansijeStudentaResponse(Stanje model) {
        final FinansijeStudentaResponse dto = new FinansijeStudentaResponse();
        dto.setId(model.getId());
        dto.setStudentId(model.getStudent().getId());
        dto.setIznos(model.getIznos());
        dto.setPrethodnoStanje(model.getPrethodnoStanje());
        dto.setDatum(model.getDatum());
        return dto;
    }
}
