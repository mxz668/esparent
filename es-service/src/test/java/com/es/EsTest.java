package com.es;

import com.es.biz.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

//@RunWith(SpringRunner.class)
@Configuration
@ComponentScan(value = "com.es")
public class EsTest {

    @Resource
    TestService testService;

    @Test
    public void createIndex(){
        String ret = testService.createIndex();
        System.out.println(ret);
    }
}
