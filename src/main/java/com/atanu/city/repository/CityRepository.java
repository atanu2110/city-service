package com.atanu.city.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atanu.city.entity.City;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Integer> {

}
