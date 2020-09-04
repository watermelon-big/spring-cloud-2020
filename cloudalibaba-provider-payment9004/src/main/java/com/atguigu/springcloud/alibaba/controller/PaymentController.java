package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap=new HashMap<>();
    static{
        hashMap.put(1L,new Payment(1L,"1"));
        hashMap.put(2L,new Payment(2L,"2"));
        hashMap.put(3L,new Payment(3L,"3"));
    }


    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment=hashMap.get(id);
        CommonResult<Payment> result=new CommonResult(200,"from mysql,serverPoer："+serverPort,payment);
        return result;
    }
}

