package com.example.sesac.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("hi")
    public String getHi(Model model) {
        // Model model: 컨트롤러 클래스의 메소드가 파라미터로 받을 수 있는 객체
//    model.addAttribute("msg", "hi~");
//    return "hi";

        // 타임리프 표현식과 문법
        Hello hello = new Hello(99);
        List<String> names = Arrays.asList("Kim", "Lee", "Hong", "Park");
        model.addAttribute("hello", "Spring World");
        model.addAttribute("uText", "<strong>Hello</strong>");
        model.addAttribute("value", "이름을 입력하세요!");
        model.addAttribute("withValue", "hello");
        model.addAttribute("link", "hi");
        model.addAttribute("imgSrc", "KakaoTalk_20231123_152937586.jpg");
        model.addAttribute("userRole", "admin");
        model.addAttribute("isAdmin", false);
        model.addAttribute("names", names);
        model.addAttribute("classHello", hello);
        return "hi";
    }

    @GetMapping("people")
    public String getTest(Model model) {

        List<Person> person = new ArrayList<>();
        person.add(new Person("kim", 20));
        person.add(new Person("lee", 10));
        person.add(new Person("hong", 16));
        person.add(new Person("park", 22));
        person.add(new Person("choi", 30));


        model.addAttribute("age", 17);

        model.addAttribute("people", person);

        return "people";
    }



    class Hello {
        private int age;

        public Hello(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    class Person{
        String name;
        Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}