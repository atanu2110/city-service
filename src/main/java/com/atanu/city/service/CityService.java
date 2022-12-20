package com.atanu.city.service;

import java.util.List;

import com.atanu.city.entity.City;

public interface CityService {

	List<City> getAllCities(Integer pageNo, Integer pageSize);

	City updateCity(int id, City city);
}
