package com.iiitb.devopscalculator;
import org.glassfish.jersey.server.model.Suspendable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.math.BigInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Controller
public class MainController {
    private static final Logger logger = LogManager.getLogger(MainController.class);
    @RequestMapping(value="/calculator", method=RequestMethod.POST, params="action=logarithm")
    public String logarithm(@RequestParam("operation1") String op1, @RequestParam("operation2") String op2, Model model) {
        double val1 = Double.parseDouble(op1);
        double val2 = Double.parseDouble(op2);
        logger.info("[NATURAL LOG] - " + val1);
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
