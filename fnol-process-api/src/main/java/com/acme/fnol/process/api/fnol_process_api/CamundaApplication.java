package com.acme.fnol.process.api.fnol_process_api;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableProcessApplication("fnol-process-api")
@ComponentScan(basePackages = { "com.acme.fnol.process.api.fnol_process_api.api", "com.acme.fnol.process.api.fnol_process_api.configuration" , "com.acme.fnol.process.api.fnol_process_api.model","com.acme.fnol.process.api.fnol_process_api.delegate"})
public class CamundaApplication {
  public static void main(String... args) {
    SpringApplication.run(CamundaApplication.class, args);
  }
}
