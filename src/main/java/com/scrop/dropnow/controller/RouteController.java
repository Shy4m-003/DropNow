package com.scrop.dropnow.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class RouteController {
    @RequestMapping(value = {
            "/{path:[^\\.]*}",
            "/**/{path:^(?!api).*[^\\.]*}"
    })
    public String redirect() {
        return "forward:/index.html";
    }
}
