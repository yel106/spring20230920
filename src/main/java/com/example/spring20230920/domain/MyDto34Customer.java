package com.example.spring20230920.domain;

import lombok.Data;

@Data
public class MyDto34Customer {
    // id, name, city, country
    private Integer customerId;
    private String customerName;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;

}
