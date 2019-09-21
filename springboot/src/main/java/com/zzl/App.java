package com.zzl;

import com.zzl.example.strategy.util.BeanTool;
import com.zzl.example.strategy.PayWayService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.zzl.example")
public class App {


    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
        PayWayService payWayService =(PayWayService) BeanTool.getBean("payWayService");
        String aliPay = payWayService.pay("AliPay", "");
        System.out.println("do finish "+ aliPay);
    }


}
