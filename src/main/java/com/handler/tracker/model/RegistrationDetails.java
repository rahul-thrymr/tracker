package com.handler.tracker.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class RegistrationDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String email;
  private String first_name;
  private String last_name;
  private String password ;
}
