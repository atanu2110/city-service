package com.atanu.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atanu.city.entity.City;
import com.atanu.city.service.CityService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CityController {

	@Autowired
	CityService cityService;

	@GetMapping("/cities")
	public ResponseEntity<List<City>> getAllTutorials(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "1000") int pageSize) {

		List<City> cities = cityService.getAllCities(pageNo, pageSize);
		if (cities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}

	@PutMapping("/cities/{id}")
	public ResponseEntity<City> updateTutorial(@PathVariable("id") int id, @RequestBody City city) {
		City cityInDB = cityService.updateCity(id, city);
		if (cityInDB != null) {
			return new ResponseEntity<>(cityInDB, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
