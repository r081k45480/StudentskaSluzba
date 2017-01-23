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
import com.StudentskaSluzba.backend.repository.tuple.*;

import org.springframework.format.annotation.DateTimeFormat;


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

    @RequestMapping(value = "/studPred/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<ReadStudPredResponse> readStudPred(@PathVariable Long id) {
        log.debug("GET /studPred/{}", id);
        final Optional<StudPred> result = Optional.ofNullable(studPredRepository.findOne(id));
        if (result.isPresent()) {
            return ResponseEntity.ok().body(convertToReadStudPredResponse(result.get()));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/studPred", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<CreateStudPredResponse> createStudPred(@Valid @RequestBody CreateStudPredRequest request) throws URISyntaxException {
        log.debug("POST /studPred {}", request);
        final StudPred studPred = convertToStudPred(request);
        final StudPred result = studPredRepository.save(studPred);
        return ResponseEntity.created(new URI("/studPred/" + result.getId())).body(convertToCreateStudPredResponse(result));
    }

    @RequestMapping(value = "/studPred/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<UpdateStudPredResponse> updateStudPred(@PathVariable Long id, @Valid @RequestBody RestUpdateStudPredRequest request) {
        log.debug("PUT /studPred/{} {}", id, request);
        final StudPred studPred = convertToStudPred(id, request);
        final StudPred result = studPredRepository.save(studPred);
        return ResponseEntity.ok().body(convertToUpdateStudPredResponse(result));
    }

    @RequestMapping(value = "/studPred/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<Void> deleteStudPred(@PathVariable Long id) {
        log.debug("DELETE /studPred/{}", id);
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

    @RequestMapping(value = "/nepolozeni-predmeti", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<NepolozeniPredmetiResponse>> nepolozeniPredmeti(@RequestParam("userId") Long userId) {
        log.debug("GET /nepolozeni-predmeti");
        final List<StudPredPredmetTuple> result = studPredRepository.nepolozeniPredmeti(userId);
        return ResponseEntity.ok().body(result.stream().map(this::convertToNepolozeniPredmetiResponse).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/prijavljeni-predmeti", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<PrijavljeniPredmetiResponse>> prijavljeniPredmeti(@RequestParam("userId") Long userId) {
        log.debug("GET /prijavljeni-predmeti");
        final List<StudPredPredmetTuple> result = studPredRepository.prijavljeniPredmeti(userId);
        return ResponseEntity.ok().body(result.stream().map(this::convertToPrijavljeniPredmetiResponse).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/polozeni-predmeti", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<PolozeniPredmetiResponse>> polozeniPredmeti(@RequestParam("userId") Long userId) {
        log.debug("GET /polozeni-predmeti");
        final List<StudPredPredmetTuple> result = studPredRepository.polozeniPredmeti(userId);
        return ResponseEntity.ok().body(result.stream().map(this::convertToPolozeniPredmetiResponse).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/neslusani-predmeti", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<NeslusaniPredmetiResponse>> neslusaniPredmeti(@RequestParam("userId") Long userId) {
        log.debug("GET /neslusani-predmeti");
        final List<StudPredPredmetTuple> result = studPredRepository.neslusaniPredmeti(userId);
        return ResponseEntity.ok().body(result.stream().map(this::convertToNeslusaniPredmetiResponse).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/prijavi", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<Void> prijaviPredmet(@Valid @RequestBody PrijaviPredmetRequest request) {
        log.debug("POST /prijavi {}", request);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/slusaj", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<Void> slusajPredmet(@Valid @RequestBody SlusajPredmetRequest request) {
        log.debug("POST /slusaj {}", request);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    private ReadStudPredResponse convertToReadStudPredResponse(StudPred model) {
        final ReadStudPredResponse dto = new ReadStudPredResponse();
        dto.setId(model.getId());
        dto.setStudentId(model.getStudent().getId());
        dto.setPredmetId(model.getPredmet().getId());
        dto.setOcena(model.getOcena().orElse(null));
        dto.setDatumPolozeno(model.getDatumPolozeno().orElse(null));
        dto.setSemestarPrvogSlusanja(model.getSemestarPrvogSlusanja());
        dto.setSemestarPoslednjeSlusanja(model.getSemestarPoslednjeSlusanja());
        return dto;
    }

    private StudPred convertToStudPred(CreateStudPredRequest dto) {
        final StudPred studPred = new StudPred();
        final Student student = studentRepository.findOne(dto.getStudentId());
        studPred.setStudent(student);
        final Predmet predmet = predmetRepository.findOne(dto.getPredmetId());
        studPred.setPredmet(predmet);
        studPred.setOcena(Optional.ofNullable(dto.getOcena()));
        studPred.setDatumPolozeno(Optional.ofNullable(dto.getDatumPolozeno()));
        studPred.setSemestarPrvogSlusanja(dto.getSemestarPrvogSlusanja());
        studPred.setSemestarPoslednjeSlusanja(dto.getSemestarPoslednjeSlusanja());
        return studPred;
    }

    private CreateStudPredResponse convertToCreateStudPredResponse(StudPred model) {
        final CreateStudPredResponse dto = new CreateStudPredResponse();
        dto.setId(model.getId());
        dto.setStudentId(model.getStudent().getId());
        dto.setPredmetId(model.getPredmet().getId());
        dto.setOcena(model.getOcena().orElse(null));
        dto.setDatumPolozeno(model.getDatumPolozeno().orElse(null));
        dto.setSemestarPrvogSlusanja(model.getSemestarPrvogSlusanja());
        dto.setSemestarPoslednjeSlusanja(model.getSemestarPoslednjeSlusanja());
        return dto;
    }

    private StudPred convertToStudPred(Long id, RestUpdateStudPredRequest dto) {
        final StudPred studPred = new StudPred();
        studPred.setId(id);
        final Student student = studentRepository.findOne(dto.getStudentId());
        studPred.setStudent(student);
        final Predmet predmet = predmetRepository.findOne(dto.getPredmetId());
        studPred.setPredmet(predmet);
        studPred.setOcena(Optional.ofNullable(dto.getOcena()));
        studPred.setDatumPolozeno(Optional.ofNullable(dto.getDatumPolozeno()));
        studPred.setSemestarPrvogSlusanja(dto.getSemestarPrvogSlusanja());
        studPred.setSemestarPoslednjeSlusanja(dto.getSemestarPoslednjeSlusanja());
        return studPred;
    }

    private UpdateStudPredResponse convertToUpdateStudPredResponse(StudPred model) {
        final UpdateStudPredResponse dto = new UpdateStudPredResponse();
        dto.setId(model.getId());
        dto.setStudentId(model.getStudent().getId());
        dto.setPredmetId(model.getPredmet().getId());
        dto.setOcena(model.getOcena().orElse(null));
        dto.setDatumPolozeno(model.getDatumPolozeno().orElse(null));
        dto.setSemestarPrvogSlusanja(model.getSemestarPrvogSlusanja());
        dto.setSemestarPoslednjeSlusanja(model.getSemestarPoslednjeSlusanja());
        return dto;
    }

    private StudPredsResponse convertToStudPredsResponse(StudPred model) {
        final StudPredsResponse dto = new StudPredsResponse();
        dto.setId(model.getId());
        dto.setStudentId(model.getStudent().getId());
        dto.setPredmetId(model.getPredmet().getId());
        dto.setOcena(model.getOcena().orElse(null));
        dto.setDatumPolozeno(model.getDatumPolozeno().orElse(null));
        dto.setSemestarPrvogSlusanja(model.getSemestarPrvogSlusanja());
        dto.setSemestarPoslednjeSlusanja(model.getSemestarPoslednjeSlusanja());
        return dto;
    }

    private NepolozeniPredmetiResponse convertToNepolozeniPredmetiResponse(StudPredPredmetTuple model) {
        final NepolozeniPredmetiResponse dto = new NepolozeniPredmetiResponse();
        dto.setPredmetId(model.getPredmet().getId());
        dto.setPredmetNaziv(model.getPredmet().getNaziv());
        dto.setPredmetEspb(model.getPredmet().getEspb());
        dto.setPredmetObavezni(model.getPredmet().getObavezni());
        dto.setPredmetPredlozeniSemestar(model.getPredmet().getPredlozeniSemestar());
        dto.setPredmetImeProfesora(model.getPredmet().getImeProfesora());
        dto.setSemestarPrvogSlusanja(model.getStudPred().getSemestarPrvogSlusanja());
        return dto;
    }

    private PrijavljeniPredmetiResponse convertToPrijavljeniPredmetiResponse(StudPredPredmetTuple model) {
        final PrijavljeniPredmetiResponse dto = new PrijavljeniPredmetiResponse();
        dto.setPredmetNaziv(model.getPredmet().getNaziv());
        dto.setPredmetEspb(model.getPredmet().getEspb());
        dto.setPredmetObavezni(model.getPredmet().getObavezni());
        dto.setPredmetPredlozeniSemestar(model.getPredmet().getPredlozeniSemestar());
        dto.setPredmetImeProfesora(model.getPredmet().getImeProfesora());
        dto.setSemestarPrvogSlusanja(model.getStudPred().getSemestarPrvogSlusanja());
        return dto;
    }

    private PolozeniPredmetiResponse convertToPolozeniPredmetiResponse(StudPredPredmetTuple model) {
        final PolozeniPredmetiResponse dto = new PolozeniPredmetiResponse();
        dto.setPredmetId(model.getPredmet().getId());
        dto.setPredmetNaziv(model.getPredmet().getNaziv());
        dto.setPredmetEspb(model.getPredmet().getEspb());
        dto.setPredmetObavezni(model.getPredmet().getObavezni());
        dto.setPredmetImeProfesora(model.getPredmet().getImeProfesora());
        dto.setSemestarPrvogSlusanja(model.getStudPred().getSemestarPrvogSlusanja());
        dto.setOcena(model.getStudPred().getOcena().orElse(null));
        dto.setDatumPolozeno(model.getStudPred().getDatumPolozeno().orElse(null));
        return dto;
    }

    private NeslusaniPredmetiResponse convertToNeslusaniPredmetiResponse(StudPredPredmetTuple model) {
        final NeslusaniPredmetiResponse dto = new NeslusaniPredmetiResponse();
        dto.setPredmetId(model.getPredmet().getId());
        dto.setPredmetNaziv(model.getPredmet().getNaziv());
        dto.setPredmetEspb(model.getPredmet().getEspb());
        dto.setPredmetObavezni(model.getPredmet().getObavezni());
        dto.setPredmetPredlozeniSemestar(model.getPredmet().getPredlozeniSemestar());
        dto.setPredmetImeProfesora(model.getPredmet().getImeProfesora());
        dto.setSemestarPrvogSlusanja(model.getStudPred().getSemestarPrvogSlusanja());
        return dto;
    }
}
