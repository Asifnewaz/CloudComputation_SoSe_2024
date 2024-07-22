package com.example.restdemo.model;

public class CloudVendor {
    private String vendorName;
    private String vendorId;
    private String vendorAddress;
    private String vendorPhoneNumber;

    public CloudVendor() {
    }

    public CloudVendor(String vendorName, String vendorId, String vendorAddress, String vendorPhoneNumber) {
        this.vendorName = vendorName;
        this.vendorId = vendorId;
        this.vendorAddress = vendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }


        public String getVendorName() {
            return vendorName;
        }

        public void setVendorName(String vendorName) {
            this.vendorName = vendorName;
        }

        public String getVendorId() {
            return vendorId;
        }

        public void setVendorId(String vendorId) {
            this.vendorId = vendorId;
        }

        public String getVendorAddress() {
            return vendorAddress;
        }

        public void setVendorAddress(String vendorAddress) {
            this.vendorAddress = vendorAddress;
        }

        public String getVendorPhoneNumber() {
            return vendorPhoneNumber;
        }

        public void setVendorPhoneNumber(String vendorPhoneNumber) {
            this.vendorPhoneNumber = vendorPhoneNumber;
        }

}
