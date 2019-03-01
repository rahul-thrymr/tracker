package com.handler.tracker.controller;

import com.handler.tracker.config.ApiResponse;
import com.handler.tracker.model.Login;
import com.handler.tracker.model.RegisterDto;
import com.handler.tracker.securityHandler.JwtTokenProvider;
import com.handler.tracker.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TrackerController {

 @Autowired
  PdfService pdfservice;

 @Autowired
 AuthenticationManager authenticationManager;

 @Autowired
 JwtTokenProvider jwtTokenProvider;

 @PreAuthorize("hasAuthority('USER')")
 @GetMapping("details")
  public ResponseEntity tester1() {
  return pdfservice.testre1();
  }

 @PostMapping("save")
 public ResponseEntity saveDetails(@Valid @RequestBody RegisterDto registerDto) {
  return pdfservice.save(registerDto);
 }

 @PostMapping("login")
 public ResponseEntity loginUser(@RequestBody Login login) {

  Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
      );

  SecurityContextHolder.getContext().setAuthentication(authentication);

  String generateToken = jwtTokenProvider.generateToken(authentication);

  return new ResponseEntity<>(new ApiResponse(true, "add 'Bearer<space>token' ", generateToken), HttpStatus.OK);
 }

}
