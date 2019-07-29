package com.app.hannahcore.scaner;


import com.google.zxing.Result;

/**
 * @author Vondear
 * @date 2017/9/22
 */

public interface OnRxScannerListener {
    void onSuccess(String type, Result result);

    void onFail(String type, String message);
}
