package com.handler.tracker.controller;

import com.handler.tracker.model.RegisterDto;
import com.handler.tracker.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TrackerController {

 @Autowired
  PdfService pdfservice;

 @GetMapping("test1")
  public ResponseEntity tester1() {
  return pdfservice.testre1();
  }

 @PostMapping("save")
 public ResponseEntity saveDetails(@Valid @RequestBody RegisterDto registerDto) {
  return pdfservice.save();
 }

}
