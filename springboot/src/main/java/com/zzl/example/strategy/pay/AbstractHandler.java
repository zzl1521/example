package com.zzl.example.strategy.pay;

/**
 * @author: zhile.Zhang
 * @date: 2019/9/21
 * @desc: 支付入口
 **/
public abstract class AbstractHandler {

    /**
     * 业务类 处理接口
     * @param param
     * @return
     */
    public abstract String handler(String param);
}
