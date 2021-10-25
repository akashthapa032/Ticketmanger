package com.ticket.manger.controller;

import com.ticket.manger.dto.LoginDto;
import com.ticket.manger.dto.TokenDto;
import com.ticket.manger.service.TicketUserDetailService;
import com.ticket.manger.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value={"","/home"})
public class HomeController {

    @Autowired
    private TicketUserDetailService ticketUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    public String helelo(){

        return "hello world I am akash";
    }
@PostMapping("/auth")
    public TokenDto login(@Valid @RequestBody LoginDto loginDto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
    UserDetails userDetails = ticketUserDetailService.loadUserByUsername(loginDto.getUsername());
    return new TokenDto(jwtUtil.generateToken(userDetails));

}


}
