package com.kh.myapp1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j  //log4j 로그를 쉽게 남기게 해준다.
@Controller //View 접근 요청에 대한 처리. 찾는 Contoller가 있다면 Template/내의 html로 연결.
//        dispathcer Servlet은 요청에 대응하는 Controller가 있는지 먼저 찾고 없으면 static에서 찾는다
@RequestMapping("/") //루트에서 ...클래스,메소드 레벨에서 매핑 정의. 요청이 발생하는 경로 지정...
public class HomeController {

  @GetMapping //Request에 대한 처리 클래스,메소드 지정. 별도 경로가 없다면 Request의 경로.
  public String home() {

    return "index"; //View
  }

//  payload 전달 방식
//  1. 쿼리 파라미터 : http://localhost:9080/y?op1=10&op2=20
//  2. url 경로에 포함 : http://localhost:9080/y/10/20 (공개가능하고 간단한 데이터처리)
//  3. 요청 메시지 바디에 포함 : 보안상 민감하고 용량이 많을때 POST 방식으로 처리. (ex. <form>)

//  서버 응답
//  1. html( view + data)
//  2. json( data)


// 1. http://localhost:9080/x?name=gildong&age=30

  @GetMapping("/x")
  public String home2(@RequestParam("name") String name,
                      @RequestParam("age") int age) {
    log.info("name:{}", name);
    log.info("age:{}", age);
    log.info("name:{}, age:{}", name, age);
    return "x"; //View
  }

  //  http://localhost:9080/y?op1=10&op2=20
  @GetMapping("/y")
  public String sum(
          @RequestParam("op1") int operand1,
          @RequestParam("op2") int operand2,
          Model model) {  //Model에 값을 전달해서 Template의 View에서 사용하게 할 수 있다.

    int sum = operand1 + operand2;
    log.info("{}+{}={}", operand1, operand2, sum);

    model.addAttribute("op1", operand1);
    model.addAttribute("op2", operand2);
    model.addAttribute("sum", sum);

    return "result";

  }

  // 2. http://localhost:9080/y/10/20
  @GetMapping("/y/{op1}/{op2}")
  public String sum2(
          @PathVariable("op1") int operand1,
          @PathVariable("op2") int operand2,
          Model model) {

    int sum = operand1 + operand2;
    log.info("{}+{}={}", operand1, operand2, sum);

    model.addAttribute("op1", operand1);
    model.addAttribute("op2", operand2);
    model.addAttribute("sum", sum);

    return "result";
  }

  // 1 + 2.  http://localhost:9080/y/10?op2=20
  @GetMapping("/y/{op1}")
  public String sum3(
          @PathVariable("op1") int operand1,
          @RequestParam("op2") int operand2,
          Model model) {

    int sum = operand1 + operand2;
    log.info("{}+{}={}", operand1, operand2, sum);

    model.addAttribute("op1", operand1);
    model.addAttribute("op2", operand2);
    model.addAttribute("sum", sum);

    return "result";
  }

  //  3.
//  덧셈 양식
  @GetMapping("/sum")
  public String formOfSum() {

    return "addForm";
  }

  //  덧셈 처리
  @PostMapping("sum")
  public String result(
          @RequestParam("op1") int op1,
          @RequestParam("op2") int op2,
          Model model) {

    int sum = op1 + op2;
    model.addAttribute("op1", op1);
    model.addAttribute("op2", op2);
    model.addAttribute("result", sum);

    return "addForm";
  }
}
