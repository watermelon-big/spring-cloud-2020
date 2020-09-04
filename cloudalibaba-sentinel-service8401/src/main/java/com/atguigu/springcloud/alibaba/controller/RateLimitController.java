package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.myHandler.CustomerBolckHandler;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"servial001"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t"+"服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按Url限流测试OK",new Payment(2020L,"servial002"));
    }

//    CustomerBolckHandler

    @GetMapping("/rateLimit/customerBolckHandler")
    @SentinelResource(value = "customerBolckHandler",
            blockHandlerClass = CustomerBolckHandler.class,
            blockHandler = "hadlerException2")
    public CommonResult customerBolckHandler(){
        return new CommonResult(200,"按客户自定义",new Payment(2020L,"servial003"));
    }
}
