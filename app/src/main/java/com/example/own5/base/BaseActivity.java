package com.example.own5.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public abstract class BaseActivity <ViewInterface,P extends BasePresenter<ViewInterface>> extends Activity {
    P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((ViewInterface) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
    protected abstract P createPresenter();
    protected P getPresenter(){
        return mPresenter;
    }
}
