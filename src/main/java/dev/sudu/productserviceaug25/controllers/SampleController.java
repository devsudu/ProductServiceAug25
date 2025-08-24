package dev.sudu.productserviceaug25.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello/{name}/{time}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("time") int time) {
        String s = "";
        for(int i=0; i<time; i++) {
            s += "Hello " + name + "! <br>";
        }

        return s;
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi";
    }
}
