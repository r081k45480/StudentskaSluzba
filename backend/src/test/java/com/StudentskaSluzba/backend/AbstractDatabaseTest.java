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
package com.StudentskaSluzba.backend;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.StudentskaSluzba.backend.config.CustomProperties;
import com.StudentskaSluzba.backend.repository.StudentRepository;
import com.StudentskaSluzba.backend.repository.PredmetRepository;
import com.StudentskaSluzba.backend.repository.StanjeRepository;
import com.StudentskaSluzba.backend.repository.RokRepository;
import com.StudentskaSluzba.backend.repository.StudPredRepository;
import com.StudentskaSluzba.backend.repository.PrijavaRepository;


@ActiveProfiles(resolver = TestProfileResolver.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = BackendApplication.class)
@Transactional
public abstract class AbstractDatabaseTest {

    @Inject
    public ObjectMapper objectMapper;

    @Inject
    private CustomProperties customProperties;

    @Inject
    protected StudentRepository studentRepository;

    @Inject
    protected PredmetRepository predmetRepository;

    @Inject
    protected StanjeRepository stanjeRepository;

    @Inject
    protected RokRepository rokRepository;

    @Inject
    protected StudPredRepository studPredRepository;

    @Inject
    protected PrijavaRepository prijavaRepository;

    protected byte[] convertObjectToJsonBytes(Object object) throws IOException {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsBytes(object);
    }

}
