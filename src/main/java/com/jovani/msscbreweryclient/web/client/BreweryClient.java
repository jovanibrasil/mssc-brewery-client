package com.jovani.msscbreweryclient.web.client;

import com.jovani.msscbreweryclient.web.model.BeerDto;
import com.jovani.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "ms.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    private final String BEER_PATH_V1 = "/api/v1/beer/";
    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID id){
        return this.restTemplate
                .getForObject(apihost + BEER_PATH_V1 + id, BeerDto.class);
    }

    public URI saveBeer(BeerDto beerDto){
        return this.restTemplate
                .postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(BeerDto beerDto){
        this.restTemplate.put(apihost + BEER_PATH_V1, beerDto);
    }

    public void deleteBeer(UUID id){
        this.restTemplate.delete(apihost + BEER_PATH_V1 + id);
    }

    public CustomerDto getCustomerById(UUID id){
        return this.restTemplate
                .getForObject(apihost + CUSTOMER_PATH_V1 + id, CustomerDto.class);
    }

    public URI saveCustomer(CustomerDto customerDto){
        return this.restTemplate
                .postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(CustomerDto customerto){
        this.restTemplate.put(apihost + CUSTOMER_PATH_V1, customerto);
    }

    public void deleteCustomer(UUID id){
        this.restTemplate.delete(apihost + CUSTOMER_PATH_V1 + id);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }


}
