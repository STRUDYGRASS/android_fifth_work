package com.example.own5.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PhoneReturn {
    @Getter
    @Setter
    private String reason;
    @Getter
    @Setter
    private PhoneResult result;
}
