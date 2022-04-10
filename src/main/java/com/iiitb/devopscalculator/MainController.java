package com.iiitb.devopscalculator;
import org.glassfish.jersey.server.model.Suspendable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;


@Controller
public class MainController {

    @RequestMapping(value="/calculator", method=RequestMethod.POST, params="action=logarithm")
    public String logarithm(@RequestParam("operation1") String op1, @RequestParam("operation2") String op2, Model model) {
        double val1 = Double.parseDouble(op1);
        double val2 = Double.parseDouble(op2);
        model.addAttribute("something", "The answer is : " + Math.log(val1));
        return "answer";
    }

    @RequestMapping(value="/calculator", method=RequestMethod.POST, params="action=root")
    public String square_root(@RequestParam("operation1") String op1, @RequestParam("operation2") String op2, Model model) {

        double val1 = Double.parseDouble(op1);
        double val2 = Double.parseDouble(op2);
        model.addAttribute("something", "The answer is : " + Math.sqrt(val1));
        return "answer";
    }

    @RequestMapping(value="/calculator", method=RequestMethod.POST, params="action=fact")
    public String factorial(@RequestParam("operation1") String op1, @RequestParam("operation2") String op2, Model model) {


        double val1 = Double.parseDouble(op1);
        double val2 = Double.parseDouble(op2);
        BigInteger factorial = BigInteger.ONE;
        for(long i = 1; i <= val1; ++i){

            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        model.addAttribute("something", "The answer is : " + factorial);
        return "answer";
    }

    @RequestMapping(value="/calculator", method=RequestMethod.POST, params="action=pow")
    public String power(@RequestParam("operation1") String op1, @RequestParam("operation2") String op2, Model model) {

        double val1 = Double.parseDouble(op1);
        double val2 = Double.parseDouble(op2);
        model.addAttribute("something", "The answer is : " + Math.pow(val1,val2));
        return "answer";
    }
}
