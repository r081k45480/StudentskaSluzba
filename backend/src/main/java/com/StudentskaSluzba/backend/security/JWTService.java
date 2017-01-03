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
package com.StudentskaSluzba.backend.security;

import com.StudentskaSluzba.backend.config.CustomProperties;
import com.StudentskaSluzba.backend.model.enumeration.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;


@Service
public class JWTService {

    private static final String AUTHORITIES_KEY = "auth";
    private static final String REFRESH_AUTHORITY = "refresh";

    @Inject
    private CustomProperties customProperties;

    public String createAccessToken(long principalId, UserRole userRole) {
        return Jwts.builder().setSubject(String.valueOf(principalId)).claim(AUTHORITIES_KEY, userRole.toString()).signWith(SignatureAlgorithm.HS512, customProperties.getSecretKey())
                .setExpiration(getValidity(customProperties.getAccessTokenValidityInSeconds())).compact();
    }

    public String createRefreshToken(long principalId) {
        return Jwts.builder().setSubject(String.valueOf(principalId)).claim(AUTHORITIES_KEY, REFRESH_AUTHORITY).signWith(SignatureAlgorithm.HS512, customProperties.getSecretKey())
                .setExpiration(getValidity(customProperties.getRefreshTokenValidityInSeconds())).compact();
    }

    @SuppressWarnings("unchecked")
    Authentication getAuthentication(String token) {
        final Claims claims = getJwtClaims(token);
        final long principalId = Long.parseLong(claims.getSubject());

        final String userRole = claims.get(AUTHORITIES_KEY).toString();

        return new PreAuthenticatedAuthenticationToken(principalId, null, Collections.singletonList(new SimpleGrantedAuthority(userRole)));
    }

    public Claims getJwtClaims(String token) {
        return Jwts.parser().setSigningKey(customProperties.getSecretKey()).parseClaimsJws(token).getBody();
    }

    private Date getValidity(long tokenValidity) {
        return Date.from(ZonedDateTime.now(ZoneId.of("UTC")).plusSeconds(tokenValidity).toInstant());
    }

}
