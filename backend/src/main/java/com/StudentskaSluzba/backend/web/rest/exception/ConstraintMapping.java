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
package com.StudentskaSluzba.backend.web.rest.exception;

import java.util.HashMap;
import java.util.Map;


public final class ConstraintMapping {

    private static final Map<String, String> mappings = new HashMap<>();

    static {
        mappings.put("UNQ_STU_I_76BEE7", "Student.index.unique");
    }

    private ConstraintMapping() {
    };

    public static String getErrorCodeForConstraint(String constraint) {
        return mappings.get(constraint);
    }

}
