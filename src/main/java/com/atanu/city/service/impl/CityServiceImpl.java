package com.atanu.city.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.atanu.city.entity.City;
import com.atanu.city.repository.CityRepository;
import com.atanu.city.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	private static final Logger LOG = LoggerFactory.getLogger(CityServiceImpl.class);

	@Autowired
	CityRepository cityRepository;

	@Override
	public List<City> getAllCities(Integer pageNo, Integer pageSize) {
		LOG.info("Get all cities from DB");
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<City> pagedResult = cityRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<City>();
		}
	}

	@Override
	public City updateCity(int id, City city) {
		LOG.info("Update city {}", id);
		Optional<City> cityData = cityRepository.findById(id);

		if (cityData.isPresent()) {
			City cityInDB = cityData.get();
			cityInDB.setName(city.getName());
			cityInDB.setPhotoURL(city.getPhotoURL());

			cityRepository.save(cityInDB);
			return cityInDB;
		}
		return null;
	}
}
