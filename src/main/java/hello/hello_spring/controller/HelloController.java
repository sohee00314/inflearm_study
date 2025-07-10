package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello Spring!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        //"name" => key
        model.addAttribute("name", name);
        return "hello-mvc";
    }
    //hello-spring?name=*** 이면 name 위치에 ***이 출력
    @GetMapping("hello-spring")
    @ResponseBody
    public String helloSpring(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "hello"+name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    //객체를 넘기면 json 반환
    public Hello helloApi(@RequestParam(value = "name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    public static class Hello{
        private String name;
        //java 빈 표준 방식(private은 접근할 수 있도록 하는 것)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
