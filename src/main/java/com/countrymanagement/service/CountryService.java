package com.countrymanagement.service;

import com.countrymanagement.dto.CountryDto;
import org.springframework.http.ResponseEntity;

public interface CountryService {

    public ResponseEntity<?> add(CountryDto countryDto);

    public ResponseEntity<?> update(CountryDto countryDto);

    public ResponseEntity<?> delete(Integer id);

    public ResponseEntity<?> getAll();

    public ResponseEntity<?> search(Integer id);



}
