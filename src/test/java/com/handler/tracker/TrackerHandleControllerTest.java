package com.handler.tracker;


import com.handler.tracker.controller.TrackerController;
import com.handler.tracker.service.PdfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TrackerController.class)
public class TrackerHandleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  PdfService pdfService;

  @Test
  public void testSayHelloWorld() throws Exception {
//    when(pdfService.testre1()).thenReturn("yuppieeee");
    this.mockMvc.perform(get("/test1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", is("yuppieeee")));
//        .andExpect(content().contentType("application/json"));

  }
}
