package com.mydemoapp.springbootgrpc.controller;

import com.mydemoapp.springbootgrpc.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private GrpcClientService grpcClientService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>(grpcClientService.ping(), HttpStatus.OK);
    }
}
