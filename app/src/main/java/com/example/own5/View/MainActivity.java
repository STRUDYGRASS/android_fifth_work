package com.example.own5.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.own5.R;
import com.example.own5.base.BaseActivity;
import com.example.own5.contract.five_contract;
import com.example.own5.presenter.five_presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<five_contract.five_ViewInterface, five_presenter>implements five_contract.five_ViewInterface {

    five_presenter mfive_Presenter;
    @BindView(R.id.phonenum)
    EditText mTvphonenum;
    @BindView(R.id.area)
    TextView mTvarea;
    @BindView(R.id.place)
    TextView mTvplace;
    @BindView(R.id.province)
    TextView mTvprovince;
    @BindView(R.id.but)
    Button mTvbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mTvbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = mTvphonenum.getText().toString();
                if (str != null &&  str.length() == 7){
                mfive_Presenter.getPhone(Integer.parseInt(str));
                }
            }
       });
        mfive_Presenter = getPresenter();
    }

    @Override
    protected five_presenter createPresenter() {
        return new five_presenter((five_contract.five_ViewInterface) this);
    }

    @Override
    public void showPhoneProvince(String Province)
    {
        mTvprovince.setText(Province);
    }

    @Override
    public void showPhonePlace(String City){
        mTvplace.setText(City);
    }

    @Override
    public void showPhoneArea(String Areacode){
        mTvarea.setText(Areacode);
    }
}
