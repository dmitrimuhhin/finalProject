package ee.secretagency.homework.exercise1;


import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/calculator")
public class Calculator {

    // http://localhost:8080/calculator/add?a=5&b=15
    @GetMapping("/add")
    public int sum(@RequestParam(value = "a", defaultValue = "0") int a,
                   @RequestParam(value = "b", defaultValue = "0") int b) {
        return a+b;
    }

    @GetMapping("/div/{a}/{b}")
    public  <T> Serializable div(@PathVariable float a,
                                 @PathVariable float b){
        if(b==0){
            return "Can't divide with zero";
        } else {
            return a/b;
        }
    }

}
