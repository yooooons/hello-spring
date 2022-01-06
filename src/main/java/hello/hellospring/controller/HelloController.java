package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
