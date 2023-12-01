package com.example.sesac.controller;

import com.example.sesac.dto.UserDTO;
import com.example.sesac.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @GetMapping("/api")
    public String getApi() {
        return "request";
    }

    //  1) get: ?key=value
//  검색, 해시태그
//  /get/response1?name=abc&age=14
    @GetMapping("/get/response")
    public String getResponse1(@RequestParam(value = "name") String name, @RequestParam(value = "age") String age, Model model) {
//        @RequestParam : 요청의 파라미터를 매개변수로 받을 때 적는 어노테이션

//        value = ? 뒤에 넘어온key
//        required 값을 설정가능 (true(default)/false)
//

        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping("/get/response2")
    public String getResponse2(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }


    //    /get/response3/이름/나이
//    uri에 변수가 들어올 때 그 값을 가져오는 방법
    @GetMapping("/get/response3/{name}/{age}")
    public String getResponse3(@PathVariable String n, @PathVariable String age, Model model) {

        model.addAttribute("name", n);
        model.addAttribute("age", age);

        return "response";
    }

    @GetMapping({"/get/response4/{name}", "/get/response4/{name}/{age}"})
    public String getResponse4(@PathVariable(value = "name") String n, @PathVariable(required = false) String age, Model model) {


//        @Pathvariable에 require 설정이 가능하나, 기본값은 true
//        @Pathvariable에 required를 설정할 때는 GetMapping에 url도 같이 설정해줘야 한다.
//        required 값이 false인 경우 뒤로
        model.addAttribute("name", n);
        model.addAttribute("age", age);

        return "response";
    }


    //////////////////////////
//    post로 값을 전달할 때 그 값을 controller에서 받는 방법
    @PostMapping("/post/response1")
    public String postResponse1(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @PostMapping("/post/response2")
    public String postResponse2(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @PostMapping("/post/response3")
    @ResponseBody // res.send
//    return 하는 문자열의 template 파일을 불러오는 게 아니라
//    return 하는 문자열 그대로 값을 전달하는 것
    public String postResponse3(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @PostMapping("/post/test")
    @ResponseBody
    public String postTest(@RequestParam(value = "name") String name, @RequestParam(value = "gender") String gender,
                           @RequestParam(value = "year") Integer year,
                           @RequestParam(value = "month") Integer month,
                           @RequestParam(value = "day") Integer day,
                           @RequestParam(value = "interest") String interest,
                           Model model) {
        model.addAttribute("name", name);
        model.addAttribute("gender", gender);
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("interest", interest);


        return "이름 : " + name + "성별 : " + gender + "생년월일 : " + year + "-" + month + "-" +
                day + "관심사 : " + interest;

    }

    @GetMapping("/dto/response1")
    @ResponseBody
    public String dtoResponse1(@ModelAttribute UserDTO userDTO) {
//      변수로 값을 하나씩 가져오는 게 아니라 객체에 값을 담아서 가져오고 싶을 때 사용하는 방법
//      @ModelAttribute : html 폼 데이터를 컨트롤러로 전달할 때 객체에 매핑해주는 친구
//      json으로 넘어온 데이터를 읽지 못한다!! 값을 받아넣을 수가 없어서 null 출력됨!
//      @RequestParam = @ModelAttribute = query string으로 넘어온 데이터를 읽을 수 있다.
//      @RequestParam에 required 가 true => err발생함!
//      @RequestParam에 required 가 false => err가 발생하지는 않는다.(null)
//      매핑 = setter 함수를 실행한다.
//      => ?name=&age= => setName() setAge()


        String msg = "이름 : " + userDTO.getName() + "나이 : " + userDTO.getAge();

        return msg;

    }

    @PostMapping("/dto/response2")
    @ResponseBody
    public String dtoResponse2(UserDTO userDTO) {
//  아무것도 없는 상태 : @ModelAttribute 상태
        String msg = "이름 : " + userDTO.getName() + "나이 : " + userDTO.getAge();

        return msg;

    }


    @PostMapping("/dto/response3")
    @ResponseBody
    public String dtoResponse3(@RequestBody UserDTO userDTO)
    {
//        @RequestBody : 요청의 본문에 있는 데이터(Body)를 받아와서 객체에 매핑(필드값에 값을 주입)
//        전달받은 요청의 형식이 json 또는 xml 일 때만 실행이 가능
//        일반폼전송의 경우 = www-x-form-urlencoded

        String msg = "이름 : " + userDTO.getName() + "나이 : " + userDTO.getAge();

        return msg;

    }

    @GetMapping("/vo/response1")
    @ResponseBody
    public String voResponse1(UserVo userVo){
        String msg = "이름 : " + userVo.getName() + "나이 : " + userVo.getAge();

        return msg;
    }

    @GetMapping("/vo/response2")
    @ResponseBody
    public String voResponse2(UserVo userVo){
        String msg = "이름 : " + userVo.getName() + "나이 : " + userVo.getAge();

        return msg;
    }

    @GetMapping("/vo/response3")
    @ResponseBody
    public String voResponse3(UserVo userVo){
        String msg = "이름 : " + userVo.getName() + "나이 : " + userVo.getAge();

        return msg;
    }

//    get VO : null = @ModelAttribute(setter 함수를 실행할 수 없어서)
//    post VO - RequestBody X : null = @ModelAttribute
//    post VO - RequestBody O : @RequestBody를 이용해


    @PostMapping("/vo/registerTest")
    @ResponseBody
    public String registerTest(UserVo userVo) {

        return userVo.getName();
    }
}


