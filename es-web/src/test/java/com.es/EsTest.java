package com.es;

import com.es.biz.TestService;
import com.es.controller.AppConfig;
import com.es.controller.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:*.xml"})
public class EsTest {

    @Autowired
    TestService testService;

    @Test
    public void createIndex(){
//        String ret = testService.createIndex();
//        System.out.println(ret);
        System.out.println("123");
    }
}
