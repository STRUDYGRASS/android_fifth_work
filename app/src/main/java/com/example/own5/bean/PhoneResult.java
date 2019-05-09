package com.example.own5.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PhoneResult {

    @Getter
    @Setter
    private String province;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String areacode;
    @Getter
    @Setter
    private String zip;
    @Getter
    @Setter
    private String company;
    @Getter
    @Setter
    private String card;
}
