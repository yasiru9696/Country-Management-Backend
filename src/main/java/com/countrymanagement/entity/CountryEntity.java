package com.countrymanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CountryEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String region;
    private String status;
    private Date create_Date;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate_Date() {
        return create_Date;
    }

    public void setCreate_Date(Date create_Date) {
        this.create_Date = create_Date;
    }
}
