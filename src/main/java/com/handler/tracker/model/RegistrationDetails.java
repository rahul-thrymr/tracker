package com.handler.tracker.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
public class RegistrationDetails extends BaseEntity{
  private String email;
  private String first_name;
  private String last_name;
  private String password ;
  @Enumerated(EnumType.STRING)
  private Role role;
}
