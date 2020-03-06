package com.test.demo01.controllor;/**
 * Created by ubuntu
 * On 19-12-23 下午3:07
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ubuntu
 * @date $ $
 */

@RestController
public class TestControllor {

    @GetMapping("/test")
    public String test(){
        return "test.........sucess.........";
    }
}
