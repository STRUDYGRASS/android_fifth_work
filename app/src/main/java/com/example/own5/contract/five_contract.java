package com.example.own5.contract;

import com.example.own5.bean.PhoneResult;

public interface five_contract {
    interface five_ViewInterface{
        void showPhoneProvince(String provice);
        void showPhonePlace(String city);
        void showPhoneArea(String areacode);
    }

    interface five_PresenterInterface{
        void getPhone(int PhoneNum);
    }

    interface five_ModelInterface{
        void getPlace(int PhoneNum,PhoneCallback weatherCallback);
        interface PhoneCallback{
            void onPhone(PhoneResult phoneResult);
        }
    }
}
