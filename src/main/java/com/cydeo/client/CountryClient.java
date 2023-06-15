package com.cydeo.client;

import com.cydeo.dto.country.CountryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://restcountries.com/v3.1",name = "COUNTRY-CLIENT")
public interface CountryClient {

    @GetMapping("/name/{countryName}")
    List<CountryDTO> getCountryInfo(@PathVariable String countryName);

}
