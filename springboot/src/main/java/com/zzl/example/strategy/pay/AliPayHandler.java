package com.zzl.example.strategy.pay;

import com.zzl.example.strategy.enums.PayWayEnum;
import com.zzl.example.strategy.util.HandlerType;
import org.springframework.stereotype.Service;

/**
 * @author: zhile.Zhang
 * @date: 2019/9/21
 * @desc: 支付宝支付接口
 **/
@Service
@HandlerType(typeEnum = PayWayEnum.ALIPAY)
public class AliPayHandler extends AbstractHandler {

    @Override
    public String handler(String param) {
        System.out.println("AliPayHandler success!");
        return param + " AliPay success";
    }
}
