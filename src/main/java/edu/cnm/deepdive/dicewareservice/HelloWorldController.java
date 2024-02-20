package edu.cnm.deepdive.dicewareservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  public String getGreeting() {
    return "Hello, World!";
  }

}
