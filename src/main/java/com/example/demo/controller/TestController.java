package com.example.demo.controller;

import com.example.demo.entity.rest.RestResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jielum
 */
@RestController
public class TestController {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/test")
    public RestResult<String> test(){
        return RestResult.success("测试");
    }
}
