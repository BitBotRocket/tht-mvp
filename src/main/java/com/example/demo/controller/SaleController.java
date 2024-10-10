package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sale;
import com.example.demo.model.SaleReceipt;
import com.example.demo.service.SalesService;

@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private SalesService salesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaleReceipt add(@RequestBody Sale sale) {
        return salesService.getSaleReceipt(sale);
    }

}
