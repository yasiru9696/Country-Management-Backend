package com.countrymanagement.Repository;

import com.countrymanagement.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity,String> {

    CountryEntity findById(Integer id);

    List<CountryEntity> findAllByStatus(String status);
}
