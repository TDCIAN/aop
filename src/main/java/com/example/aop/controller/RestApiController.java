package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // TODO

        stopWatch.stop();
        System.out.println("total time: "+stopWatch.getTotalTimeSeconds());
        return id+" "+name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user) {
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        // db logic
        Thread.sleep(1000 * 2); // 2초
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {
        System.out.println("put"+user);
        return user;
    }
}
