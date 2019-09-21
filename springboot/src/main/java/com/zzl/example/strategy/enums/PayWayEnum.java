package com.zzl.example.strategy.enums;

/**
 * @author: zhile.Zhang
 * @date: 2019/9/21
 * @desc:
 **/
public enum PayWayEnum {

    ALIPAY("AliPay"),
    WECHAT("WeChat");

    private String payType;

    PayWayEnum(String payType) {
        this.payType = payType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }


}
