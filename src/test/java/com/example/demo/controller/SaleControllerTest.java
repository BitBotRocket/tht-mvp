package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.example.demo.model.Sale;
import com.example.demo.model.SaleReceipt;
import com.example.demo.service.SalesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.demo.model.SaleItem;
import java.util.List;


//@WebMvcTest(SaleController.class)
public class SaleControllerTest {

  /*  @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalesService salesService;

    @InjectMocks
    private SaleController saleController;

    private Sale sale;
    private SaleReceipt saleReceipt;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(saleController).build();
        
        sale = new Sale();

        sale.setDiscountCodes(Arrays.asList("DISCOUNT1", "DISCOUNT2"));
        sale.setSaleItems(Arrays.asList(new SaleItem("1",2)));


        saleReceipt = new SaleReceipt();
        saleReceipt.se
        saleReceipt.setId("1");
        saleReceipt.setTotalPrice(200.0f);
    }

    @Test
    public void testAddSale() throws Exception {
        when(salesService.getSaleReceipt(sale)).thenReturn(saleReceipt);

        mockMvc.perform(post("/api/v1/sales")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(sale)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(saleReceipt.getId()))
                .andExpect(jsonPath("$.totalPrice").value(saleReceipt.getTotalPrice()));
    }*/
}