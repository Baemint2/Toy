package org.moz1mozi.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayhello() {
        return "hello Spring Boot Board";
    }
}
