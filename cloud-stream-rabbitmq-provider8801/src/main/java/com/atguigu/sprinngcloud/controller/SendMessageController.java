package com.atguigu.sprinngcloud.controller;


import com.atguigu.sprinngcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping(value="/sendMessage")
    public String sendMessage(){
        return  iMessageProvider.send();
    }
}
