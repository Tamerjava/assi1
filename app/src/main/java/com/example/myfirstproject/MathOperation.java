package com.example.myfirstproject;

public class MathOperation {
    private int operand1;
    private int operand2;
    private char operator;

    public MathOperation(int operand1, int operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public char getOperator() {
        return operator;
    }

    public int getAnswer() {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
