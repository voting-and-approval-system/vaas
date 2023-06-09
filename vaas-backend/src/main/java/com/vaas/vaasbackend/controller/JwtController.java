package com.vaas.vaasbackend.controller;

import com.vaas.vaasbackend.responseBody.JwtRequest;
import com.vaas.vaasbackend.responseBody.JwtResponse;
import com.vaas.vaasbackend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class JwtController {
    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        return jwtService.createJwtToken(jwtRequest);

    }
}
