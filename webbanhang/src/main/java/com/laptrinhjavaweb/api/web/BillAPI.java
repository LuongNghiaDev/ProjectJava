package com.laptrinhjavaweb.api.web;

import com.laptrinhjavaweb.dto.BillDTO;
import com.laptrinhjavaweb.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillAPI {

    @Autowired
    private IBillService billService;

    @PostMapping("/api/addBill")
    public BillDTO addBill(@RequestBody BillDTO dto){
        return billService.AddBill(dto);
    }
}
