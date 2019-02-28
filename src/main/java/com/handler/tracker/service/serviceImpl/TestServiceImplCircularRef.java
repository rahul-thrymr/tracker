package com.handler.tracker.service.serviceImpl;

import com.handler.tracker.service.PdfService;
import com.handler.tracker.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImplCircularRef implements TestService {

  /*@Autowired
  private PdfService pdfService;*/

  @Override
  @Async("ser")
  public void tester() {
    System.out.println("ffdfdfsdfsdfsdf");
//    pdfService.testre1();
  }

}
