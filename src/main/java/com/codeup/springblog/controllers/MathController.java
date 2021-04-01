package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {



    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String add(@PathVariable int x, @PathVariable int y){
        return x + " + " + y + " = " + (x + y);
    }

    @GetMapping("/subtract/{x}/and/{y}")
    @ResponseBody
    public String subtract(@PathVariable int x, @PathVariable int y){
        return x + " -" + y + " = " + (x - y);
    }


    @RequestMapping(path = "/subtract/{x}/from/{y}/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String subtractThree(@PathVariable int number){
        return number + " subtract 3 is " + (number - 3) + "!";
    }

    @RequestMapping(path = "/multiply/{x}/and/{y}/{number}", method = RequestMethod.GET)
    @ResponseBody
        public String multiply(@PathVariable int x, @PathVariable int y){
            return x + " * " + y + " = " + (x * y);
        }

    @RequestMapping(path = "/divide/{x}/by/{y}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int x, @PathVariable int y){
        return x + " / " + y + " = " + (x / y);
    }








}
