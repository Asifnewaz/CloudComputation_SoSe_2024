package com.asif.cc_summer.controllers;

import com.asif.cc_summer.dto.request.ProductDto;
import com.asif.cc_summer.dto.response.BaseResponseDto;
import com.asif.cc_summer.entity.OrderEntity;
import com.asif.cc_summer.entity.Product;
import com.asif.cc_summer.service.OrderService;
import com.asif.cc_summer.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/makeOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> makeOrder(@RequestParam Long userid,
                                       @RequestParam String name,
                                       @RequestParam String mobile_number,
                                       @RequestParam String email_address,
                                       @RequestParam String address) {
        OrderEntity entity = orderService.addService(userid, name, mobile_number, email_address, address);
        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "Order added successfully";
        response.data = entity;
        return ResponseEntity.ok(response);
    }
}
