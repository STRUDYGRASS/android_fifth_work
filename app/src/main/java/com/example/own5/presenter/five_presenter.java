package com.example.own5.presenter;

import com.example.own5.Model.five_model;
import com.example.own5.base.BasePresenter;
import com.example.own5.bean.PhoneResult;
import com.example.own5.contract.five_contract;

public class five_presenter extends BasePresenter<five_contract.five_ViewInterface> implements five_contract.five_PresenterInterface {
    five_model fiveModel = null;
    five_contract.five_ModelInterface.PhoneCallback phoneCallback = new five_contract.five_ModelInterface.PhoneCallback() {
        @Override
        public void onPhone(PhoneResult phoneResult) {
            getView().showPhoneProvince(phoneResult.getProvince());
            getView().showPhonePlace(phoneResult.getCity());
            getView().showPhoneArea(phoneResult.getAreacode());
        }
    };
    public five_presenter(five_contract.five_ViewInterface v) {
        super(v);
        fiveModel=new five_model();
    }

    @Override
    public void getPhone(int PhoneNum){
        fiveModel.getPlace(PhoneNum,phoneCallback);
    }

}
