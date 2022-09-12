package com.example.denisspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

  @GetMapping("/hello-page")
  public String getPage() {
    return "index.html";
  }
}
