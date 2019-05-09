package com.example.own5.Model;

import android.util.Log;

import com.example.own5.bean.PhoneReturn;
import com.example.own5.contract.five_contract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

public class five_model implements five_contract.five_ModelInterface{

    PhoneApi.PhoneService phoneService = null;
    public five_model()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(PhoneApi.BASE_URL)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        phoneService = retrofit.create(PhoneApi.PhoneService.class);
    }

    @Override
    public void getPlace(int phonenum,final PhoneCallback phoneCallback){
        phoneService.getPhone(phonenum,PhoneApi.APP_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<PhoneReturn>(){
                    @Override
                    public void onNext(PhoneReturn phoneReturn){
                        if(phoneReturn.getReason().equalsIgnoreCase("Return Successd!")){
                            Log.d("WeatherModel:",phoneReturn.getResult().getCity()+"预报查询成功");
                            phoneCallback.onPhone(phoneReturn.getResult());

                        }
                    }
                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
