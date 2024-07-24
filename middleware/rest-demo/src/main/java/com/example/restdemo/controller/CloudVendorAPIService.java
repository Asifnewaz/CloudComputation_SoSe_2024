package com.example.restdemo.controller;

import com.example.restdemo.model.CloudVendor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId) {
        String xxx = "xxx";
        return new CloudVendor ("C1","Vendor 1","Address one", "xx");
    }
}
