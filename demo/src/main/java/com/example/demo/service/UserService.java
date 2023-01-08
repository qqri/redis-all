package com.example.demo.service;

import com.example.demo.dto.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    ExternalService externalService;

    @Autowired
    StringRedisTemplate redisTemplate;

    public UserProfile getUserProfile(String userId) {

        String userName = null;

        ValueOperations<String,String> ops = redisTemplate.opsForValue();
        String cachedName = ops.get("nameKey:" + userId);
        if(cachedName != null) {
            userName = cachedName;
        } else {
            userName = externalService.getUserName(userId);
            ops.set("nameKey:" + userId, userName , 5 , TimeUnit.SECONDS);
        }

        //String userName = externalService.getUserName(userId);
        int userAge = externalService.getUserAge(userId);

        return new UserProfile(userName, userAge);
    }

}
