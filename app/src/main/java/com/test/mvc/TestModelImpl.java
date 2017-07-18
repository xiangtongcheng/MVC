package com.test.mvc;

import android.content.Context;
import android.util.Log;

import com.android.libcore.net.NetError;
import com.android.libcore.net.netapi.BaseNetApi;
import com.android.libcore_ui.net.NetApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/17 0017.
 */

public class TestModelImpl implements TestModel {
    private Context context;

    public TestModelImpl(Context context) {
        this.context = context;
    }


    @Override
    public void getTestDta(final TestCallBack testCallBack) {
        NetApi.getInstance().jsonObjectRequest(context, "http://ip.taobao.com/service/getIpInfo.php?ip=63.223.108.42", new HashMap<String, String>(), new BaseNetApi.OnNetCallback<JSONObject>() {

            @Override
            public void onSuccess(JSONObject sjsonObject) {
                try {
                    Log.e("返回数据",sjsonObject.toString());
                    JSONObject  jsonObject = new JSONObject("{\"country\":\"\\u7f8e\\u56fd\",\"country_id\":\"US\",\"area\":\"\",\"area_id\":\"\",\"region\":\"\",\"region_id\":\"\",\"city\":\"\",\"city_id\":\"\",\"county\":\"\",\"county_id\":\"\",\"isp\":\"\",\"isp_id\":\"\",\"ip\":\"63.223.108.42\"}");
                    Testbean.DataBean dtaBean = new Testbean.DataBean();
                    dtaBean.setCountry(jsonObject.getString("country"));
                    dtaBean.setCity(jsonObject.getString("city"));
                    testCallBack.onSuccess(dtaBean);
                    Log.e("返回数据",jsonObject.getString("data"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFail(NetError netError) {
                testCallBack.onFailed(netError);
            }
        });
    }
}
