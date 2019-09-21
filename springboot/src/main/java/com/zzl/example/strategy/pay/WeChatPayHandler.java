package com.zzl.example.strategy.pay;

import com.zzl.example.strategy.enums.PayWayEnum;
import com.zzl.example.strategy.util.HandlerType;
import org.springframework.stereotype.Service;

/**
 * @author: zhile.Zhang
 * @date: 2019/9/21
 * @desc: 微信支付接口
 **/
@Service
@HandlerType(typeEnum = PayWayEnum.WECHAT)
public class WeChatPayHandler extends AbstractHandler {

    @Override
    public String handler(String param) {
        System.out.println("WeChatPayHandler success!");
        return param + " WeChat success";
    }
}
