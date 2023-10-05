package com.springbackend.dao;
import com.springbackend.entity.Province;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface ProvinceRepository extends  JpaRepository < Province, Integer> {
    

    List<Province> findByCountryCode(@Param("code") String code);
    //https://localhost:8080/api/search/findByCountryCode?code=SA
}
