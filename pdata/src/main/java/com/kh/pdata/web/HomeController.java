package com.kh.pdata.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j //lombok의 언어패키지
@Controller
public class HomeController {

   @RequestMapping("/")
   public String home(){
      return "index";
   }
}
