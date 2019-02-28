package com.handler.tracker.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RegistrationDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String email;
  private String first_name;
  private String last_name;
  private String password ;
  @Enumerated(EnumType.STRING)
  private Role role;
}
