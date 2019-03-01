package com.handler.tracker.service;

import com.handler.tracker.model.RegisterDto;
import org.springframework.http.ResponseEntity;

public interface PdfService {
  ResponseEntity testre1();

  ResponseEntity save(RegisterDto registerDto);
}
