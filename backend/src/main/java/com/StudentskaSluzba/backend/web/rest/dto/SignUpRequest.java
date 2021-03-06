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


public class SignUpRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(max = 255)
    private String ime;

    @NotNull
    @Size(max = 255)
    private String prezime;

    @NotNull
    @Size(max = 255)
    private String indeks;

    @NotNull
    private BigDecimal trenutnoStanjeRacuna;

    @NotNull
    private Boolean budzet;

    @NotNull
    @Min(1)
    private Integer tekuciSemestar;

    @NotNull
    @Min(0)
    private Integer osvojeniBodovi;

    @NotNull
    @Size(min = 3, max = 128)
    private String username;

    @NotNull
    @Size(min = 6, max = 32)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$")
    private String password;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public BigDecimal getTrenutnoStanjeRacuna() {
        return trenutnoStanjeRacuna;
    }

    public void setTrenutnoStanjeRacuna(BigDecimal trenutnoStanjeRacuna) {
        this.trenutnoStanjeRacuna = trenutnoStanjeRacuna;
    }

    public Boolean getBudzet() {
        return budzet;
    }

    public void setBudzet(Boolean budzet) {
        this.budzet = budzet;
    }

    public Integer getTekuciSemestar() {
        return tekuciSemestar;
    }

    public void setTekuciSemestar(Integer tekuciSemestar) {
        this.tekuciSemestar = tekuciSemestar;
    }

    public Integer getOsvojeniBodovi() {
        return osvojeniBodovi;
    }

    public void setOsvojeniBodovi(Integer osvojeniBodovi) {
        this.osvojeniBodovi = osvojeniBodovi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final SignUpRequest other = (SignUpRequest) obj;
        if ((ime == null && other.ime != null) || !ime.equals(other.ime))
            return false;
        if ((prezime == null && other.prezime != null) || !prezime.equals(other.prezime))
            return false;
        if ((indeks == null && other.indeks != null) || !indeks.equals(other.indeks))
            return false;
        if ((trenutnoStanjeRacuna == null && other.trenutnoStanjeRacuna != null) || !trenutnoStanjeRacuna.equals(other.trenutnoStanjeRacuna))
            return false;
        if ((budzet == null && other.budzet != null) || !budzet.equals(other.budzet))
            return false;
        if ((tekuciSemestar == null && other.tekuciSemestar != null) || !tekuciSemestar.equals(other.tekuciSemestar))
            return false;
        if ((osvojeniBodovi == null && other.osvojeniBodovi != null) || !osvojeniBodovi.equals(other.osvojeniBodovi))
            return false;
        if ((username == null && other.username != null) || !username.equals(other.username))
            return false;
        if ((password == null && other.password != null) || !password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ime == null) ? 0 : ime.hashCode());
        result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
        result = prime * result + ((indeks == null) ? 0 : indeks.hashCode());
        result = prime * result + ((trenutnoStanjeRacuna == null) ? 0 : trenutnoStanjeRacuna.hashCode());
        result = prime * result + ((budzet == null) ? 0 : budzet.hashCode());
        result = prime * result + ((tekuciSemestar == null) ? 0 : tekuciSemestar.hashCode());
        result = prime * result + ((osvojeniBodovi == null) ? 0 : osvojeniBodovi.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SignUpRequest[" + "ime=" + ime + ", prezime=" + prezime + ", indeks=" + indeks + ", trenutnoStanjeRacuna=" + trenutnoStanjeRacuna + ", budzet=" + budzet + ", tekuciSemestar="
                + tekuciSemestar + ", osvojeniBodovi=" + osvojeniBodovi + ", username=" + username + "]";
    }

}
