package com.iiitb.devopscalculator;
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
        double ans = Math.log(val1);
        model.addAttribute("something", "The answer is : " + ans);
        logger.info("The Natural log of " + val1 + " is " + ans);
        return "answer";
    }

    @RequestMapping(value="/calculator", method=RequestMethod.POST, params="action=root")
    public String square_root(@RequestParam("operation1") String op1, @RequestParam("operation2") String op2, Model model) {

        double val1 = Double.parseDouble(op1);
        double val2 = Double.parseDouble(op2);
        logger.info("[SQUARE ROOT] - " + val1);
        double ans = Math.sqrt(val1);
        model.addAttribute("something", "The answer is : " + ans);
        logger.info("The Square Root of " + val1 + " is " + ans);
        return "answer";
    }

    @RequestMapping(value="/calculator", method=RequestMethod.POST, params="action=fact")
    public String factorial(@RequestParam("operation1") String op1, @RequestParam("operation2") String op2, Model model) {


        double val1 = Double.parseDouble(op1);
        double val2 = Double.parseDouble(op2);
        logger.info("[FACTORIAL] - " + val1);
        BigInteger factorial = BigInteger.ONE;
        for(long i = 1; i <= val1; ++i){

            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        model.addAttribute("something", "The answer is : " + factorial);
        logger.info("The Factorial of " + val1 + " is " + factorial);
        return "answer";
    }

    @RequestMapping(value="/calculator", method=RequestMethod.POST, params="action=pow")
    public String power(@RequestParam("operation1") String op1, @RequestParam("operation2") String op2, Model model) {

        double val1 = Double.parseDouble(op1);
        double val2 = Double.parseDouble(op2);
        logger.info("[Power Operand 1] - " + val1);
        logger.info("[Power Operand 2] - " + val2);
        double ans = Math.pow(val1, val2);
        model.addAttribute("something", "The answer is : " + ans);
        logger.info("The Power of " + val1 + " raise to the power of " + val2 + " is " + ans);
        return "answer";
    }

    public double getLog(String a) {

        double val = Double.parseDouble(a);
        logger.info("[NATURAL LOG] - " + val);
        logger.info("The Natural LOG of " + val + " is " + Math.log(val));
        return Math.log(val);
    }

    public double getFact(String val1) {

        long val = Long.parseLong(val1);
        long factorial = 1;
        logger.info("[FACTORIAL] - " + val);
        for(long i = 1; i <= val; ++i){

            factorial = factorial * i;
        }
        logger.info("The Factorial of " + val + " is " + factorial);
        return factorial;
    }

    public double getPower(String op1, String op2) {
        double val1 = Double.parseDouble(op1);
        double val2 = Double.parseDouble(op2);

        logger.info("[Power Operand 1] - " + val1);
        logger.info("[Power Operand 2] - " + val2);

        logger.info("The Power of " + val1 + " raise to the power of " + val2 + " is " + Math.pow(val1, val2));
        return Math.pow(val1, val2);
    }

    public double getSquareRoot(String i) {

        double val = Double.parseDouble(i);
        logger.info("[SQUARE ROOT] - " + val);

        logger.info("The Square Root of " + val + " is " + Math.sqrt(val));
        return Math.sqrt(val);
    }
}
