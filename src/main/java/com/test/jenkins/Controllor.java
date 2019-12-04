package com.test.jenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ubuntu
 * @date $ $
 */
@RestController
public class Controllor {


    @GetMapping("test")
    public String test() {
        return "这是一个测试页面";
    }


}
