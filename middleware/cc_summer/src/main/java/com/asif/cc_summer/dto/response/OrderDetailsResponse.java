package com.asif.cc_summer.dto.response;

import com.asif.cc_summer.entity.Cart;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDetailsResponse {
    private Long id;
    private Long userId;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String status;
    private String dateTime;
    private Boolean paymentDone;
    private String orderStatus;
    private List<CartListResponse> cartList;

}
