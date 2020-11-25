package com.countrymanagement.controller;

import com.countrymanagement.dto.CountryDto;
import com.countrymanagement.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CountryDto countryDto){
        return countryService.add(countryDto);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CountryDto countryDto){
        return countryService.update(countryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return countryService.delete(id);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> search(@PathVariable Integer id){
        return countryService.search(id);
    }
}
