package com.test.mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.libcore.net.NetError;
import com.android.mvc.R;

public class MainActivity extends AppCompatActivity implements TestCallBack {
    private TextView textView;
    private TestModel testModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        testModel =new TestModelImpl(this);
        testModel.getTestDta(this);
    }

    public void initView() {
        textView = (TextView) findViewById(R.id.test);
    }

    public void setTextViewData(Testbean.DataBean dataBean) {
        textView.setText(dataBean.getCountry());
    }


    @Override
    public void onSuccess(Testbean.DataBean dataBean) {
        setTextViewData(dataBean);
    }

    @Override
    public void onFailed(NetError netError) {
        Toast.makeText(this, netError.errorMessage, Toast.LENGTH_LONG).show();
    }
}
