package com.codegym.model;

public class Calculate {
    public static float calculate(float FirstOperand, float SecondOperand,char operator){
        switch (operator){
            case '+':
                return FirstOperand+SecondOperand;
            case '-':
                return FirstOperand-SecondOperand;
            case '*':
                return FirstOperand*SecondOperand;
            case '/':
                if (SecondOperand != 0){
                    return FirstOperand/SecondOperand;
                }else{
                    throw new RuntimeException("Second Operand can't by zero");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
