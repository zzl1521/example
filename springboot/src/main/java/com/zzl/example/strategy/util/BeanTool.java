package com.zzl.example.strategy.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: zhile.Zhang
 * @date: 2019/9/21
 * @desc:
 **/
@Component
public class BeanTool implements ApplicationContextAware {


    private static ApplicationContext ac = null;
    private static BeanTool springConfigTool = null;

    public synchronized static BeanTool init() {
        if (springConfigTool == null) {
            springConfigTool = new BeanTool();
        }
        return springConfigTool;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    public static Object getBean(String beanName) {
        return ac.getBean(beanName);
    }

    public static Object getBean(Class clazz) {
        return ac.getBean(clazz);
    }
}
