package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //웹어플리케이션에서 /hello라고 들어오면 이 메서드를 호출해준다.
    @GetMapping("hello")
    public String hello(Model model){
        //model은 MVC의 model, view, controller에서 바로 그 모델
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }


    @GetMapping("hello-string")
    //http 응답하는 body부에 데이터(return "hello" + name)를 직접 넣어주겠다.
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; //파라미터로 들어오는 name값에 따라 return값이 바뀐다.
                                //템플릿엔진과의 차이: view같은 게 없이 그 문자가 그대로 내려간다.
    }

    //위에꺼에서 발전해서 만약 문자가 아니라 데이터를 내노라고 하면?!
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setNum(44);
        return hello;
    }


    static class Hello{
        private String name;
        private int num;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
