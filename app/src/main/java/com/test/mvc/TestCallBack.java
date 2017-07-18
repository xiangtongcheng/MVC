package com.test.mvc;

import com.android.libcore.net.NetError;

/**
 * Created by Administrator on 2017/7/17 0017.
 */

public interface TestCallBack {
    //成功
    void onSuccess(Testbean.DataBean dataBean);
    //失败
    void onFailed(NetError netError);
}
