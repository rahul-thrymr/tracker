package com.handler.tracker.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class RegisterDto {
  @NotEmpty(message = "{email.notempty}")
  private String email;
  @NotEmpty(message = "{first.not_empty}")
  private String first_name;
  private String last_name;
  private String password ;
}
