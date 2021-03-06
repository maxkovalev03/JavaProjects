package ru.spbstu.appmath.kovalev.calculator;

import ru.spbstu.appmath.kovalev.exceptions.CalculationException;

public class Complex implements Expression{
    private Expression left;
    private Expression right;
    private char operation;

    public Complex(final Expression left, final Expression right, final char operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public double calc(double x) throws CalculationException{
        double res_left = this.left.calc(x);
        double res_right = this.right.calc(x);
        double result;
        switch (this.operation) {
            case '+':
                result = res_left + res_right;
                break;
            case '-':
                result = res_left - res_right;
                break;
            case '*':
                result = res_left * res_right;
                break;
            case '/':
                if (res_right == 0)
                    throw new CalculationException("Division by zero");
                result = res_left / res_right;
                break;
            default:
                result = 0;
        }
        return result;
    }
}
