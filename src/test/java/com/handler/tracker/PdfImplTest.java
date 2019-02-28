package com.handler.tracker;

import com.handler.tracker.service.serviceImpl.PdfServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PdfImplTest {

  @InjectMocks
  PdfServiceImpl PdfServiceImpl;

  @Mock
  Mock mock;

  @Test
  public void testCondition() {
//    Mockito.when(mock.PdfServiceImpl.getC(2, 3)).thenReturn(5);
//    Mockito.when("b").thenReturn("3");
//    int checkconditions = PdfServiceImpl.checkconditions(2, 3);
//    System.out.println(checkconditions);
    Assert.assertEquals(PdfServiceImpl.checkconditions(2,3), 5);
  }

}
