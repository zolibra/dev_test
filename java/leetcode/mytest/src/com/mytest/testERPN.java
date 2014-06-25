package com.mytest;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p/>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p/>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class testERPN {

    private static int evalRPN(String[] tokens) {
        if (tokens == null | tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (!isOperator(tokens[i])) {
                stack.add(Integer.parseInt(tokens[i]));
            } else {
                if (stack.size() < 2) continue;
                int a = stack.pop();
                int b = stack.pop();
                if (tokens[i].equalsIgnoreCase("+")) {
                    stack.add(b + a);
                } else if (tokens[i].equalsIgnoreCase("-")) {
                    stack.add(b - a);
                } else if (tokens[i].equalsIgnoreCase("*")) {
                    stack.add(b * a);
                } else if (tokens[i].equalsIgnoreCase("/")) {
                    if (b == 0 || a == 0) {
                        stack.add(0);
                        continue;
                    }
                    stack.add(b / a);

                }
            }
        }

        return stack.pop();
    }

    public static int evalRPN2(String[] tokens) {
        int a, b;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            if (s.equals("+")) {
                S.add(S.pop() + S.pop());
            } else if (s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            } else if (s.equals("*")) {
                S.add(S.pop() * S.pop());
            } else if (s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            } else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }

    private static boolean isOperator(String s) {

        return s.equalsIgnoreCase("+") | s.equalsIgnoreCase("-") | s.equalsIgnoreCase("*") | s.equalsIgnoreCase("/");
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        String[] testData = {"2", "1", "+", "3", "*"};
        String[] testData2 = {"3", "0", "/"};
        System.out.println(evalRPN(testData));
        System.out.println(evalRPN(testData2));

    }
}
