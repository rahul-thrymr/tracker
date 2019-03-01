package com.handler.tracker.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
  private boolean status;
  private String message;
  private Object payLoad;

  public ApiResponse(boolean status, String message, Object payLoad) {
    this.status = status;
    this.message = message;
    this.payLoad = payLoad;
  }
}
