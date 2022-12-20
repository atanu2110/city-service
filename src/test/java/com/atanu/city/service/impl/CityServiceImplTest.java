package com.atanu.city.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.atanu.city.entity.City;
import com.atanu.city.repository.CityRepository;

@ExtendWith(MockitoExtension.class)
class CityServiceImplTest {

	@Mock
	CityRepository cityRepository;

	@InjectMocks
	CityServiceImpl cityService;

	City city1 = City.builder().name("city1").photoURL("https:test.com").build();
	City city2 = City.builder().name("city2").photoURL("https:test2.com").build();

	@Test
	void getAllCitiesTest() {
		List<City> cityList = new ArrayList<City>();
		cityList.add(city1);
		cityList.add(city2);

		Pageable paging = PageRequest.of(1, 1000);
		Page<City> cityPage = new PageImpl<City>(cityList, paging, cityList.size());

		Mockito.when(cityRepository.findAll(paging)).thenReturn(cityPage);

		List<City> cList = cityService.getAllCities(1, 1000);

		assertEquals(cityList.size(), cList.size());
	}

}
