package com.atanu.city.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.atanu.city.entity.City;
import com.atanu.city.service.CityService;

@WebMvcTest(CityController.class)
class CityControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	CityService cityService;

	City city1 = City.builder().name("city1").photoURL("https:test.com").build();
	City city2 = City.builder().name("city2").photoURL("https:test2.com").build();

	@Test
	void shouldReturnCities() throws Exception {
		List<City> cityList = new ArrayList<City>();
		cityList.add(city1);
		cityList.add(city2);

		Mockito.when(cityService.getAllCities(0, 1000)).thenReturn(cityList);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cities")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
