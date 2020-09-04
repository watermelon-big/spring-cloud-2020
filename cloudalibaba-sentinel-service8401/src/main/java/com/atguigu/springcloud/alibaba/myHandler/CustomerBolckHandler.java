package com.atguigu.springcloud.alibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

public class CustomerBolckHandler {
    public static CommonResult hadlerException(BlockException exception){
        return new CommonResult(444,"按客户自定义，全局的---1");
    }

    public static CommonResult hadlerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义，全局的---2");
    }
}
