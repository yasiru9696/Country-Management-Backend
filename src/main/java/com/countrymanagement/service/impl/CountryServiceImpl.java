package com.countrymanagement.service.impl;

import com.countrymanagement.Repository.CountryRepository;
import com.countrymanagement.dto.CountryDto;
import com.countrymanagement.entity.CountryEntity;
import com.countrymanagement.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public ResponseEntity<?> add(CountryDto countryDto) {

        try {

            CountryEntity countryEntity = new CountryEntity();
            countryEntity.setName(countryDto.getName());
            countryEntity.setRegion(countryDto.getRegion());
            countryEntity.setStatus("ACTIVE");
            countryEntity.setCreate_Date(new Date());

            countryRepository.save(countryEntity);

            return new ResponseEntity<>("200",HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> update(CountryDto countryDto) {

        try {

            CountryEntity countryEntity = countryRepository.findById(countryDto.getId());

            if(countryEntity!=null){

                countryEntity.setName(countryDto.getName());
                countryEntity.setRegion(countryDto.getRegion());

                countryRepository.save(countryEntity);

                return new ResponseEntity<>("200",HttpStatus.OK);
            }

            throw new Exception("Invalid Country Details");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<?> delete(Integer id) {

        try {

            CountryEntity countryEntity = countryRepository.findById(id);

            if(countryEntity!=null){

                countryEntity.setStatus("INACTIVE");

                countryRepository.save(countryEntity);

                return new ResponseEntity<>("200",HttpStatus.OK);
            }

            throw new Exception("Invalid Country Details");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAll() {


        try {

            List<CountryEntity> countryEntityList = countryRepository.findAllByStatus("ACTIVE");

            if(countryEntityList!=null){

                List<CountryDto> countryDtos = new ArrayList<>();

                for (CountryEntity countryEntity:countryEntityList) {
                    countryDtos.add(setCountryDto(countryEntity));
                }

                return new ResponseEntity<>(countryDtos,HttpStatus.OK);
            }

            return new ResponseEntity<>("204",HttpStatus.NO_CONTENT);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> search(Integer id) {

        try {

            CountryEntity countryEntity = countryRepository.findById(id);

            if(countryEntity!=null){

                return new ResponseEntity<>(setCountryDto(countryEntity),HttpStatus.OK);
            }

            throw new Exception("Invalid Country Details");

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private CountryDto setCountryDto(CountryEntity countryEntity){

        CountryDto countryDto =new CountryDto();
        countryDto.setId(countryEntity.getId());
        countryDto.setName(countryEntity.getName());
        countryDto.setRegion(countryEntity.getRegion());

        return countryDto;
    }
}
