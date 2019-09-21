package com.zzl.example.strategy;

import com.zzl.example.strategy.util.ClassScaner;
import com.zzl.example.strategy.util.HandlerType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * @author: zhile.Zhang
 * @date: 2019/9/21
 * @desc:
 **/
@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    /**
     * 扫描包的地址
     */
    private static final String basePackage="com.zzl.example.strategy";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        HandlerContext handlerContext=new HandlerContext();
        Set<Class> scan = ClassScaner.scan(basePackage, HandlerType.class);
        scan.stream().forEach(clazz ->{
            HandlerType annotation = (HandlerType) clazz.getAnnotation(HandlerType.class);
            String value = annotation.typeEnum().getPayType();
            if (StringUtils.isEmpty(value)){
                throw new IllegalArgumentException("HandlerType type is null");
            }
            handlerContext.putHandler(value,clazz);
        });
        configurableListableBeanFactory.registerSingleton(handlerContext.getClass().getName(),handlerContext);
    }
}
