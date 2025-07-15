package com.likelion.sbstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SbstudyApplication {

  public static void main(String[] args) {
    SpringApplication.run(SbstudyApplication.class, args);
  }
}
