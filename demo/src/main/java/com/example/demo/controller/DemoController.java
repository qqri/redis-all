package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/set")
    public String setFruit(@RequestParam String name) {
        ValueOperations<String , String> ops = redisTemplate.opsForValue(); //simple value로 op 수행할수있는 객체 반환
        ops.set("fruit" , name);

        return "saved";
    }

    @GetMapping("/get")
    public String getFruit() {
        ValueOperations<String , String> ops = redisTemplate.opsForValue();
        String fName = ops.get("fruit");

        return fName;
    }
}
