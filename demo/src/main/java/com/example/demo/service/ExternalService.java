package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ExternalService {
    public String getUserName(String userId) {
        //외부서비스나 db 호출
        try {
            Thread.sleep(500);
        }   catch (InterruptedException e) {

        }

        System.out.println("Getting User name from external api");
        if(userId.equals("A")) {
            return "Adam";
        }
        if(userId.equals("B")) {
            return "Bob";
        }

        return "";

    }

    public int getUserAge(String userId) {
        //외부서비스나 db 호출
        try {
            Thread.sleep(500);
        }   catch (InterruptedException e) {

        }
        System.out.println("Getting User age from external api");
        if(userId.equals("A")) {
            return 28;
        }
        if(userId.equals("B")) {
            return 32;
        }

        return 0 ;

    }
}
