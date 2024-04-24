package pl.tu.kielce.ediary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MainController {
    @GetMapping("/")
    public String HelloWorld(){
        return "Hello world";
    }
}
