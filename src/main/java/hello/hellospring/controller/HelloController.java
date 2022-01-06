package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//컨트롤 팩키지 생성
//컨트롤러 생성
@Controller
//컨트롤러 어노테이션 직접입력
public class HelloController {
    @GetMapping("hello")
//    웹 어플리케이션에서 /hello를 사용하면 여기 메서드를 호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
        //      resources의 temlates 밑의 hello찾고 렌더링 한다
       /*
       컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.
        스프링 부트 템플릿엔진 기본 viewName 매핑
        resources:templates/ +{ViewName}+ .html
        */
    }

    @GetMapping("hello-mvc")//MVC와 템플릿엔진
    public String helloMvc(@RequestParam("name") String name, Model model) {
        //localhost:8080/hello-mvc?name=spring   cf)단축키cntl+P로 name 옵션확인하기
        model.addAttribute("name", name);//앞의 name은 hello-temlate의 name변수
        return "hello-template";
    }

    @GetMapping("hello-string")//API
    @ResponseBody// HTTP의 BODY에 문자 내용을 직접 반환. 즉, 데이터를 그대로 내려준다
    public String helloString(@RequestParam("name") String name, Model model) {
        return "hello" + name;//페이지 소스보기 해도 데이터만 뜬다 즉, 데이터를 그대로 내려준다,
    }

    //API를 많이 쓰는 예시
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, Model model) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;//객체가 반납될시 json으로 반납을 기본으로 한다
    }

    static class Hello{
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
