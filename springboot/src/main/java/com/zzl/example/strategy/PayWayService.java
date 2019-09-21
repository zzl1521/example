package com.zzl.example.strategy;

import com.zzl.example.strategy.pay.AbstractHandler;
import com.zzl.example.strategy.util.BeanTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: zhile.Zhang
 * @date: 2019/9/21
 * @desc:
 **/
@Service
public class PayWayService {


    @Resource
    private HandlerContext handlerContext;

    public String pay(String payType,String param){
        Class instant = handlerContext.getInstant(payType);
        AbstractHandler abstractHandler = (AbstractHandler) BeanTool.getBean(instant);
        return abstractHandler.handler(param);
    }

}
