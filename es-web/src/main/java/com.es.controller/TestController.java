package com.es.controller;

import com.es.biz.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    TestService testService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "123";
    }

    @RequestMapping(value = "createIndex",method = RequestMethod.POST)
    public String createIndex(){
        String ret = testService.createIndex();
        return ret;
    }
}
