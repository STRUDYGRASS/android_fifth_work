package com.example.own5.Model;

import com.example.own5.bean.PhoneReturn;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public class PhoneApi {
    public final static String APP_KEY="05ff3dced279315a3c35ea623bd9b48b";//此处APP_KEY需要自己到《聚合数据》网站注册获取
    public final static String BASE_URL="http://apis.juhe.cn/";
    public final static String PHONE="mobile/get";
    public interface PhoneService{
        @GET(PHONE)
        Observable<PhoneReturn> getPhone(@Query("phone")int phone, @Query("key") String app_key);
    }
}
