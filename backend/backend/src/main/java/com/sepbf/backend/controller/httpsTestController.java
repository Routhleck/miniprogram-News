package com.sepbf.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: backend
 * @description:
 * @author: 20301037_Routhleck
 * @create: 2023-06-12 09:36
 **/
@RestController
public class httpsTestController {
    @GetMapping("/httpsTest")
    public String httpsTest(){
        return "httpsTest";
    }
}
