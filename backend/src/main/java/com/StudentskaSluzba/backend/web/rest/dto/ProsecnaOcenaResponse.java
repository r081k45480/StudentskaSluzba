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
package com.StudentskaSluzba.backend.web.rest.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.*;


public class ProsecnaOcenaResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private BigDecimal prosek;

    public BigDecimal getProsek() {
        return prosek;
    }

    public void setProsek(BigDecimal prosek) {
        this.prosek = prosek;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ProsecnaOcenaResponse other = (ProsecnaOcenaResponse) obj;
        if ((prosek == null && other.prosek != null) || !prosek.equals(other.prosek))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prosek == null) ? 0 : prosek.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ProsecnaOcenaResponse[" + "prosek=" + prosek + "]";
    }

}
