package study.studyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model)
    {
        model.addAttribute("data","hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam(name = "name", required = true) String name,Model model)
    {
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String hellostring(@RequestParam("name") String name)
    {
        return "hello" + name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name)
    {
        Hello hello = new Hello();
        Hello hello2 = new Hello();
        hello.setName(name);
        hello.setHe(hello2);
        hello2.setName("test");
        return hello;
    }

    static class Hello{
        private String name;

        public Hello getHe() {
            return he;
        }

        public void setHe(Hello he) {
            this.he = he;
        }

        private Hello he;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
