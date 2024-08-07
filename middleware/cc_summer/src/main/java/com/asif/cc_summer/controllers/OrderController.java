package com.asif.cc_summer.controllers;

import com.asif.cc_summer.dto.request.ProductDto;
import com.asif.cc_summer.dto.response.BaseResponseDto;
import com.asif.cc_summer.entity.OrderEntity;
import com.asif.cc_summer.entity.Product;
import com.asif.cc_summer.entity.ProductCategory;
import com.asif.cc_summer.entity.UserEntity;
import com.asif.cc_summer.service.OrderService;
import com.asif.cc_summer.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping(value ="/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOrders(@RequestParam Long userid) {
        List<OrderEntity> list = orderService.getOrders(userid);

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "";
        response.data = list;
        return ResponseEntity.ok(response);
    }

    @PostMapping(value ="/updatePayment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePayment(@RequestParam Long orderID) {
        Optional<OrderEntity> order = orderService.orderPaymentDone(orderID);

        BaseResponseDto response = new BaseResponseDto();
        response.statusCode = 200;
        response.success_message = "";
        order.ifPresent(orderEntity -> response.data = orderEntity);
        return ResponseEntity.ok(response);
    }
}
