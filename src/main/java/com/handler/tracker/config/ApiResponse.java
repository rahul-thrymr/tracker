package com.handler.tracker.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
  private int id;
  private String message;
  private Object payLoad;

  public ApiResponse(int id, String message, Object payLoad) {
    this.id = id;
    this.message = message;
    this.payLoad = payLoad;
  }
}
