package com.handler.tracker.service.serviceImpl;

import com.handler.tracker.config.ApiResponse;
import com.handler.tracker.config.ReturnMessage;
import com.handler.tracker.model.RegistrationDetails;
import com.handler.tracker.repo.RegistrationRepo;
import com.handler.tracker.service.PdfService;
import com.handler.tracker.service.TestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Log4j2
public class PdfServiceImpl implements PdfService {

  @Autowired
  private RegistrationRepo registrationRepo;

  @Autowired
  private ReturnMessage returnMessage;

  @Autowired
  private TestService testService;

  public void createPdf() {
    System.out.println("autowire");
  }

  @PostConstruct
  public void testre() {
    log.info("resource");
  }

  @Override
  public ResponseEntity testre1() {
    checkconditions(2,3);
    return new ResponseEntity<>(new ApiResponse(HttpStatus.OK.value(), "", ""), HttpStatus.OK);

  }

  @Override
  public ResponseEntity save() {
    testService.tester();
    tester();
    RegistrationDetails registrationDetails = new RegistrationDetails();
    registrationDetails.setEmail("rahu.chintu@gmail.com");
    registrationDetails.setFirst_name(null);
    registrationDetails.setLast_name("rahu");
    registrationDetails.setPassword("rahul");
    return new ResponseEntity<>(new ApiResponse(HttpStatus.OK.value(), returnMessage.messageSource("test.message"), registrationRepo.save(registrationDetails)), HttpStatus.OK);
  }

  public int checkconditions(int a, int b) {
    log.info(a+"--------"+b);
    System.out.println(a+"--------"+b);
    System.out.println(a+"--------"+b);
    System.out.println(a+"--------"+b);
    int c = getC(a, b);
    return c;
  }

  public int getC(int a, int b) {
    int c = 5;
    if( a == 2 && b == 3) {
      System.out.println((a+b)+"-----sum");
      c = a+b;
    }
    return c;
  }

  private ResponseEntity tester() {
    try {
      int c = 1 / 0;
    } catch (ArithmeticException e) {
      throw new RuntimeException("can be divisible");
    }
    return new ResponseEntity<>(new ApiResponse(HttpStatus.OK.value(), "", ""), HttpStatus.OK);
  }

}
