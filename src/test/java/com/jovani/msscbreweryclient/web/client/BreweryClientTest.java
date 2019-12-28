package com.jovani.msscbreweryclient.web.client;

import com.jovani.msscbreweryclient.web.model.BeerDto;
import com.jovani.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private  BreweryClient breweryClient;

    @Test
    void testGetBeerById() {
        BeerDto beerDto = this.breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testSaveBeer(){
        BeerDto beerDto = BeerDto.builder()
                .beerName("Test")
                .build();
        URI uri = this.breweryClient.saveBeer(beerDto);
        assertNotNull(uri);
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder()
                .beerName("Test")
                .id(UUID.randomUUID())
                .upc(123L)
                .beerStyle("Beer style")
                .build();
        this.breweryClient.updateBeer(beerDto);
    }

    @Test
    void testDeleteBeer(){
        this.breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testGetCustomerById() {
        CustomerDto customerDto = this.breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveCustomer(){
        CustomerDto customerDto = CustomerDto.builder()
                .customerName("Customer name")
                .build();
        URI uri = this.breweryClient.saveCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void testUpdateCustomer(){
        CustomerDto customerDto = CustomerDto.builder()
                .customerName("Customer name")
                .id(UUID.randomUUID())
                .build();
        this.breweryClient.updateCustomer(customerDto);
    }

    @Test
    void testDeleteCustomer(){
        this.breweryClient.deleteCustomer(UUID.randomUUID());
    }

}