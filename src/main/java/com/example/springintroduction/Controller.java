package com.example.springintroduction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class Controller {
    @GetMapping("/")
    public String welcome(){
        return "WELCOME";
    }
    //Ved ikke hvad jeg skal gøre.........
    @GetMapping("echo")
    @ResponseBody
    public String echoInput(@RequestParam String HelloWorld){
        HelloWorld = "HelloWorld";
        return "input="+HelloWorld;
    }
    @GetMapping("/erDetFredag")
    public String erDetFredag(){
        int day = LocalDate.now().getDayOfMonth();
        int month = LocalDate.now().getMonthValue();
        int century = LocalDate.now().getYear()/100;
        int yearofcentury = LocalDate.now().getYear()%100;
        int math1 = (day+(((13*(month+1))/5)+yearofcentury+(yearofcentury/4)+(century/4)-2*yearofcentury)%7);
        int math2 = ((math1+5)%7)+1;
        if (math2 == 5){
            return "Det Fredag";
        }else{return "Det ikke fredag...";}
    }



}
