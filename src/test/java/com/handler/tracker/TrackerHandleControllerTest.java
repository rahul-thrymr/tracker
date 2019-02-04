package com.handler.tracker;


import com.handler.tracker.controller.TrackerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest(TrackerController.class)
public class TrackerHandleControllerTest {
  @Autowired
  private MockMvc mockMvc;

  //@Test
  public void testSayHelloWorld() throws Exception {
//    when("").thenReturn();
    this.mockMvc.perform(get("/test1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk());
//        .andExpect(content().contentType("application/json"));

  }
}
