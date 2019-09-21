package com.zzl.example.strategy.util;

import com.zzl.example.strategy.enums.PayWayEnum;

import java.lang.annotation.*;

/**
 * @author: zhile.Zhang
 * @date: 2019/9/21
 * @desc:
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface HandlerType {

    //String value();

    PayWayEnum typeEnum();
}
