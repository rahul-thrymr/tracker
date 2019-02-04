package com.handler.tracker.controller;

import com.handler.tracker.service.PdfService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Log
public class TrackerController {

 @Resource
  private PdfService pdfservice;

 @GetMapping("test1")
  public String tester1() {
   pdfservice.testre1();
    return "dfsfsdf";
  }
}
