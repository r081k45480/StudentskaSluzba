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

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import springfox.documentation.annotations.ApiIgnore;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.codahale.metrics.annotation.Timed;
import javax.validation.Valid;
import com.StudentskaSluzba.backend.model.*;
import com.StudentskaSluzba.backend.web.rest.dto.*;

import com.StudentskaSluzba.backend.repository.*;
import java.math.BigDecimal;
import com.StudentskaSluzba.backend.service.*;


@RestController
@RequestMapping("/api/")
public class AuthenticationApi {

    private final Logger log = LoggerFactory.getLogger(AuthenticationApi.class);

    @Inject
    private StanjeRepository stanjeRepository;
    @Inject
    private StudentService studentService;

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<SignUpResponse> signUp(@Valid @RequestBody SignUpRequest request) {
        log.debug("POST /sign-up {}", request);
        final Student student = studentService.signUp(request.getStanjaIds(), request.getIme(), request.getPrezime(), request.getIndex(), request.getTrenutnoStanjeRacuna(), request.getBudzet(),
                request.getTekuciSemestar(), request.getOsvojeniBodovi(), request.getUsername(), request.getPassword());
        return ResponseEntity.ok().body(convertToSignUpResponse(student));
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<SignInResponse> signIn(@Valid @RequestBody SignInRequest request) {
        log.debug("POST /sign-in {}", request);
        final SignInResponse response = studentService.signIn(request.getUsername(), request.getPassword());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ChangePasswordResponse> changePassword(@Valid @RequestBody ChangePasswordRequest request, @ApiIgnore @AuthenticationPrincipal Long principalId) {
        log.debug("POST /change-password {}", request);
        final Student student = studentService.changePassword(principalId, request.getOldPassword(), request.getNewPassword());
        return ResponseEntity.ok().body(convertToChangePasswordResponse(student));
    }

    private SignUpResponse convertToSignUpResponse(Student model) {
        final SignUpResponse dto = new SignUpResponse();
        dto.setId(model.getId());
        dto.setStanjaId(model.getStanja().getId());
        dto.setIme(model.getIme());
        dto.setPrezime(model.getPrezime());
        dto.setIndex(model.getIndex());
        dto.setTrenutnoStanjeRacuna(model.getTrenutnoStanjeRacuna());
        dto.setBudzet(model.getBudzet());
        dto.setTekuciSemestar(model.getTekuciSemestar());
        dto.setOsvojeniBodovi(model.getOsvojeniBodovi());
        dto.setRole(model.getRole());
        dto.setUsername(model.getUsername());
        return dto;
    }

    private ChangePasswordResponse convertToChangePasswordResponse(Student model) {
        final ChangePasswordResponse dto = new ChangePasswordResponse();
        dto.setId(model.getId());
        dto.setStanjaId(model.getStanja().getId());
        dto.setIme(model.getIme());
        dto.setPrezime(model.getPrezime());
        dto.setIndex(model.getIndex());
        dto.setTrenutnoStanjeRacuna(model.getTrenutnoStanjeRacuna());
        dto.setBudzet(model.getBudzet());
        dto.setTekuciSemestar(model.getTekuciSemestar());
        dto.setOsvojeniBodovi(model.getOsvojeniBodovi());
        dto.setRole(model.getRole());
        dto.setUsername(model.getUsername());
        return dto;
    }
}
